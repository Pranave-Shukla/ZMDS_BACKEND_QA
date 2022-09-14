package com.zoetis.zdms.model.dictionary.localized.rejectionreason;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLocalizedRejectionReason is a Querydsl query type for LocalizedRejectionReason
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLocalizedRejectionReason extends EntityPathBase<LocalizedRejectionReason> {

    private static final long serialVersionUID = -1871420530L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLocalizedRejectionReason localizedRejectionReason1 = new QLocalizedRejectionReason("localizedRejectionReason1");

    public final QLocalizedRejectionReasonId id;

    public final StringPath localizedRejectionReason = createString("localizedRejectionReason");

    public QLocalizedRejectionReason(String variable) {
        this(LocalizedRejectionReason.class, forVariable(variable), INITS);
    }

    public QLocalizedRejectionReason(Path<? extends LocalizedRejectionReason> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLocalizedRejectionReason(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLocalizedRejectionReason(PathMetadata metadata, PathInits inits) {
        this(LocalizedRejectionReason.class, metadata, inits);
    }

    public QLocalizedRejectionReason(Class<? extends LocalizedRejectionReason> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.id = inits.isInitialized("id") ? new QLocalizedRejectionReasonId(forProperty("id")) : null;
    }

}

