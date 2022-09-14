package com.zoetis.zdms.service.impl;

import com.querydsl.core.types.Predicate;
import com.zoetis.zdms.dao.repository.ProductMediaFileRepository;
import com.zoetis.zdms.dao.repository.ProductRepository;
import com.zoetis.zdms.dao.repository.ProductViewRepository;
import com.zoetis.zdms.exception.IllegalParametersException;
import com.zoetis.zdms.exception.ProductNotFoundException;
import com.zoetis.zdms.exception.ProductStatusNotFound;
import com.zoetis.zdms.model.*;
import com.zoetis.zdms.model.dictionary.BooleanValue;
import com.zoetis.zdms.model.dictionary.Language;
import com.zoetis.zdms.model.dictionary.pageparameter.search.SearchBy;
import com.zoetis.zdms.model.dictionary.pageparameter.search.SearchByField;
import com.zoetis.zdms.model.dictionary.pageparameter.sort.SortBy;
import com.zoetis.zdms.model.dictionary.pageparameter.sort.SortDirection;
import com.zoetis.zdms.model.view.ProductView;
import com.zoetis.zdms.service.MediaFileService;
import com.zoetis.zdms.service.ProductService;
import com.zoetis.zdms.service.UserService;
import com.zoetis.zdms.service.impl.factory.PageFactory;
import com.zoetis.zdms.service.impl.factory.PredicateFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.time.OffsetDateTime;
import java.util.Base64;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Value("${media.file.api.products.base-path}")
    private String mediaFileApiProductsBasePath;

    private final PageFactory pageFactory;
    private final PredicateFactory predicateFactory;

    private final MediaFileService mediaFileService;
    private final UserService userService;

    private final ProductViewRepository productViewRepository;
    private final ProductRepository productRepository;
    private final ProductMediaFileRepository productMediaFileRepository;

    @Override
    public Page<ProductView> getProductViews(Integer pageNumber, Language language, Integer pageSize, SortDirection sortDirection,
                                             SortBy.Product sortBy, Set<SearchBy<SearchByField.Product>> searchBy) {
        log.info("[getProducts] started processing with parameters [pageNumber = {}, language = {}, pageSize = {}, sortDirection = {}, sortBy = {}]",
                pageNumber, language, pageSize, sortDirection, sortBy);

        if (ObjectUtils.anyNull(pageNumber, language, pageSize, sortDirection, sortBy, searchBy))
            throw IllegalParametersException.of(String.format("Parameters [%s, %s, %s, %s, %s] cannot be null", pageNumber, pageSize, sortDirection, sortBy, searchBy));

        Predicate predicate = predicateFactory.buildProductPredicate(searchBy, language);
        Pageable pageRequest = getPageRequestLimitedToLastPageNumber(pageNumber, pageSize, sortDirection, sortBy, predicate);

        log.debug("[ProductViewRepository.findAll] invoked with parameters [predicate = {}, pageRequest = {}]", predicate, pageRequest);
        return productViewRepository.findAll(predicate, pageRequest);
    }

    @Override
    public Product getProduct(String id) {
        log.info("[getProduct] started processing with parameters [id = {}]", id);

        if (ObjectUtils.anyNull(id))
            throw IllegalParametersException.of(String.format("Parameters [%s] cannot be null", id));

        log.debug("[ProductRepository.findById] invoked with parameters [id = {}]", id);
        return productRepository.findById(Integer.valueOf(id))
                .orElseThrow(() -> ProductNotFoundException.of("Product not found"));
    }

    @Override
    @Transactional
    public Product updateProduct(String id, String statusId, Boolean applyForAllSystems, ProductPartial productPartial) {
        log.info("[updateProduct] started processing with parameters [id = {}, applyForAllSystems = {}, productPartial = {}]",
                id, applyForAllSystems, productPartial);

        if (ObjectUtils.anyNull(id, applyForAllSystems, productPartial))
            throw IllegalParametersException.of(String.format("Parameters [%s, %s, %s] cannot be null", id, applyForAllSystems, productPartial));

        log.debug("[ProductRepository.findById] invoked with parameters [id = {}]", id);
        Product product = productRepository.findById(Integer.valueOf(id))
                .orElseThrow(() -> ProductNotFoundException.of("Product not found"));

        if (applyForAllSystems)
            updateAllProductStatuses(product, productPartial);
        else
            updateOneProductStatus(product, statusId, productPartial);


        log.debug("[ProductRepository.save] invoked with parameters [product = {}]", product);
        return productRepository.save(product);
    }

    @Override
    public ProductStatus getProductStatusForStatusId(Product product, String statusId) {
        return product.getProductStatuses()
                .stream()
                .filter(ps -> ps.getId().equals(Integer.valueOf(statusId)))
                .findFirst()
                .orElseThrow(() -> new ProductStatusNotFound("Product status not found"));
    }

    @Override
    public Optional<ProductMediaFile> getProductMediaFileForProductStatus(ProductStatus productStatus) {
        return productStatus.getProductMediaFiles()
                .stream()
                .findFirst();
    }

    @Override
    public String getProductApiMediaFilepath(ProductMediaFile productMediaFile, ProductStatus productStatus) {
        return mediaFileApiProductsBasePath + "/" + productMediaFile.getPath() + "/" + getMediaFileDiscName(productStatus, productMediaFile);
    }

    private Pageable getPageRequestLimitedToLastPageNumber(Integer pageNumber, Integer pageSize, SortDirection sortDirection,
                                                           SortBy.Product sortBy, Predicate predicate) {
        log.debug("[ProductViewRepository.count] invoked with parameters [predicate = {}]", predicate);
        long resultElementsCount = productViewRepository.count(predicate);

        return pageFactory.buildProductPageRequest(resultElementsCount, pageNumber, pageSize, sortDirection, sortBy);
    }

    private void updateAllProductStatuses(Product product, ProductPartial productPartial) {
        product.getProductStatuses()
                .forEach(productStatus -> {
                    String sourceSystemName = productStatus.getSourceSystem().getName();

                    updateMediaFile(productStatus, productPartial, sourceSystemName);

                    updateProductStatus(productStatus, productPartial);
                });
    }

    private void updateMediaFile(ProductStatus productStatus, ProductPartial productPartial, String sourceSystemName) {
        Set<ProductMediaFile> productMediaFiles = productStatus.getProductMediaFiles();

        // Database schema support multiple product medias, currently application logic allows to upload only one image
        Optional<ProductMediaFile> optionalProductMediaFile = productMediaFiles
                .stream()
                .findFirst();

        NullableValue<String> nullableImageBase64Value = productPartial.getImageBase64();

        if (nullableImageBase64Value.isPresent()) {
            Optional<String> nullableImageBase64 = Optional.ofNullable(nullableImageBase64Value.get());

            nullableImageBase64
                    .ifPresentOrElse(imageBase64 -> {
                        byte[] decodedImageBytes = Base64.getDecoder().decode(imageBase64);
                        String filename = productPartial.getImageFilename().get();

                        optionalProductMediaFile
                                .ifPresentOrElse(
                                        productMediaFile -> handleUpdateImage(productStatus, productMediaFile, productPartial, sourceSystemName, decodedImageBytes),
                                        () -> handleCreateImage(productStatus, sourceSystemName, filename, decodedImageBytes)
                                );
                    }, () -> optionalProductMediaFile
                            .ifPresent(productMediaFile -> handleRemoveImage(productStatus, productMediaFile)));
        }
    }

    private void updateOneProductStatus(Product product, String statusId, ProductPartial productPartial) {
        ProductStatus productStatus = product.getProductStatuses()
                .stream().filter(ps -> ps.getId().equals(Integer.valueOf(statusId)))
                .findFirst()
                .orElseThrow(() -> new ProductStatusNotFound("Product status not found"));
        String sourceSystemName = productStatus.getSourceSystem().getName();

        updateMediaFile(productStatus, productPartial, sourceSystemName);

        updateProductStatus(productStatus, productPartial);
    }

    private void handleCreateImage(ProductStatus productStatus, String sourceSystemName,
                                   String imageFilename, byte[] decodedImageBytes) {
        ProductMediaFile productMediaFile = createMediaFile(sourceSystemName, imageFilename);
        productMediaFile.setProductStatus(productStatus);

        log.debug("[ProductMediaFileRepository.save] invoked with parameters [productMediaFile = {}]", productMediaFile);
        productMediaFileRepository.save(productMediaFile);

        uploadMediaFileOnDisc(productStatus, productMediaFile, decodedImageBytes);
    }

    private void handleUpdateImage(ProductStatus productStatus, ProductMediaFile productMediaFile,
                                   ProductPartial productPartial, String sourceSystemName, byte[] decodedImageBytes) {
        deleteMediaFileFromDisc(productStatus, productMediaFile);
        updateMediaFile(productMediaFile, productPartial, sourceSystemName);

        uploadMediaFileOnDisc(productStatus, productMediaFile, decodedImageBytes);
    }

    private void handleRemoveImage(ProductStatus productStatus, ProductMediaFile productMediaFile) {
        deleteMediaFileFromDisc(productStatus, productMediaFile);
        deleteMediaFile(productStatus, productMediaFile);
    }

    private void updateMediaFile(ProductMediaFile productMediaFile, ProductPartial productPartial, String sourceSystemName) {
        setIfParameterNotUndefined(productMediaFile::setName, (productPartial.getImageFilename()));

        productMediaFile.setPath(sourceSystemName);

        productMediaFile.setAppProcessed(BooleanValue.TRUE);
        productMediaFile.setUpdatedBy(userService.getUser().getEmailAddress());
        productMediaFile.setUpdatedDate(OffsetDateTime.now());
    }

    private void deleteMediaFile(ProductStatus productStatus, ProductMediaFile productMediaFile) {
        productStatus.getProductMediaFiles()
                .remove(productMediaFile);
        productMediaFileRepository.delete(productMediaFile);
    }

    private ProductMediaFile createMediaFile(String sourceSystemName, String imageFilename) {
        ProductMediaFile productMediaFile = new ProductMediaFile();
        productMediaFile.setName(imageFilename);
        productMediaFile.setPath(sourceSystemName);

        productMediaFile.setEtlProcessed(BooleanValue.FALSE);
        productMediaFile.setAppProcessed(BooleanValue.TRUE);
        productMediaFile.setUpdatedBy(userService.getUser().getEmailAddress());
        productMediaFile.setUpdatedDate(OffsetDateTime.now());

        return productMediaFile;
    }

    private void deleteMediaFileFromDisc(ProductStatus productStatus, ProductMediaFile productMediaFile) {
        mediaFileService.deleteMediaFile(productMediaFile.getPath(), getMediaFileDiscFolderName(productStatus));
    }

    private void uploadMediaFileOnDisc(ProductStatus productStatus, ProductMediaFile productMediaFile, byte[] imageBytes) {
        mediaFileService.uploadMediaFile(productMediaFile.getPath(), getMediaFileDiscName(productStatus, productMediaFile), imageBytes);
    }

    private String getMediaFileDiscFolderName(ProductStatus productStatus) {
        return productStatus.getId().toString();
    }

    private String getMediaFileDiscName(ProductStatus productStatus, ProductMediaFile productMediaFile) {
        return productStatus.getId() + File.separator + productMediaFile.getName();
    }

    private void updateProductStatus(ProductStatus productStatus, ProductPartial productPartial) {
        setIfParameterNotUndefined(productStatus::setIsVisible, (productPartial.getIsVisible()));
        setIfParameterNotUndefined(productStatus::setAvailability, productPartial.getAvailability());
        setIfParameterNotUndefined(productStatus::setMinimumOrderQuantity, productPartial.getMinimumOrderQuantity());
        setIfParameterNotUndefined(productStatus::setMaximumOrderQuantity, productPartial.getMaximumOrderQuantity());
        setIfParameterNotUndefined(productStatus::setAssociatedProducts, productPartial.getAssociatedProducts());

        productStatus.setAppProcessed(BooleanValue.TRUE);
        productStatus.setUpdatedBy(userService.getUser().getEmailAddress());
        productStatus.setUpdatedDate(OffsetDateTime.now());
    }

    private <T> void setIfParameterNotUndefined(Consumer<T> function, NullableValue<T> parameter) {
        if (parameter.isPresent())
            function.accept(parameter.get());
    }
}
