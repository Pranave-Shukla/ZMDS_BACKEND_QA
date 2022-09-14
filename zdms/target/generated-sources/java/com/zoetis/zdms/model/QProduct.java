package com.zoetis.zdms.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProduct is a Querydsl query type for Product
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProduct extends EntityPathBase<Product> {

    private static final long serialVersionUID = -257688353L;

    public static final QProduct product = new QProduct("product");

    public final EnumPath<com.zoetis.zdms.model.dictionary.BooleanValue> etlProcessed = createEnum("etlProcessed", com.zoetis.zdms.model.dictionary.BooleanValue.class);

    public final StringPath globalDescription = createString("globalDescription");

    public final StringPath globalName = createString("globalName");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath localDescription = createString("localDescription");

    public final StringPath localName = createString("localName");

    public final DateTimePath<java.time.OffsetDateTime> localUpdatedDate = createDateTime("localUpdatedDate", java.time.OffsetDateTime.class);

    public final DateTimePath<java.time.OffsetDateTime> nativeUpdatedDate = createDateTime("nativeUpdatedDate", java.time.OffsetDateTime.class);

    public final NumberPath<Double> price = createNumber("price", Double.class);

    public final StringPath priceUnitOfMeasure = createString("priceUnitOfMeasure");

    public final SetPath<ProductStatus, QProductStatus> productStatuses = this.<ProductStatus, QProductStatus>createSet("productStatuses", ProductStatus.class, QProductStatus.class, PathInits.DIRECT2);

    public final NumberPath<Integer> updatedByRunId = createNumber("updatedByRunId", Integer.class);

    public QProduct(String variable) {
        super(Product.class, forVariable(variable));
    }

    public QProduct(Path<? extends Product> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProduct(PathMetadata metadata) {
        super(Product.class, metadata);
    }

}

