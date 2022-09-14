package com.zoetis.zdms.model.view;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCustomerLookupView is a Querydsl query type for CustomerLookupView
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCustomerLookupView extends EntityPathBase<CustomerLookupView> {

    private static final long serialVersionUID = 422125526L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCustomerLookupView customerLookupView = new QCustomerLookupView("customerLookupView");

    public final EnumPath<com.zoetis.zdms.model.dictionary.AccountType> accountType = createEnum("accountType", com.zoetis.zdms.model.dictionary.AccountType.class);

    public final StringPath city = createString("city");

    public final com.zoetis.zdms.model.QContactDetails contactDetails;

    public final StringPath countryCode = createString("countryCode");

    public final StringPath id = createString("id");

    public final EnumPath<com.zoetis.zdms.model.dictionary.BooleanValue> isdDeleted = createEnum("isdDeleted", com.zoetis.zdms.model.dictionary.BooleanValue.class);

    public final StringPath name1 = createString("name1");

    public final StringPath name2 = createString("name2");

    public final StringPath name3 = createString("name3");

    public final StringPath name4 = createString("name4");

    public final StringPath postalCode = createString("postalCode");

    public final StringPath streetAddress = createString("streetAddress");

    public final StringPath title = createString("title");

    public QCustomerLookupView(String variable) {
        this(CustomerLookupView.class, forVariable(variable), INITS);
    }

    public QCustomerLookupView(Path<? extends CustomerLookupView> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCustomerLookupView(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCustomerLookupView(PathMetadata metadata, PathInits inits) {
        this(CustomerLookupView.class, metadata, inits);
    }

    public QCustomerLookupView(Class<? extends CustomerLookupView> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.contactDetails = inits.isInitialized("contactDetails") ? new com.zoetis.zdms.model.QContactDetails(forProperty("contactDetails")) : null;
    }

}

