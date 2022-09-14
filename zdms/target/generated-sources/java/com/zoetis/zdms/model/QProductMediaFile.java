package com.zoetis.zdms.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProductMediaFile is a Querydsl query type for ProductMediaFile
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProductMediaFile extends EntityPathBase<ProductMediaFile> {

    private static final long serialVersionUID = 621901153L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProductMediaFile productMediaFile = new QProductMediaFile("productMediaFile");

    public final EnumPath<com.zoetis.zdms.model.dictionary.BooleanValue> appProcessed = createEnum("appProcessed", com.zoetis.zdms.model.dictionary.BooleanValue.class);

    public final EnumPath<com.zoetis.zdms.model.dictionary.BooleanValue> etlProcessed = createEnum("etlProcessed", com.zoetis.zdms.model.dictionary.BooleanValue.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public final StringPath path = createString("path");

    public final QProductStatus productStatus;

    public final StringPath updatedBy = createString("updatedBy");

    public final DateTimePath<java.time.OffsetDateTime> updatedDate = createDateTime("updatedDate", java.time.OffsetDateTime.class);

    public QProductMediaFile(String variable) {
        this(ProductMediaFile.class, forVariable(variable), INITS);
    }

    public QProductMediaFile(Path<? extends ProductMediaFile> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProductMediaFile(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProductMediaFile(PathMetadata metadata, PathInits inits) {
        this(ProductMediaFile.class, metadata, inits);
    }

    public QProductMediaFile(Class<? extends ProductMediaFile> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.productStatus = inits.isInitialized("productStatus") ? new QProductStatus(forProperty("productStatus"), inits.get("productStatus")) : null;
    }

}

