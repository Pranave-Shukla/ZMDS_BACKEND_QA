package com.zoetis.zdms.rest;

import com.zoetis.zdms.api.dto.ProductDetailsResponseDto;
import com.zoetis.zdms.api.dto.ProductPartialRequestDto;
import com.zoetis.zdms.api.dto.ProductsRequestDto;
import com.zoetis.zdms.api.dto.ProductsResponseDto;
import com.zoetis.zdms.api.rest.ProductApi;
import com.zoetis.zdms.mapper.*;
import com.zoetis.zdms.model.Product;
import com.zoetis.zdms.model.ProductMediaFile;
import com.zoetis.zdms.model.ProductPartial;
import com.zoetis.zdms.model.ProductStatus;
import com.zoetis.zdms.model.dictionary.Language;
import com.zoetis.zdms.model.dictionary.pageparameter.search.SearchBy;
import com.zoetis.zdms.model.dictionary.pageparameter.search.SearchByField;
import com.zoetis.zdms.model.dictionary.pageparameter.sort.SortBy;
import com.zoetis.zdms.model.dictionary.pageparameter.sort.SortDirection;
import com.zoetis.zdms.model.view.ProductView;
import com.zoetis.zdms.rest.factory.ResponseEntityFactory;
import com.zoetis.zdms.service.ProductService;
import lombok.AllArgsConstructor;
import org.apache.commons.collections4.SetUtils;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class ProductController implements ProductApi {

    private final ProductService productService;

    private final ProductMapper productMapper;
    private final ProductPartialMapper productPartialMapper;
    private final SortDirectionMapper sortDirectionMapper;
    private final SortByMapper sortByMapper;
    private final LanguageMapper languageMapper;
    private final SearchByMapper searchByMapper;

    @Override
    public ResponseEntity<ProductsResponseDto> getProducts(ProductsRequestDto productsRequestDto) {
        SortDirection sortDirection = sortDirectionMapper.map(productsRequestDto.getSortDirection());
        SortBy.Product sortBy = sortByMapper.mapSortProductsByDto(productsRequestDto.getSortBy());
        Language language = languageMapper.map(productsRequestDto.getLanguage());
        Integer pageNumber = productsRequestDto.getPageNumber();
        Integer pageSize = productsRequestDto.getPageSize();

        Set<SearchBy<SearchByField.Product>> searchByList = SetUtils.emptyIfNull(productsRequestDto.getFilters())
                .stream()
                .map(searchByMapper::mapProductSearchByField)
                .collect(Collectors.toSet());

        Page<ProductView> products = productService.getProductViews(pageNumber, language, pageSize, sortDirection, sortBy, searchByList);
        ProductsResponseDto productsResponseDto = productMapper.pagedProductViewsToProductsResponseDto(products);

        return ResponseEntityFactory.buildOk(productsResponseDto);
    }

    @Override
    public ResponseEntity<ProductDetailsResponseDto> getProductDetails(String id, String statusId) {
        Product product = productService.getProduct(id);
        ProductStatus productStatus = productService.getProductStatusForStatusId(product, statusId);
        Optional<ProductMediaFile> productMediaFile = productService.getProductMediaFileForProductStatus(productStatus);
        ProductDetailsResponseDto productDetailsResponseDto = productMediaFile.map(
                        pmf -> {
                            String productApiMediaFilepath = productService.getProductApiMediaFilepath(pmf, productStatus);
                            return productMapper.productAndStatusAndMediaFileAndApiMediaFilepathToDto(product, productStatus, pmf, productApiMediaFilepath);
                        }
                )
                .orElse(productMapper.productAndStatusToDto(product, productStatus));

        return ResponseEntityFactory.buildOk(productDetailsResponseDto);
    }

    @Override
    public ResponseEntity<Void> updateProduct(String id, String statusId, ProductPartialRequestDto productPartialRequestDto, Boolean applyForAllSystems) {
        ProductPartial productPartial = productPartialMapper.mapProductPartialToDto(productPartialRequestDto.getProductPartial());

        productService.updateProduct(id, statusId, applyForAllSystems, productPartial);

        return ResponseEntityFactory.buildNoContent();
    }
}
