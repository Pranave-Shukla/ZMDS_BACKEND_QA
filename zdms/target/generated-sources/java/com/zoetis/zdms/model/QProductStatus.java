package com.zoetis.zdms.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProductStatus is a Querydsl query type for ProductStatus
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProductStatus extends EntityPathBase<ProductStatus> {

    private static final long serialVersionUID = -176728655L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProductStatus productStatus = new QProductStatus("productStatus");

    public final EnumPath<com.zoetis.zdms.model.dictionary.BooleanValue> appProcessed = createEnum("appProcessed", com.zoetis.zdms.model.dictionary.BooleanValue.class);

    public final StringPath associatedProducts = createString("associatedProducts");

    public final EnumPath<com.zoetis.zdms.model.dictionary.Availability> availability = createEnum("availability", com.zoetis.zdms.model.dictionary.Availability.class);

    public final EnumPath<com.zoetis.zdms.model.dictionary.BooleanValue> etlProcessed = createEnum("etlProcessed", com.zoetis.zdms.model.dictionary.BooleanValue.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final EnumPath<com.zoetis.zdms.model.dictionary.BooleanValue> isVisible = createEnum("isVisible", com.zoetis.zdms.model.dictionary.BooleanValue.class);

    public final NumberPath<Integer> maximumOrderQuantity = createNumber("maximumOrderQuantity", Integer.class);

    public final NumberPath<Integer> minimumOrderQuantity = createNumber("minimumOrderQuantity", Integer.class);

    public final QProduct product;

    public final NumberPath<Integer> productId = createNumber("productId", Integer.class);

    public final SetPath<ProductMediaFile, QProductMediaFile> productMediaFiles = this.<ProductMediaFile, QProductMediaFile>createSet("productMediaFiles", ProductMediaFile.class, QProductMediaFile.class, PathInits.DIRECT2);

    public final QSourceSystem sourceSystem;

    public final StringPath updatedBy = createString("updatedBy");

    public final DateTimePath<java.time.OffsetDateTime> updatedDate = createDateTime("updatedDate", java.time.OffsetDateTime.class);

    public QProductStatus(String variable) {
        this(ProductStatus.class, forVariable(variable), INITS);
    }

    public QProductStatus(Path<? extends ProductStatus> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProductStatus(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProductStatus(PathMetadata metadata, PathInits inits) {
        this(ProductStatus.class, metadata, inits);
    }

    public QProductStatus(Class<? extends ProductStatus> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.product = inits.isInitialized("product") ? new QProduct(forProperty("product")) : null;
        this.sourceSystem = inits.isInitialized("sourceSystem") ? new QSourceSystem(forProperty("sourceSystem")) : null;
    }

}

