package com.zoetis.zdms.model.dictionary.localized.customertype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "LANG_CUSTOMER_TYPE", schema = "ZMDS_ODS")
@Immutable
@Data
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class LocalizedCustomerType implements Serializable {

    @EmbeddedId
    private LocalizedCustomerTypeId id;

    @Column(name = "TYPE_LANG")
    private String localizedType;
}
