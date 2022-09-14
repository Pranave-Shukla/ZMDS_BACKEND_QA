package com.zoetis.zdms.model.dictionary.localized.errorcode;

import com.zoetis.zdms.model.dictionary.localized.customertype.LocalizedCustomerTypeId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "LANG_ERROR_CODE", schema = "ZMDS_ODS")
@Immutable
@Data
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class LocalizedErrorCode implements Serializable {

    @EmbeddedId
    private LocalizedErrorCodeId id;

    @Column(name = "ERROR_CODE_LANG")
    private String localizedErrorCode;
}

