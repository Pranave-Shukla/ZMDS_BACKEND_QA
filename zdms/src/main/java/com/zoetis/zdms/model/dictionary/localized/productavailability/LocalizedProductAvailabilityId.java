package com.zoetis.zdms.model.dictionary.localized.productavailability;

import com.zoetis.zdms.model.dictionary.Availability;
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
public class LocalizedProductAvailabilityId implements Serializable {

    @Column(name = "LANG")
    private String language;

    @Column(name = "AVAILABILITY")
    @Enumerated(EnumType.STRING)
    private Availability availability;
}
