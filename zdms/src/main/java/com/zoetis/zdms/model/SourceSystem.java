package com.zoetis.zdms.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "ZMDS_SYSTEM", schema = "ZMDS_ODS")
@Immutable
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Getter
@Setter
public class SourceSystem implements Serializable {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME", length = 50)
    private String name;

    @Column(name = "DEFAULT_LANGUAGE", length = 10)
    private String defaultLanguage;

    @OneToMany(mappedBy = "sourceSystem")
    private Set<ProductStatus> productStatuses;
}
