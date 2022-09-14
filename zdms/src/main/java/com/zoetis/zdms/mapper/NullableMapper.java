package com.zoetis.zdms.mapper;

import com.zoetis.zdms.api.dto.NullableBooleanValueDto;
import com.zoetis.zdms.api.dto.NullableProductAvailabilityDto;
import com.zoetis.zdms.model.NullableValue;
import com.zoetis.zdms.model.dictionary.Availability;
import com.zoetis.zdms.model.dictionary.BooleanValue;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.openapitools.jackson.nullable.JsonNullable;

@Mapper(componentModel = "spring")
public interface NullableMapper {

    @Named("unwrap")
    default <T> NullableValue<T> unwrap(JsonNullable<T> nullable) {
        return nullable.isPresent() ? NullableValue.of(nullable.get()) : NullableValue.undefined();
    }

    @Named("unwrapNullableBooleanValueDto")
    default NullableValue<BooleanValue> unwrapNullableBooleanValueDto(JsonNullable<NullableBooleanValueDto> nullable) {
        return nullable.isPresent() ? NullableValue.of(nullable.isPresent() ? BooleanValue.valueOf(nullable.get().getValue()) : null) : NullableValue.undefined();
    }

    @Named("unwrapNullableProductAvailabilityDto")
    default NullableValue<Availability> unwrapNullableProductAvailabilityDto(JsonNullable<NullableProductAvailabilityDto> nullable) {
        return nullable.isPresent() ? NullableValue.of(nullable.isPresent() ? Availability.valueOf(nullable.get().getValue()) : null) : NullableValue.undefined();
    }
}
