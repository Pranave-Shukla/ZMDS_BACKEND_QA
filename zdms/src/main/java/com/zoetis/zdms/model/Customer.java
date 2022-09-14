package com.zoetis.zdms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.io.Serializable;
import java.time.OffsetDateTime;

@Entity
@Table(name = "ZMDS_CUSTOMER_IN", schema = "ZMDS_ODS")
@Data
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class Customer implements Serializable {

    @Id
    @Column(name = "ID", insertable = false, updatable = false)
    private String id;

    @Column(name = "TITLE", insertable = false, updatable = false)
    private String title;

    @Column(name = "FIRST_NAME", insertable = false, updatable = false)
    private String firstName;

    @Column(name = "LAST_NAME", insertable = false, updatable = false)
    private String lastName;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private CustomerStatus status;

    @Column(name = "STATE_NATIVE", insertable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private com.zoetis.zdms.model.dictionary.CustomerState state;

    @Column(name = "CUSTOMER_ERP_ID", insertable = false, updatable = false)
    private String erpId;

    @Column(name = "CUSTOMER_NATIVE_ID", insertable = false, updatable = false)
    private String nativeId;

    @Column(name = "CUSTOMER_TYPE", insertable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private com.zoetis.zdms.model.dictionary.CustomerType type;

    @Column(name = "COMPANY_NAME", insertable = false, updatable = false)
    private String companyName;

    @Formula("COMPANY_NAME || ' ' || TITLE || ' ' || FIRST_NAME || ' ' || LAST_NAME")
    private String formattedCompanyName;

    @Embedded
    @AttributeOverride(name = "countryCode", column = @Column(name = "COUNTRY_CODE", insertable = false, updatable = false))
    @AttributeOverride(name = "city", column = @Column(name = "CITY", insertable = false, updatable = false))
    @AttributeOverride(name = "postalCode", column = @Column(name = "POSTAL_CODE", insertable = false, updatable = false))
    @AttributeOverride(name = "street", column = @Column(name = "STREET", insertable = false, updatable = false))
    @AttributeOverride(name = "streetNumber", column = @Column(name = "STREET_NUMBER", insertable = false, updatable = false))
    private Address address;

    @Formula("STREET || ' ' || STREET_NUMBER || ' ' || CITY || ' ' || POSTAL_CODE")
    private String formattedAddress;

    @Column(name = "SOURCE", insertable = false, updatable = false)
    private String source;

    @Column(name = "DATE_CREATED_NATIVE", insertable = false, updatable = false)
    private OffsetDateTime nativeCreatedDate;
}
