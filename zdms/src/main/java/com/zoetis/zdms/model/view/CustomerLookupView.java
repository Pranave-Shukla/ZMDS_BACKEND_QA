package com.zoetis.zdms.model.view;

import com.zoetis.zdms.converter.BooleanValueToStringConverter;
import com.zoetis.zdms.model.ContactDetails;
import com.zoetis.zdms.model.dictionary.AccountType;
import com.zoetis.zdms.model.dictionary.BooleanValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "V_ZMDR_CUSTOMER_LOOKUP")
@Data
@Immutable
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class CustomerLookupView implements Serializable {

    @Id
    @Column(name = "ID", nullable = false, length = 20)
    private String id;

    @Embedded
    @AttributeOverride(name = "searchTerms", column = @Column(name = "SEARCH_TERMS"))
    @AttributeOverride(name = "phoneNumber", column = @Column(name = "PHONE_NUMBER"))
    @AttributeOverride(name = "email", column = @Column(name = "EMAIL_ADDRESS"))
    private ContactDetails contactDetails;

    @Column(name = "CUSTOMER_NAME_1")
    private String name1;

    @Column(name = "CUSTOMER_NAME_2")
    private String name2;

    @Column(name = "CUSTOMER_NAME_3")
    private String name3;

    @Column(name = "CUSTOMER_NAME_4")
    private String name4;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "ACCOUNT_TYPE")
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Column(name = "CUSTOMER_ADDRESS")
    private String streetAddress;

    @Column(name = "POSTAL_CODE")
    private String postalCode;

    @Column(name = "COUNTRY_CODE")
    private String countryCode;

    @Column(name = "CITY")
    private String city;

    @Column(name = "IS_DELETED", nullable = false)
    @Convert(converter = BooleanValueToStringConverter.class)
    private BooleanValue isdDeleted;
}
