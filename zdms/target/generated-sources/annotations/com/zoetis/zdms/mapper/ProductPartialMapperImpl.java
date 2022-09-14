package com.zoetis.zdms.mapper;

import com.zoetis.zdms.api.dto.ProductPartialDto;
import com.zoetis.zdms.model.ProductPartial;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-22T09:15:31-0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11 (Oracle Corporation)"
)
@Component
public class ProductPartialMapperImpl implements ProductPartialMapper {

    @Autowired
    private NullableMapper nullableMapper;

    @Override
    public ProductPartial mapProductPartialToDto(ProductPartialDto productPartialDto) {
        if ( productPartialDto == null ) {
            return null;
        }

        ProductPartial productPartial = new ProductPartial();

        productPartial.setImageBase64( nullableMapper.unwrap( productPartialDto.getImage() ) );
        productPartial.setIsVisible( nullableMapper.unwrapNullableBooleanValueDto( productPartialDto.getIsVisible() ) );
        productPartial.setAvailability( nullableMapper.unwrapNullableProductAvailabilityDto( productPartialDto.getAvailability() ) );
        productPartial.setMinimumOrderQuantity( nullableMapper.unwrap( productPartialDto.getMinimumOrderQuantity() ) );
        productPartial.setMaximumOrderQuantity( nullableMapper.unwrap( productPartialDto.getMaximumOrderQuantity() ) );
        productPartial.setAssociatedProducts( nullableMapper.unwrap( productPartialDto.getAssociatedProducts() ) );
        productPartial.setImageFilename( nullableMapper.unwrap( productPartialDto.getImageFilename() ) );

        return productPartial;
    }
}
