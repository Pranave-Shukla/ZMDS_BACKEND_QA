package com.zoetis.zdms.model.dictionary.localized.errorcode;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLocalizedErrorCode is a Querydsl query type for LocalizedErrorCode
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLocalizedErrorCode extends EntityPathBase<LocalizedErrorCode> {

    private static final long serialVersionUID = -657234034L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLocalizedErrorCode localizedErrorCode1 = new QLocalizedErrorCode("localizedErrorCode1");

    public final QLocalizedErrorCodeId id;

    public final StringPath localizedErrorCode = createString("localizedErrorCode");

    public QLocalizedErrorCode(String variable) {
        this(LocalizedErrorCode.class, forVariable(variable), INITS);
    }

    public QLocalizedErrorCode(Path<? extends LocalizedErrorCode> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLocalizedErrorCode(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLocalizedErrorCode(PathMetadata metadata, PathInits inits) {
        this(LocalizedErrorCode.class, metadata, inits);
    }

    public QLocalizedErrorCode(Class<? extends LocalizedErrorCode> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.id = inits.isInitialized("id") ? new QLocalizedErrorCodeId(forProperty("id")) : null;
    }

}

