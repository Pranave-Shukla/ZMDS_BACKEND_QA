package com.zoetis.zdms.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCustomerStatus is a Querydsl query type for CustomerStatus
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCustomerStatus extends EntityPathBase<CustomerStatus> {

    private static final long serialVersionUID = -1524539520L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCustomerStatus customerStatus = new QCustomerStatus("customerStatus");

    public final EnumPath<com.zoetis.zdms.model.dictionary.BooleanValue> appProcessed = createEnum("appProcessed", com.zoetis.zdms.model.dictionary.BooleanValue.class);

    public final QCustomer customer;

    public final EnumPath<com.zoetis.zdms.model.dictionary.BooleanValue> etlProcessed = createEnum("etlProcessed", com.zoetis.zdms.model.dictionary.BooleanValue.class);

    public final StringPath freeText = createString("freeText");

    public final StringPath id = createString("id");

    public final EnumPath<com.zoetis.zdms.model.dictionary.CustomerStatus> localStatus = createEnum("localStatus", com.zoetis.zdms.model.dictionary.CustomerStatus.class);

    public final EnumPath<com.zoetis.zdms.model.dictionary.RejectionReason> rejectionReason = createEnum("rejectionReason", com.zoetis.zdms.model.dictionary.RejectionReason.class);

    public final StringPath updatedBy = createString("updatedBy");

    public final DateTimePath<java.time.OffsetDateTime> updatedDate = createDateTime("updatedDate", java.time.OffsetDateTime.class);

    public QCustomerStatus(String variable) {
        this(CustomerStatus.class, forVariable(variable), INITS);
    }

    public QCustomerStatus(Path<? extends CustomerStatus> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCustomerStatus(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCustomerStatus(PathMetadata metadata, PathInits inits) {
        this(CustomerStatus.class, metadata, inits);
    }

    public QCustomerStatus(Class<? extends CustomerStatus> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.customer = inits.isInitialized("customer") ? new QCustomer(forProperty("customer"), inits.get("customer")) : null;
    }

}

