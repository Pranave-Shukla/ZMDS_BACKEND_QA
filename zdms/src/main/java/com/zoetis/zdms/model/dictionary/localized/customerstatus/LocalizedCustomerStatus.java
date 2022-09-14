package com.zoetis.zdms.model.dictionary.localized.customerstatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "LANG_CUST_STATUS_NATIVE", schema = "ZMDS_ODS")
@Immutable
@Data
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class LocalizedCustomerStatus implements Serializable {

    @EmbeddedId
    private LocalizedCustomerStatusId id;

    @Column(name = "STATUS_LANG")
    private String localizedStatus;
}