package com.zoetis.zdms.model.view;

import com.zoetis.zdms.model.dictionary.RejectionReason;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.io.Serializable;
import java.time.OffsetDateTime;

@Entity
@Table(name = "ZMDS_CUSTOMER_IN_VIEW", schema = "ZMDS_ODS")
@Data
@Immutable
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class CustomerView implements Serializable {

    @Id
    @Column(name = "CUSTOMER_ID", nullable = false)
    private String id;

    @Column(name = "ERP_ID", nullable = false)
    private String erpId;

    @Column(name = "LOCAL_STATUS")
    @Enumerated(EnumType.STRING)
    private com.zoetis.zdms.model.dictionary.CustomerStatus localStatus;

    @Column(name = "LOCAL_STATUS_LOCALIZED", nullable = false)
    private String localStatusLocalized;

    @Column(name = "LOCAL_STATUS_LANGUAGE", nullable = false)
    private String localStatusLanguage;

    @Column(name = "STATE_NATIVE",  nullable = false)
    @Enumerated(EnumType.STRING)
    private com.zoetis.zdms.model.dictionary.CustomerState state;

    @Column(name = "STATE_NATIVE_LOCALIZED", nullable = false)
    private String stateNativeLocalized;

    @Column(name = "STATE_NATIVE_LANGUAGE", nullable = false)
    private String stateNativeLanguage;

    @Column(name = "COMPANY_NAME", nullable = false)
    private String companyName;

    @Column(name = "ADDRESS", nullable = false)
    private String address;

    @Column(name = "TYPE", insertable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private com.zoetis.zdms.model.dictionary.CustomerType type;

    @Column(name = "TYPE_LOCALIZED")
    private String typeLocalized;

    @Column(name = "TYPE_LANGUAGE")
    private String typeLanguage;

    @Column(name = "SOURCE")
    private String source;

    @Column(name = "REJECTION_REASON")
    @Enumerated(EnumType.STRING)
    private RejectionReason rejectionReason;

    @Column(name = "REJECTION_REASON_LOCALIZED")
    private String rejectionReasonLocalized;

    @Column(name = "REJECTION_REASON_LANGUAGE")
    private String rejectionReasonLanguage;

    @Column(name = "NATIVE_CREATED_DATE")
    private OffsetDateTime nativeCreatedDate;
}
