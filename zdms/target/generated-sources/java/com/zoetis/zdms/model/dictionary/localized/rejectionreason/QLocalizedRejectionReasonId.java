package com.zoetis.zdms.model.dictionary.localized.rejectionreason;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QLocalizedRejectionReasonId is a Querydsl query type for LocalizedRejectionReasonId
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QLocalizedRejectionReasonId extends BeanPath<LocalizedRejectionReasonId> {

    private static final long serialVersionUID = 1156170057L;

    public static final QLocalizedRejectionReasonId localizedRejectionReasonId = new QLocalizedRejectionReasonId("localizedRejectionReasonId");

    public final StringPath language = createString("language");

    public final EnumPath<com.zoetis.zdms.model.dictionary.RejectionReason> rejectionReason = createEnum("rejectionReason", com.zoetis.zdms.model.dictionary.RejectionReason.class);

    public QLocalizedRejectionReasonId(String variable) {
        super(LocalizedRejectionReasonId.class, forVariable(variable));
    }

    public QLocalizedRejectionReasonId(Path<? extends LocalizedRejectionReasonId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLocalizedRejectionReasonId(PathMetadata metadata) {
        super(LocalizedRejectionReasonId.class, metadata);
    }

}

