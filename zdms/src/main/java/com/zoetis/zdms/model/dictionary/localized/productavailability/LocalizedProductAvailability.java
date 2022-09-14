package com.zoetis.zdms.model.dictionary.localized.productavailability;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "LANG_PROD_AVAILABILITY", schema = "ZMDS_ODS")
@Immutable
@Data
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class LocalizedProductAvailability implements Serializable {

    @EmbeddedId
    private LocalizedProductAvailabilityId id;

    @Column(name = "AVAILABILITY_LANG")
    private String localizedAvailability;
}
