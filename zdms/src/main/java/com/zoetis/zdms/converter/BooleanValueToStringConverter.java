package com.zoetis.zdms.converter;

import com.zoetis.zdms.model.dictionary.BooleanValue;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Objects;

@Converter
public class BooleanValueToStringConverter implements AttributeConverter<BooleanValue, String> {

    private static final String POSITIVE = "Y";
    private static final String NEGATIVE = "N";

    @Override
    public String convertToDatabaseColumn(BooleanValue value) {
        if (Objects.isNull(value))
            return NEGATIVE;
        else {
            return value.equals(BooleanValue.TRUE) ? POSITIVE : NEGATIVE;
        }
    }

    @Override
    public BooleanValue convertToEntityAttribute(String value) {
        if (Objects.isNull(value))
            return BooleanValue.FALSE;
        else {
            return value.equals(POSITIVE) ? BooleanValue.TRUE : BooleanValue.FALSE;
        }
    }
}
