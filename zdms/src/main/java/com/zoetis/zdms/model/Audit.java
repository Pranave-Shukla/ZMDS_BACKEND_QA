package com.zoetis.zdms.model;

import com.zoetis.zdms.model.dictionary.DataSet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "ZMDS_AUDIT_LOG", schema = "ZMDS_ODS")
@Data
@Immutable
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class Audit {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "DATA_SET")
    @Enumerated(EnumType.STRING)
    private DataSet dataSet;

    @Column(name = "TRANSACTION_HEADER", length = 300)
    private String transactionHeader;

    @Column(name = "TRANSACTION_MESSAGE", length = 1024)
    private String transactionMessage;

    @Column(name = "LOG_BY", length = 128)
    private String logBy;

    @Column(name = "LOG_TIME", length = 3000)
    private OffsetDateTime logTime;
}
