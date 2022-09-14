package com.zoetis.zdms.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCustomer is a Querydsl query type for Customer
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCustomer extends EntityPathBase<Customer> {

    private static final long serialVersionUID = -2083435026L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCustomer customer = new QCustomer("customer");

    public final QAddress address;

    public final StringPath companyName = createString("companyName");

    public final StringPath erpId = createString("erpId");

    public final StringPath firstName = createString("firstName");

    public final StringPath formattedAddress = createString("formattedAddress");

    public final StringPath formattedCompanyName = createString("formattedCompanyName");

    public final StringPath id = createString("id");

    public final StringPath lastName = createString("lastName");

    public final DateTimePath<java.time.OffsetDateTime> nativeCreatedDate = createDateTime("nativeCreatedDate", java.time.OffsetDateTime.class);

    public final StringPath nativeId = createString("nativeId");

    public final StringPath source = createString("source");

    public final EnumPath<com.zoetis.zdms.model.dictionary.CustomerState> state = createEnum("state", com.zoetis.zdms.model.dictionary.CustomerState.class);

    public final QCustomerStatus status;

    public final StringPath title = createString("title");

    public final EnumPath<com.zoetis.zdms.model.dictionary.CustomerType> type = createEnum("type", com.zoetis.zdms.model.dictionary.CustomerType.class);

    public QCustomer(String variable) {
        this(Customer.class, forVariable(variable), INITS);
    }

    public QCustomer(Path<? extends Customer> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCustomer(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCustomer(PathMetadata metadata, PathInits inits) {
        this(Customer.class, metadata, inits);
    }

    public QCustomer(Class<? extends Customer> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.address = inits.isInitialized("address") ? new QAddress(forProperty("address")) : null;
        this.status = inits.isInitialized("status") ? new QCustomerStatus(forProperty("status"), inits.get("status")) : null;
    }

}

