package com.zoetis.zdms.model;

import com.zoetis.zdms.converter.BooleanValueToStringConverter;
import com.zoetis.zdms.model.dictionary.BooleanValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.OffsetDateTime;

@Entity
@Table(name = "ZMDS_PRODUCT_MEDIA", schema = "ZMDS_ODS")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Getter
@Setter
public class ProductMediaFile implements Serializable {

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "SEQ_PRODUCT_MEDIA_ID", schema = "ZMDS_ODS", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "STATUS_ID", nullable = false)
    private ProductStatus productStatus;

    @Column(name = "MEDIA_FILE_NAME", length = 100)
    private String name;

    @Column(name = "MEDIA_FILE_PATH")
    private String path;

    @Column(name = "UPDATED_DATE")
    private OffsetDateTime updatedDate;

    @Column(name = "UPDATED_BY", length = 10)
    private String updatedBy;

    @Column(name = "PROCESSED_ETL", nullable = false)
    @Convert(converter = BooleanValueToStringConverter.class)
    private BooleanValue etlProcessed;

    @Column(name = "PROCESSED_APP", nullable = false)
    @Convert(converter = BooleanValueToStringConverter.class)
    private BooleanValue appProcessed;
}
