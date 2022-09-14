package com.zoetis.zdms.model.dictionary.localized.customertype;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLocalizedCustomerType is a Querydsl query type for LocalizedCustomerType
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLocalizedCustomerType extends EntityPathBase<LocalizedCustomerType> {

    private static final long serialVersionUID = -1048780904L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLocalizedCustomerType localizedCustomerType = new QLocalizedCustomerType("localizedCustomerType");

    public final QLocalizedCustomerTypeId id;

    public final StringPath localizedType = createString("localizedType");

    public QLocalizedCustomerType(String variable) {
        this(LocalizedCustomerType.class, forVariable(variable), INITS);
    }

    public QLocalizedCustomerType(Path<? extends LocalizedCustomerType> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLocalizedCustomerType(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLocalizedCustomerType(PathMetadata metadata, PathInits inits) {
        this(LocalizedCustomerType.class, metadata, inits);
    }

    public QLocalizedCustomerType(Class<? extends LocalizedCustomerType> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.id = inits.isInitialized("id") ? new QLocalizedCustomerTypeId(forProperty("id")) : null;
    }

}

