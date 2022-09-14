package com.zoetis.zdms.model.dictionary.localized.customertype;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QLocalizedCustomerTypeId is a Querydsl query type for LocalizedCustomerTypeId
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QLocalizedCustomerTypeId extends BeanPath<LocalizedCustomerTypeId> {

    private static final long serialVersionUID = 1438868179L;

    public static final QLocalizedCustomerTypeId localizedCustomerTypeId = new QLocalizedCustomerTypeId("localizedCustomerTypeId");

    public final StringPath language = createString("language");

    public final EnumPath<com.zoetis.zdms.model.dictionary.CustomerType> type = createEnum("type", com.zoetis.zdms.model.dictionary.CustomerType.class);

    public QLocalizedCustomerTypeId(String variable) {
        super(LocalizedCustomerTypeId.class, forVariable(variable));
    }

    public QLocalizedCustomerTypeId(Path<? extends LocalizedCustomerTypeId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLocalizedCustomerTypeId(PathMetadata metadata) {
        super(LocalizedCustomerTypeId.class, metadata);
    }

}

