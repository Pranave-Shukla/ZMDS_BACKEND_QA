package com.zoetis.zdms.model.dictionary.localized.booleanvalue;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLocalizedBooleanValue is a Querydsl query type for LocalizedBooleanValue
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLocalizedBooleanValue extends EntityPathBase<LocalizedBooleanValue> {

    private static final long serialVersionUID = -842830598L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLocalizedBooleanValue localizedBooleanValue = new QLocalizedBooleanValue("localizedBooleanValue");

    public final QLocalizedBooleanValueId id;

    public final StringPath localizedValue = createString("localizedValue");

    public QLocalizedBooleanValue(String variable) {
        this(LocalizedBooleanValue.class, forVariable(variable), INITS);
    }

    public QLocalizedBooleanValue(Path<? extends LocalizedBooleanValue> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLocalizedBooleanValue(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLocalizedBooleanValue(PathMetadata metadata, PathInits inits) {
        this(LocalizedBooleanValue.class, metadata, inits);
    }

    public QLocalizedBooleanValue(Class<? extends LocalizedBooleanValue> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.id = inits.isInitialized("id") ? new QLocalizedBooleanValueId(forProperty("id")) : null;
    }

}

