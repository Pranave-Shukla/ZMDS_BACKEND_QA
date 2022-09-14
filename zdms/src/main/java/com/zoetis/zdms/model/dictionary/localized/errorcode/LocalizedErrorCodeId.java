package com.zoetis.zdms.model.dictionary.localized.errorcode;

import com.zoetis.zdms.model.dictionary.Availability;
import com.zoetis.zdms.model.dictionary.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LocalizedErrorCodeId implements Serializable {

    @Column(name = "LANG")
    private String language;

    @Column(name = "ERROR_CODE")
    @Enumerated(EnumType.STRING)
    private ErrorCode errorCode;
}
