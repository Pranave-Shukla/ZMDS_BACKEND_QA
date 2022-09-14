package com.zoetis.zdms.model.view;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QProductView is a Querydsl query type for ProductView
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProductView extends EntityPathBase<ProductView> {

    private static final long serialVersionUID = 76918843L;

    public static final QProductView productView = new QProductView("productView");

    public final EnumPath<com.zoetis.zdms.model.dictionary.Availability> availability = createEnum("availability", com.zoetis.zdms.model.dictionary.Availability.class);

    public final StringPath availabilityLanguage = createString("availabilityLanguage");

    public final StringPath availabilityLocalized = createString("availabilityLocalized");

    public final StringPath description = createString("description");

    public final EnumPath<com.zoetis.zdms.model.dictionary.BooleanValue> hasMedia = createEnum("hasMedia", com.zoetis.zdms.model.dictionary.BooleanValue.class);

    public final StringPath hasMediaLanguage = createString("hasMediaLanguage");

    public final StringPath hasMediaLocalized = createString("hasMediaLocalized");

    public final EnumPath<com.zoetis.zdms.model.dictionary.BooleanValue> isVisible = createEnum("isVisible", com.zoetis.zdms.model.dictionary.BooleanValue.class);

    public final StringPath isVisibleLanguage = createString("isVisibleLanguage");

    public final StringPath isVisibleLocalized = createString("isVisibleLocalized");

    public final NumberPath<Integer> maximumOrderQuantity = createNumber("maximumOrderQuantity", Integer.class);

    public final NumberPath<Integer> minimumOrderQuantity = createNumber("minimumOrderQuantity", Integer.class);

    public final NumberPath<Integer> productId = createNumber("productId", Integer.class);

    public final StringPath source = createString("source");

    public final NumberPath<Integer> statusId = createNumber("statusId", Integer.class);

    public final StringPath uuid = createString("uuid");

    public QProductView(String variable) {
        super(ProductView.class, forVariable(variable));
    }

    public QProductView(Path<? extends ProductView> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProductView(PathMetadata metadata) {
        super(ProductView.class, metadata);
    }

}

