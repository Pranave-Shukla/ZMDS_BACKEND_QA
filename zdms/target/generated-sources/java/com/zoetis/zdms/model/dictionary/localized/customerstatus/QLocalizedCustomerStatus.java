package com.zoetis.zdms.model.dictionary.localized.customerstatus;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLocalizedCustomerStatus is a Querydsl query type for LocalizedCustomerStatus
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLocalizedCustomerStatus extends EntityPathBase<LocalizedCustomerStatus> {

    private static final long serialVersionUID = 2101806920L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLocalizedCustomerStatus localizedCustomerStatus = new QLocalizedCustomerStatus("localizedCustomerStatus");

    public final QLocalizedCustomerStatusId id;

    public final StringPath localizedStatus = createString("localizedStatus");

    public QLocalizedCustomerStatus(String variable) {
        this(LocalizedCustomerStatus.class, forVariable(variable), INITS);
    }

    public QLocalizedCustomerStatus(Path<? extends LocalizedCustomerStatus> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLocalizedCustomerStatus(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLocalizedCustomerStatus(PathMetadata metadata, PathInits inits) {
        this(LocalizedCustomerStatus.class, metadata, inits);
    }

    public QLocalizedCustomerStatus(Class<? extends LocalizedCustomerStatus> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.id = inits.isInitialized("id") ? new QLocalizedCustomerStatusId(forProperty("id")) : null;
    }

}

