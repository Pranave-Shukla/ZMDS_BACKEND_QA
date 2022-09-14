package com.zoetis.zdms.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAudit is a Querydsl query type for Audit
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAudit extends EntityPathBase<Audit> {

    private static final long serialVersionUID = 1934559179L;

    public static final QAudit audit = new QAudit("audit");

    public final EnumPath<com.zoetis.zdms.model.dictionary.DataSet> dataSet = createEnum("dataSet", com.zoetis.zdms.model.dictionary.DataSet.class);

    public final StringPath id = createString("id");

    public final StringPath logBy = createString("logBy");

    public final DateTimePath<java.time.OffsetDateTime> logTime = createDateTime("logTime", java.time.OffsetDateTime.class);

    public final StringPath transactionHeader = createString("transactionHeader");

    public final StringPath transactionMessage = createString("transactionMessage");

    public QAudit(String variable) {
        super(Audit.class, forVariable(variable));
    }

    public QAudit(Path<? extends Audit> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAudit(PathMetadata metadata) {
        super(Audit.class, metadata);
    }

}

