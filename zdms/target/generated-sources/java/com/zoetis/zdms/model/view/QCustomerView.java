package com.zoetis.zdms.model.view;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCustomerView is a Querydsl query type for CustomerView
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCustomerView extends EntityPathBase<CustomerView> {

    private static final long serialVersionUID = -2015998852L;

    public static final QCustomerView customerView = new QCustomerView("customerView");

    public final StringPath address = createString("address");

    public final StringPath companyName = createString("companyName");

    public final StringPath erpId = createString("erpId");

    public final StringPath id = createString("id");

    public final EnumPath<com.zoetis.zdms.model.dictionary.CustomerStatus> localStatus = createEnum("localStatus", com.zoetis.zdms.model.dictionary.CustomerStatus.class);

    public final StringPath localStatusLanguage = createString("localStatusLanguage");

    public final StringPath localStatusLocalized = createString("localStatusLocalized");

    public final DateTimePath<java.time.OffsetDateTime> nativeCreatedDate = createDateTime("nativeCreatedDate", java.time.OffsetDateTime.class);

    public final EnumPath<com.zoetis.zdms.model.dictionary.RejectionReason> rejectionReason = createEnum("rejectionReason", com.zoetis.zdms.model.dictionary.RejectionReason.class);

    public final StringPath rejectionReasonLanguage = createString("rejectionReasonLanguage");

    public final StringPath rejectionReasonLocalized = createString("rejectionReasonLocalized");

    public final StringPath source = createString("source");

    public final EnumPath<com.zoetis.zdms.model.dictionary.CustomerState> state = createEnum("state", com.zoetis.zdms.model.dictionary.CustomerState.class);

    public final StringPath stateNativeLanguage = createString("stateNativeLanguage");

    public final StringPath stateNativeLocalized = createString("stateNativeLocalized");

    public final EnumPath<com.zoetis.zdms.model.dictionary.CustomerType> type = createEnum("type", com.zoetis.zdms.model.dictionary.CustomerType.class);

    public final StringPath typeLanguage = createString("typeLanguage");

    public final StringPath typeLocalized = createString("typeLocalized");

    public QCustomerView(String variable) {
        super(CustomerView.class, forVariable(variable));
    }

    public QCustomerView(Path<? extends CustomerView> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCustomerView(PathMetadata metadata) {
        super(CustomerView.class, metadata);
    }

}

