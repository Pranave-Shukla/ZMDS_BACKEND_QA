package com.zoetis.zdms.mapper;

import com.zoetis.zdms.api.dto.ProductDetailsResponseDto;
import com.zoetis.zdms.api.dto.ProductDto;
import com.zoetis.zdms.api.dto.ProductsResponseDto;
import com.zoetis.zdms.model.*;
import com.zoetis.zdms.model.view.ProductView;
import org.apache.commons.lang3.ObjectUtils;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring", uses = {DictionariesMapper.class, SourceSystemMapper.class})
public interface ProductMapper {

    default ProductsResponseDto pagedProductViewsToProductsResponseDto(Page<ProductView> pagedProductViews) {
        return pagedProductViewsToProductsResponseDto(pagedProductViews.getNumber(), pagedProductViews.getContent(),
                pagedProductViews.getTotalPages(), pagedProductViews.getTotalElements());
    }

    @Mapping(target = "pageInfo.pageNumber", source = "pageNumber")
    @Mapping(target = "pageInfo.totalElements", source = "totalElements")
    @Mapping(target = "pageInfo.totalPages", source = "totalPages")
    @Mapping(target = "products", source = "elements")
    ProductsResponseDto pagedProductViewsToProductsResponseDto(Integer pageNumber, List<ProductView> elements,
                                                               Integer totalPages, Long totalElements);

    @Mapping(target = "id", source = "productId")
    @Mapping(target = "statusId", source = "statusId")
    @Mapping(target = "sourceSystem", source = "productView.source")
    ProductDto productViewToProductDto(ProductView productView);


    @Mapping(target = "product.id", source = "product.id")
    @Mapping(target = "product.statusId", source = "productStatus.id")
    @Mapping(target = "product.price", source = "product.price")
    @Mapping(target = "product.isVisible", source = "productStatus.isVisible")
    @Mapping(target = "product.availability", source = "productStatus.availability")
    @Mapping(target = "product.minimumOrderQuantity", source = "productStatus.minimumOrderQuantity")
    @Mapping(target = "product.maximumOrderQuantity", source = "productStatus.maximumOrderQuantity")
    @Mapping(target = "product.associatedProducts", source = "productStatus.associatedProducts")
    @Mapping(target = "product.sourceSystem", source = "productStatus.sourceSystem")
    @Mapping(target = "product.imageFilename", source = "productMediaFile.name")
    @Mapping(target = "product.imageFilepath", source = "apiMediaFilepath")
    @Mapping(target = "product.imageUploadDate", source = "productMediaFile.updatedDate")
    ProductDetailsResponseDto productAndStatusAndMediaFileAndApiMediaFilepathToDto(Product product, ProductStatus productStatus,
                                                                              ProductMediaFile productMediaFile, String apiMediaFilepath);

    @Mapping(target = "product.id", source = "product.id")
    @Mapping(target = "product.statusId", source = "productStatus.id")
    @Mapping(target = "product.price", source = "product.price")
    @Mapping(target = "product.isVisible", source = "productStatus.isVisible")
    @Mapping(target = "product.availability", source = "productStatus.availability")
    @Mapping(target = "product.minimumOrderQuantity", source = "productStatus.minimumOrderQuantity")
    @Mapping(target = "product.maximumOrderQuantity", source = "productStatus.maximumOrderQuantity")
    @Mapping(target = "product.associatedProducts", source = "productStatus.associatedProducts")
    @Mapping(target = "product.sourceSystem", source = "productStatus.sourceSystem")
    ProductDetailsResponseDto productAndStatusToDto(Product product, ProductStatus productStatus);

    @AfterMapping
    default void addProductNameAndDescription(@MappingTarget ProductDetailsResponseDto result, Product product) {
        result.getProduct().setName(ObjectUtils.firstNonNull(product.getLocalName(), product.getGlobalName()));
        result.getProduct().setDescription(ObjectUtils.firstNonNull(product.getLocalDescription(), product.getGlobalDescription()));
    }

}
