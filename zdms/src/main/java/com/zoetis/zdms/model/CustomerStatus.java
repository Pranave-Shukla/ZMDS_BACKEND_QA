package com.zoetis.zdms.model;

import com.zoetis.zdms.converter.BooleanValueToStringConverter;
import com.zoetis.zdms.model.dictionary.BooleanValue;
import com.zoetis.zdms.model.dictionary.RejectionReason;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.OffsetDateTime;

@Entity
@Table(name = "ZMDS_CUSTOMER_STATUS", schema = "ZMDS_ODS")
@Data
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class CustomerStatus implements Serializable {

    @Id
    @Column(name = "ID")
    private String id;

    @OneToOne()
    @JoinColumn(name = "CUSTOMER_IN_ID", referencedColumnName = "id")
    private Customer customer;

    @Column(name = "CUSTOMER_STATUS_LOCAL")
    @Enumerated(EnumType.STRING)
    private com.zoetis.zdms.model.dictionary.CustomerStatus localStatus;

    @Column(name = "PROCESSED_ETL", insertable = false, updatable = false)
    @Convert(converter = BooleanValueToStringConverter.class)
    private BooleanValue etlProcessed;

    @Column(name = "PROCESSED_APP")
    @Convert(converter = BooleanValueToStringConverter.class)
    private BooleanValue appProcessed;

    @Column(name = "UPDATED_DATE")
    private OffsetDateTime updatedDate;

    @Column(name = "UPDATED_BY")
    private String updatedBy;

    @Column(name = "CUSTOMER_STATUS_REASON")
    @Enumerated(EnumType.STRING)
    private RejectionReason rejectionReason;

    @Column(name = "FREE_TEXT_LOCAL", length = 127)
    private String freeText;
}
