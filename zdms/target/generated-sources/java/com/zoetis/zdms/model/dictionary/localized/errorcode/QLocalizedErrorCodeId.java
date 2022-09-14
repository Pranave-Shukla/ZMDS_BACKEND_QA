package com.zoetis.zdms.model.dictionary.localized.errorcode;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QLocalizedErrorCodeId is a Querydsl query type for LocalizedErrorCodeId
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QLocalizedErrorCodeId extends BeanPath<LocalizedErrorCodeId> {

    private static final long serialVersionUID = -241711799L;

    public static final QLocalizedErrorCodeId localizedErrorCodeId = new QLocalizedErrorCodeId("localizedErrorCodeId");

    public final EnumPath<com.zoetis.zdms.model.dictionary.ErrorCode> errorCode = createEnum("errorCode", com.zoetis.zdms.model.dictionary.ErrorCode.class);

    public final StringPath language = createString("language");

    public QLocalizedErrorCodeId(String variable) {
        super(LocalizedErrorCodeId.class, forVariable(variable));
    }

    public QLocalizedErrorCodeId(Path<? extends LocalizedErrorCodeId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLocalizedErrorCodeId(PathMetadata metadata) {
        super(LocalizedErrorCodeId.class, metadata);
    }

}

