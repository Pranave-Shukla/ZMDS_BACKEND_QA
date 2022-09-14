package com.zoetis.zdms.mapper;

import com.zoetis.zdms.api.dto.BooleanValueDto;
import com.zoetis.zdms.api.dto.PageInfoDto;
import com.zoetis.zdms.api.dto.ProductAvailabilityDto;
import com.zoetis.zdms.api.dto.ProductDetailsDto;
import com.zoetis.zdms.api.dto.ProductDetailsResponseDto;
import com.zoetis.zdms.api.dto.ProductDto;
import com.zoetis.zdms.api.dto.ProductsResponseDto;
import com.zoetis.zdms.model.Product;
import com.zoetis.zdms.model.ProductMediaFile;
import com.zoetis.zdms.model.ProductStatus;
import com.zoetis.zdms.model.dictionary.Availability;
import com.zoetis.zdms.model.dictionary.BooleanValue;
import com.zoetis.zdms.model.view.ProductView;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-22T09:15:30-0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Autowired
    private SourceSystemMapper sourceSystemMapper;

    @Override
    public ProductsResponseDto pagedProductViewsToProductsResponseDto(Integer pageNumber, List<ProductView> elements, Integer totalPages, Long totalElements) {
        if ( pageNumber == null && elements == null && totalPages == null && totalElements == null ) {
            return null;
        }

        ProductsResponseDto productsResponseDto = new ProductsResponseDto();

        if ( pageNumber != null ) {
            if ( productsResponseDto.getPageInfo() == null ) {
                productsResponseDto.setPageInfo( new PageInfoDto() );
            }
            integerToPageInfoDto( pageNumber, productsResponseDto.getPageInfo() );
        }
        if ( elements != null ) {
            productsResponseDto.setProducts( productViewListToProductDtoList( elements ) );
        }
        if ( totalPages != null ) {
            if ( productsResponseDto.getPageInfo() == null ) {
                productsResponseDto.setPageInfo( new PageInfoDto() );
            }
            integerToPageInfoDto1( totalPages, productsResponseDto.getPageInfo() );
        }
        if ( totalElements != null ) {
            if ( productsResponseDto.getPageInfo() == null ) {
                productsResponseDto.setPageInfo( new PageInfoDto() );
            }
            longToPageInfoDto( totalElements, productsResponseDto.getPageInfo() );
        }

        return productsResponseDto;
    }

    @Override
    public ProductDto productViewToProductDto(ProductView productView) {
        if ( productView == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        if ( productView.getProductId() != null ) {
            productDto.setId( String.valueOf( productView.getProductId() ) );
        }
        if ( productView.getStatusId() != null ) {
            productDto.setStatusId( String.valueOf( productView.getStatusId() ) );
        }
        productDto.setSourceSystem( sourceSystemMapper.mapSourceSystemNameToDto( productView.getSource() ) );
        productDto.setIsVisible( booleanValueToBooleanValueDto( productView.getIsVisible() ) );
        productDto.setAvailability( availabilityToProductAvailabilityDto( productView.getAvailability() ) );
        productDto.setDescription( productView.getDescription() );
        productDto.setMinimumOrderQuantity( productView.getMinimumOrderQuantity() );
        productDto.setMaximumOrderQuantity( productView.getMaximumOrderQuantity() );
        productDto.setHasMedia( booleanValueToBooleanValueDto( productView.getHasMedia() ) );

        return productDto;
    }

    @Override
    public ProductDetailsResponseDto productAndStatusAndMediaFileAndApiMediaFilepathToDto(Product product, ProductStatus productStatus, ProductMediaFile productMediaFile, String apiMediaFilepath) {
        if ( product == null && productStatus == null && productMediaFile == null && apiMediaFilepath == null ) {
            return null;
        }

        ProductDetailsResponseDto productDetailsResponseDto = new ProductDetailsResponseDto();

        if ( product != null ) {
            if ( productDetailsResponseDto.getProduct() == null ) {
                productDetailsResponseDto.setProduct( new ProductDetailsDto() );
            }
            productToProductDetailsDto( product, productDetailsResponseDto.getProduct() );
        }
        if ( productStatus != null ) {
            if ( productDetailsResponseDto.getProduct() == null ) {
                productDetailsResponseDto.setProduct( new ProductDetailsDto() );
            }
            productStatusToProductDetailsDto( productStatus, productDetailsResponseDto.getProduct() );
        }
        if ( productMediaFile != null ) {
            if ( productDetailsResponseDto.getProduct() == null ) {
                productDetailsResponseDto.setProduct( new ProductDetailsDto() );
            }
            productMediaFileToProductDetailsDto( productMediaFile, productDetailsResponseDto.getProduct() );
        }
        if ( apiMediaFilepath != null ) {
            if ( productDetailsResponseDto.getProduct() == null ) {
                productDetailsResponseDto.setProduct( new ProductDetailsDto() );
            }
            stringToProductDetailsDto( apiMediaFilepath, productDetailsResponseDto.getProduct() );
        }

        addProductNameAndDescription( productDetailsResponseDto, product );

        return productDetailsResponseDto;
    }

    @Override
    public ProductDetailsResponseDto productAndStatusToDto(Product product, ProductStatus productStatus) {
        if ( product == null && productStatus == null ) {
            return null;
        }

        ProductDetailsResponseDto productDetailsResponseDto = new ProductDetailsResponseDto();

        if ( product != null ) {
            if ( productDetailsResponseDto.getProduct() == null ) {
                productDetailsResponseDto.setProduct( new ProductDetailsDto() );
            }
            productToProductDetailsDto1( product, productDetailsResponseDto.getProduct() );
        }
        if ( productStatus != null ) {
            if ( productDetailsResponseDto.getProduct() == null ) {
                productDetailsResponseDto.setProduct( new ProductDetailsDto() );
            }
            productStatusToProductDetailsDto1( productStatus, productDetailsResponseDto.getProduct() );
        }

        addProductNameAndDescription( productDetailsResponseDto, product );

        return productDetailsResponseDto;
    }

    protected void integerToPageInfoDto(Integer integer, PageInfoDto mappingTarget) {
        if ( integer == null ) {
            return;
        }

        mappingTarget.setPageNumber( integer );
    }

    protected void longToPageInfoDto(Long long1, PageInfoDto mappingTarget) {
        if ( long1 == null ) {
            return;
        }

        mappingTarget.setTotalElements( long1 );
    }

    protected void integerToPageInfoDto1(Integer integer, PageInfoDto mappingTarget) {
        if ( integer == null ) {
            return;
        }

        mappingTarget.setTotalPages( integer );
    }

    protected List<ProductDto> productViewListToProductDtoList(List<ProductView> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductDto> list1 = new ArrayList<ProductDto>( list.size() );
        for ( ProductView productView : list ) {
            list1.add( productViewToProductDto( productView ) );
        }

        return list1;
    }

    protected BooleanValueDto booleanValueToBooleanValueDto(BooleanValue booleanValue) {
        if ( booleanValue == null ) {
            return null;
        }

        BooleanValueDto booleanValueDto;

        switch ( booleanValue ) {
            case TRUE: booleanValueDto = BooleanValueDto.TRUE;
            break;
            case FALSE: booleanValueDto = BooleanValueDto.FALSE;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + booleanValue );
        }

        return booleanValueDto;
    }

    protected ProductAvailabilityDto availabilityToProductAvailabilityDto(Availability availability) {
        if ( availability == null ) {
            return null;
        }

        ProductAvailabilityDto productAvailabilityDto;

        switch ( availability ) {
            case AVAILABLE: productAvailabilityDto = ProductAvailabilityDto.AVAILABLE;
            break;
            case NOT_AVAILABLE: productAvailabilityDto = ProductAvailabilityDto.NOT_AVAILABLE;
            break;
            case SHORT_TERM_NOT_AVAILABLE: productAvailabilityDto = ProductAvailabilityDto.SHORT_TERM_NOT_AVAILABLE;
            break;
            case MEDIUM_TERM_NOT_AVAILABLE: productAvailabilityDto = ProductAvailabilityDto.MEDIUM_TERM_NOT_AVAILABLE;
            break;
            case LONG_TERM_NOT_AVAILABLE: productAvailabilityDto = ProductAvailabilityDto.LONG_TERM_NOT_AVAILABLE;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + availability );
        }

        return productAvailabilityDto;
    }

    protected void productToProductDetailsDto(Product product, ProductDetailsDto mappingTarget) {
        if ( product == null ) {
            return;
        }

        if ( product.getId() != null ) {
            mappingTarget.setId( String.valueOf( product.getId() ) );
        }
        else {
            mappingTarget.setId( null );
        }
        mappingTarget.setPrice( product.getPrice() );
    }

    protected void productStatusToProductDetailsDto(ProductStatus productStatus, ProductDetailsDto mappingTarget) {
        if ( productStatus == null ) {
            return;
        }

        if ( productStatus.getId() != null ) {
            mappingTarget.setStatusId( String.valueOf( productStatus.getId() ) );
        }
        else {
            mappingTarget.setStatusId( null );
        }
        mappingTarget.setIsVisible( booleanValueToBooleanValueDto( productStatus.getIsVisible() ) );
        mappingTarget.setAvailability( availabilityToProductAvailabilityDto( productStatus.getAvailability() ) );
        mappingTarget.setMinimumOrderQuantity( productStatus.getMinimumOrderQuantity() );
        mappingTarget.setMaximumOrderQuantity( productStatus.getMaximumOrderQuantity() );
        mappingTarget.setAssociatedProducts( productStatus.getAssociatedProducts() );
        mappingTarget.setSourceSystem( sourceSystemMapper.mapSourceSystemToDto( productStatus.getSourceSystem() ) );
    }

    protected void productMediaFileToProductDetailsDto(ProductMediaFile productMediaFile, ProductDetailsDto mappingTarget) {
        if ( productMediaFile == null ) {
            return;
        }

        mappingTarget.setImageFilename( productMediaFile.getName() );
        mappingTarget.setImageUploadDate( productMediaFile.getUpdatedDate() );
    }

    protected void stringToProductDetailsDto(String string, ProductDetailsDto mappingTarget) {
        if ( string == null ) {
            return;
        }

        mappingTarget.setImageFilepath( string );
    }

    protected void productToProductDetailsDto1(Product product, ProductDetailsDto mappingTarget) {
        if ( product == null ) {
            return;
        }

        if ( product.getId() != null ) {
            mappingTarget.setId( String.valueOf( product.getId() ) );
        }
        else {
            mappingTarget.setId( null );
        }
        mappingTarget.setPrice( product.getPrice() );
    }

    protected void productStatusToProductDetailsDto1(ProductStatus productStatus, ProductDetailsDto mappingTarget) {
        if ( productStatus == null ) {
            return;
        }

        if ( productStatus.getId() != null ) {
            mappingTarget.setStatusId( String.valueOf( productStatus.getId() ) );
        }
        else {
            mappingTarget.setStatusId( null );
        }
        mappingTarget.setIsVisible( booleanValueToBooleanValueDto( productStatus.getIsVisible() ) );
        mappingTarget.setAvailability( availabilityToProductAvailabilityDto( productStatus.getAvailability() ) );
        mappingTarget.setMinimumOrderQuantity( productStatus.getMinimumOrderQuantity() );
        mappingTarget.setMaximumOrderQuantity( productStatus.getMaximumOrderQuantity() );
        mappingTarget.setAssociatedProducts( productStatus.getAssociatedProducts() );
        mappingTarget.setSourceSystem( sourceSystemMapper.mapSourceSystemToDto( productStatus.getSourceSystem() ) );
    }
}
