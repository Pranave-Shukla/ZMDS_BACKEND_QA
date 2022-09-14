package com.zoetis.zdms.mapper;

import com.zoetis.zdms.api.dto.ProductPartialDto;
import com.zoetis.zdms.model.ProductPartial;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {NullableMapper.class, DictionariesMapper.class})
public interface ProductPartialMapper {

    @Mapping(target = "imageBase64", source = "image", qualifiedByName = "unwrap")
    @Mapping(target = "isVisible", source = "isVisible", qualifiedByName = "unwrapNullableBooleanValueDto")
    @Mapping(target = "availability", source = "availability",qualifiedByName = "unwrapNullableProductAvailabilityDto")
    @Mapping(target = "minimumOrderQuantity", source = "minimumOrderQuantity", qualifiedByName = "unwrap")
    @Mapping(target = "maximumOrderQuantity", source = "maximumOrderQuantity", qualifiedByName = "unwrap")
    @Mapping(target = "associatedProducts", source = "associatedProducts", qualifiedByName = "unwrap")
    @Mapping(target = "imageFilename", source = "imageFilename", qualifiedByName = "unwrap")
    ProductPartial mapProductPartialToDto(ProductPartialDto productPartialDto);
}
