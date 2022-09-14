package com.zoetis.zdms.model.dictionary.localized.productavailability;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLocalizedProductAvailability is a Querydsl query type for LocalizedProductAvailability
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLocalizedProductAvailability extends EntityPathBase<LocalizedProductAvailability> {

    private static final long serialVersionUID = -700292434L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLocalizedProductAvailability localizedProductAvailability = new QLocalizedProductAvailability("localizedProductAvailability");

    public final QLocalizedProductAvailabilityId id;

    public final StringPath localizedAvailability = createString("localizedAvailability");

    public QLocalizedProductAvailability(String variable) {
        this(LocalizedProductAvailability.class, forVariable(variable), INITS);
    }

    public QLocalizedProductAvailability(Path<? extends LocalizedProductAvailability> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLocalizedProductAvailability(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLocalizedProductAvailability(PathMetadata metadata, PathInits inits) {
        this(LocalizedProductAvailability.class, metadata, inits);
    }

    public QLocalizedProductAvailability(Class<? extends LocalizedProductAvailability> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.id = inits.isInitialized("id") ? new QLocalizedProductAvailabilityId(forProperty("id")) : null;
    }

}

