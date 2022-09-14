package com.zoetis.zdms.model.dictionary.localized.rejectionreason;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "LANG_CUST_REASON", schema = "ZMDS_ODS")
@Immutable
@Data
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class LocalizedRejectionReason implements Serializable {

    @EmbeddedId
    private LocalizedRejectionReasonId id;

    @Column(name = "REASON_LANG")
    private String localizedRejectionReason;
}
