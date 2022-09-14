package com.zoetis.zdms.model.dictionary.localized.customerstate;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLocalizedCustomerState is a Querydsl query type for LocalizedCustomerState
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLocalizedCustomerState extends EntityPathBase<LocalizedCustomerState> {

    private static final long serialVersionUID = 100326286L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLocalizedCustomerState localizedCustomerState = new QLocalizedCustomerState("localizedCustomerState");

    public final QLocalizedCustomerStateId id;

    public final StringPath localizedState = createString("localizedState");

    public QLocalizedCustomerState(String variable) {
        this(LocalizedCustomerState.class, forVariable(variable), INITS);
    }

    public QLocalizedCustomerState(Path<? extends LocalizedCustomerState> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLocalizedCustomerState(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLocalizedCustomerState(PathMetadata metadata, PathInits inits) {
        this(LocalizedCustomerState.class, metadata, inits);
    }

    public QLocalizedCustomerState(Class<? extends LocalizedCustomerState> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.id = inits.isInitialized("id") ? new QLocalizedCustomerStateId(forProperty("id")) : null;
    }

}

