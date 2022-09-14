package com.zoetis.zdms.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QContactDetails is a Querydsl query type for ContactDetails
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QContactDetails extends BeanPath<ContactDetails> {

    private static final long serialVersionUID = 1953530898L;

    public static final QContactDetails contactDetails = new QContactDetails("contactDetails");

    public final StringPath email = createString("email");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final StringPath searchTerms = createString("searchTerms");

    public QContactDetails(String variable) {
        super(ContactDetails.class, forVariable(variable));
    }

    public QContactDetails(Path<? extends ContactDetails> path) {
        super(path.getType(), path.getMetadata());
    }

    public QContactDetails(PathMetadata metadata) {
        super(ContactDetails.class, metadata);
    }

}

