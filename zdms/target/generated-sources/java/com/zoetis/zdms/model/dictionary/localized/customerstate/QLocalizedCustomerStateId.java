package com.zoetis.zdms.model.dictionary.localized.customerstate;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QLocalizedCustomerStateId is a Querydsl query type for LocalizedCustomerStateId
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QLocalizedCustomerStateId extends BeanPath<LocalizedCustomerStateId> {

    private static final long serialVersionUID = 1924282697L;

    public static final QLocalizedCustomerStateId localizedCustomerStateId = new QLocalizedCustomerStateId("localizedCustomerStateId");

    public final StringPath language = createString("language");

    public final EnumPath<com.zoetis.zdms.model.dictionary.CustomerState> state = createEnum("state", com.zoetis.zdms.model.dictionary.CustomerState.class);

    public QLocalizedCustomerStateId(String variable) {
        super(LocalizedCustomerStateId.class, forVariable(variable));
    }

    public QLocalizedCustomerStateId(Path<? extends LocalizedCustomerStateId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLocalizedCustomerStateId(PathMetadata metadata) {
        super(LocalizedCustomerStateId.class, metadata);
    }

}

