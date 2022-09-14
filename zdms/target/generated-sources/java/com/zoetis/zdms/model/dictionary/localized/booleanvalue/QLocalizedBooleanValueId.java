package com.zoetis.zdms.model.dictionary.localized.booleanvalue;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QLocalizedBooleanValueId is a Querydsl query type for LocalizedBooleanValueId
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QLocalizedBooleanValueId extends BeanPath<LocalizedBooleanValueId> {

    private static final long serialVersionUID = 1788616629L;

    public static final QLocalizedBooleanValueId localizedBooleanValueId = new QLocalizedBooleanValueId("localizedBooleanValueId");

    public final StringPath language = createString("language");

    public final EnumPath<com.zoetis.zdms.model.dictionary.BooleanValue> value = createEnum("value", com.zoetis.zdms.model.dictionary.BooleanValue.class);

    public QLocalizedBooleanValueId(String variable) {
        super(LocalizedBooleanValueId.class, forVariable(variable));
    }

    public QLocalizedBooleanValueId(Path<? extends LocalizedBooleanValueId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLocalizedBooleanValueId(PathMetadata metadata) {
        super(LocalizedBooleanValueId.class, metadata);
    }

}

