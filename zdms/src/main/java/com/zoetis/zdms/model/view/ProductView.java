package com.zoetis.zdms.model.view;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zoetis.zdms.converter.BooleanValueToStringConverter;
import com.zoetis.zdms.model.dictionary.Availability;
import com.zoetis.zdms.model.dictionary.BooleanValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ZMDS_PRODUCT_IN_VIEW", schema = "ZMDS_ODS")
@Data
@Immutable
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class ProductView implements Serializable {

    @Id
    @Column(name="UUID")
    @JsonIgnore
    private String uuid;

    @Column(name = "PRODUCT_ID", nullable = false)
    private Integer productId;

    @Column(name = "STATUS_ID", nullable = false)
    private Integer statusId;

    @Column(name = "IS_VISIBLE", nullable = false)
    @Convert(converter = BooleanValueToStringConverter.class)
    private BooleanValue isVisible;

    @Column(name = "IS_VISIBLE_LOCALIZED", nullable = false)
    private String isVisibleLocalized;

    @Column(name = "IS_VISIBLE_LANGUAGE", nullable = false)
    private String isVisibleLanguage;

    @Column(name = "AVAILABILITY", insertable = false, nullable = false)
    @Enumerated(EnumType.STRING)
    private Availability availability;

    @Column(name = "AVAILABILITY_LOCALIZED", nullable = false)
    private String availabilityLocalized;

    @Column(name = "AVAILABILITY_LANGUAGE", nullable = false)
    private String availabilityLanguage;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "MINIMUM_ORDER_QUANTITY")
    private Integer minimumOrderQuantity;

    @Column(name = "MAXIMUM_ORDER_QUANTITY")
    private Integer maximumOrderQuantity;

    @Column(name = "HAS_MEDIA", nullable = false)
    @Convert(converter = BooleanValueToStringConverter.class)
    private BooleanValue hasMedia;

    @Column(name = "HAS_MEDIA_LOCALIZED", nullable = false)
    private String hasMediaLocalized;

    @Column(name = "HAS_MEDIA_LANGUAGE", nullable = false)
    private String hasMediaLanguage;

    @Column(name = "SOURCE", nullable = false)
    private String source;
}
