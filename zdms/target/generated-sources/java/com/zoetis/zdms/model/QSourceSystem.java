package com.zoetis.zdms.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSourceSystem is a Querydsl query type for SourceSystem
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSourceSystem extends EntityPathBase<SourceSystem> {

    private static final long serialVersionUID = -1754903494L;

    public static final QSourceSystem sourceSystem = new QSourceSystem("sourceSystem");

    public final StringPath defaultLanguage = createString("defaultLanguage");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public final SetPath<ProductStatus, QProductStatus> productStatuses = this.<ProductStatus, QProductStatus>createSet("productStatuses", ProductStatus.class, QProductStatus.class, PathInits.DIRECT2);

    public QSourceSystem(String variable) {
        super(SourceSystem.class, forVariable(variable));
    }

    public QSourceSystem(Path<? extends SourceSystem> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSourceSystem(PathMetadata metadata) {
        super(SourceSystem.class, metadata);
    }

}

