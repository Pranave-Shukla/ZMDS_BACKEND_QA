package com.zoetis.zdms.model;

import com.zoetis.zdms.converter.BooleanValueToStringConverter;
import com.zoetis.zdms.model.dictionary.Availability;
import com.zoetis.zdms.model.dictionary.BooleanValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Set;

@Entity
@Table(name = "ZMDS_PRODUCT_STATUS", schema = "ZMDS_ODS")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Getter
@Setter
public class ProductStatus implements Serializable {

    @Id
    @Column(name = "ID", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "PRODUCT_ID", insertable = false, nullable = false)
    private Integer productId;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", insertable = false, updatable = false, nullable = false)
    private Product product;

    @OneToMany(mappedBy = "productStatus", cascade = CascadeType.ALL)
    private Set<ProductMediaFile> productMediaFiles;

    @ManyToOne
    @JoinColumn(name = "SYSTEM_ID", insertable = false, updatable = false, nullable = false)
    private SourceSystem sourceSystem;

    @Column(name = "MIN_ORDER_QUANTITY", insertable = false)
    private Integer minimumOrderQuantity;

    @Column(name = "MAX_ORDER_QUANTITY", insertable = false)
    private Integer maximumOrderQuantity;

    @Column(name = "ASSOC_PRODUCTS", insertable = false)
    private String associatedProducts;

    @Column(name = "IS_VISIBLE", insertable = false, nullable = false)
    @Convert(converter = BooleanValueToStringConverter.class)
    private BooleanValue isVisible;

    @Column(name = "AVAILABILITY", insertable = false, nullable = false)
    @Enumerated(EnumType.STRING)
    private Availability availability;

    @Column(name = "UPDATED_DATE", insertable = false, nullable = false)
    private OffsetDateTime updatedDate;

    @Column(name = "UPDATED_BY", insertable = false, length = 10)
    private String updatedBy;

    @Column(name = "PROCESSED_ETL", insertable = false, updatable = false)
    @Convert(converter = BooleanValueToStringConverter.class)
    private BooleanValue etlProcessed;

    @Column(name = "PROCESSED_APP")
    @Convert(converter = BooleanValueToStringConverter.class)
    private BooleanValue appProcessed;
}
