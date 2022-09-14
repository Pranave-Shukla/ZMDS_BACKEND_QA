package com.zoetis.zdms.model.dictionary.localized.productavailability;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QLocalizedProductAvailabilityId is a Querydsl query type for LocalizedProductAvailabilityId
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QLocalizedProductAvailabilityId extends BeanPath<LocalizedProductAvailabilityId> {

    private static final long serialVersionUID = 1328838761L;

    public static final QLocalizedProductAvailabilityId localizedProductAvailabilityId = new QLocalizedProductAvailabilityId("localizedProductAvailabilityId");

    public final EnumPath<com.zoetis.zdms.model.dictionary.Availability> availability = createEnum("availability", com.zoetis.zdms.model.dictionary.Availability.class);

    public final StringPath language = createString("language");

    public QLocalizedProductAvailabilityId(String variable) {
        super(LocalizedProductAvailabilityId.class, forVariable(variable));
    }

    public QLocalizedProductAvailabilityId(Path<? extends LocalizedProductAvailabilityId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLocalizedProductAvailabilityId(PathMetadata metadata) {
        super(LocalizedProductAvailabilityId.class, metadata);
    }

}

