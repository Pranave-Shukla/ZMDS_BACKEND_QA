package com.zoetis.zdms.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zoetis.zdms.IntegrationTest;
import com.zoetis.zdms.api.dto.NullableBooleanValueDto;
import com.zoetis.zdms.api.dto.NullableProductAvailabilityDto;
import com.zoetis.zdms.api.dto.ProductPartialDto;
import org.junit.jupiter.api.Test;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JacksonConfigTest extends IntegrationTest {

    @Autowired
    private ObjectMapper mapper;

    @Test
    void shouldUseJsonNullableModule() throws JsonProcessingException {
        String productPartialJson = "{\"isVisible\":\"FALSE\",\"availability\":\"LONG_TERM_NOT_AVAILABLE\",\"minimumOrderQuantity\":\"2\",\"maximumOrderQuantity\": null}";
        ProductPartialDto mappedProductPartialDTO = mapper.readValue(productPartialJson, ProductPartialDto.class);

        assertEquals(JsonNullable.of(NullableBooleanValueDto.FALSE), mappedProductPartialDTO.getIsVisible());
        assertEquals(JsonNullable.of(NullableProductAvailabilityDto.LONG_TERM_NOT_AVAILABLE), mappedProductPartialDTO.getAvailability());
        assertEquals(JsonNullable.of(2), mappedProductPartialDTO.getMinimumOrderQuantity());
        assertEquals(JsonNullable.of(null), mappedProductPartialDTO.getMaximumOrderQuantity());
        assertEquals(JsonNullable.undefined(), mappedProductPartialDTO.getAssociatedProducts());
        assertEquals(JsonNullable.undefined(), mappedProductPartialDTO.getImage());
        assertEquals(JsonNullable.undefined(), mappedProductPartialDTO.getImageFilename());
    }
}
