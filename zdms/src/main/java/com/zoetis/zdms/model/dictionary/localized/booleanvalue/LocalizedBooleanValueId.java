package com.zoetis.zdms.model.dictionary.localized.booleanvalue;

import com.zoetis.zdms.converter.BooleanValueToStringConverter;
import com.zoetis.zdms.model.dictionary.BooleanValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LocalizedBooleanValueId implements Serializable {

    @Column(name = "LANG")
    private String language;

    @Column(name = "BOOL")
    @Convert(converter = BooleanValueToStringConverter.class)
    private BooleanValue value;
}
