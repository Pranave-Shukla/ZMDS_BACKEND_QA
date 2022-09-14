package com.zoetis.zdms.model.dictionary.localized.customerstatus;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QLocalizedCustomerStatusId is a Querydsl query type for LocalizedCustomerStatusId
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QLocalizedCustomerStatusId extends BeanPath<LocalizedCustomerStatusId> {

    private static final long serialVersionUID = 1201823363L;

    public static final QLocalizedCustomerStatusId localizedCustomerStatusId = new QLocalizedCustomerStatusId("localizedCustomerStatusId");

    public final StringPath language = createString("language");

    public final EnumPath<com.zoetis.zdms.model.dictionary.CustomerStatus> status = createEnum("status", com.zoetis.zdms.model.dictionary.CustomerStatus.class);

    public QLocalizedCustomerStatusId(String variable) {
        super(LocalizedCustomerStatusId.class, forVariable(variable));
    }

    public QLocalizedCustomerStatusId(Path<? extends LocalizedCustomerStatusId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLocalizedCustomerStatusId(PathMetadata metadata) {
        super(LocalizedCustomerStatusId.class, metadata);
    }

}

