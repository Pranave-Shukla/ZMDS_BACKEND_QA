package com.zoetis.zdms.model.dictionary.localized.booleanvalue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "LANG_BOOL", schema = "ZMDS_ODS")
@Immutable
@Data
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class LocalizedBooleanValue implements Serializable {

    @EmbeddedId
    private LocalizedBooleanValueId id;

    @Column(name = "BOOL_LANG")
    private String localizedValue;
}
