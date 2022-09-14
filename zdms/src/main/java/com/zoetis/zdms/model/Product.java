package com.zoetis.zdms.model;

import com.zoetis.zdms.converter.BooleanValueToStringConverter;
import com.zoetis.zdms.model.dictionary.BooleanValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Set;

@Entity
@Table(name = "ZMDS_PRODUCT_IN", schema = "ZMDS_ODS")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Immutable
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Getter
@Setter
public class Product implements Serializable {

    @Id
    @Column(name = "PRODUCT_ID", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "PRODUCT_LOCAL_NAME", insertable = false, nullable = false)
    private String localName;

    @Column(name = "PRODUCT_GLOBAL_NAME", insertable = false)
    private String globalName;

    @Column(name = "PRODUCT_LOCAL_DESC", insertable = false)
    private String localDescription;

    @Column(name = "PRODUCT_GLOBAL_DESC", insertable = false)
    private String globalDescription;

    @Column(name = "PRICE", insertable = false, nullable = false, precision = 2)
    private Double price;

    @Column(name = "PRICE_UNIT_OF_MEASURE", insertable = false, nullable = false, length = 3)
    private String priceUnitOfMeasure;

    @Column(name = "UPDATED_DATE_NATIVE", insertable = false, nullable = false)
    private OffsetDateTime nativeUpdatedDate;

    @Column(name = "UPDATED_DATE_LOCAL", insertable = false)
    private OffsetDateTime localUpdatedDate;

    @Column(name = "UPDATED_BY_RUNID", insertable = false, nullable = false)
    private Integer updatedByRunId;

    @Column(name = "PROCESSED_ETL", insertable = false, nullable = false)
    @Convert(converter = BooleanValueToStringConverter.class)
    private BooleanValue etlProcessed;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<ProductStatus> productStatuses;
}
