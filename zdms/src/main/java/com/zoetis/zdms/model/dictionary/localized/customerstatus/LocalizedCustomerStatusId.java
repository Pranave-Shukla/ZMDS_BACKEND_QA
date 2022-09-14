package com.zoetis.zdms.model.dictionary.localized.customerstatus;

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
public class LocalizedCustomerStatusId implements Serializable {

    @Column(name = "LANG")
    private String language;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private com.zoetis.zdms.model.dictionary.CustomerStatus status;
}


