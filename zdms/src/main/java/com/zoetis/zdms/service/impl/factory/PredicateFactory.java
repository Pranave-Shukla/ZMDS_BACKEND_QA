package com.zoetis.zdms.service.impl.factory;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.StringPath;
import com.zoetis.zdms.model.QAudit;
import com.zoetis.zdms.model.dictionary.*;
import com.zoetis.zdms.model.dictionary.pageparameter.search.SearchBy;
import com.zoetis.zdms.model.dictionary.pageparameter.search.SearchByField;
import com.zoetis.zdms.model.view.QCustomerView;
import com.zoetis.zdms.model.view.QProductView;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

@Component
public class PredicateFactory {

    private final static Map<SearchByField.Customer, FieldPredicateExpressionFactory<?>> CUSTOMER_SEARCH_BY_EXPRESSION = new EnumMap<>(SearchByField.Customer.class);
    private final static Map<SearchByField.Product, FieldPredicateExpressionFactory<?>> PRODUCT_SEARCH_BY_EXPRESSION = new EnumMap<>(SearchByField.Product.class);
    private final static Map<SearchByField.Audit, FieldPredicateExpressionFactory<?>> AUDIT_SEARCH_BY_EXPRESSION = new EnumMap<>(SearchByField.Audit.class);

    static {
        PRODUCT_SEARCH_BY_EXPRESSION.put(SearchByField.Product.IS_VISIBLE, FieldPredicateExpressionFactory.enumOf(BooleanValue.class, Expressions.enumPath(BooleanValue.class, QProductView.productView, "isVisible")));
        PRODUCT_SEARCH_BY_EXPRESSION.put(SearchByField.Product.PRODUCT_ID, FieldPredicateExpressionFactory.integerOf(Expressions.numberPath(Integer.class, QProductView.productView, "productId")));
        PRODUCT_SEARCH_BY_EXPRESSION.put(SearchByField.Product.AVAILABILITY, FieldPredicateExpressionFactory.enumOf(Availability.class, Expressions.enumPath(Availability.class, QProductView.productView, "availability")));
        PRODUCT_SEARCH_BY_EXPRESSION.put(SearchByField.Product.DESCRIPTION, FieldPredicateExpressionFactory.stringOf(Expressions.stringPath(QProductView.productView, "description")));
        PRODUCT_SEARCH_BY_EXPRESSION.put(SearchByField.Product.MINIMUM_ORDER_QUANTITY, FieldPredicateExpressionFactory.integerToBooleanOf(Expressions.numberPath(Integer.class, QProductView.productView, "minimumOrderQuantity")));
        PRODUCT_SEARCH_BY_EXPRESSION.put(SearchByField.Product.MAXIMUM_ORDER_QUANTITY, FieldPredicateExpressionFactory.integerToBooleanOf(Expressions.numberPath(Integer.class, QProductView.productView, "maximumOrderQuantity")));
        PRODUCT_SEARCH_BY_EXPRESSION.put(SearchByField.Product.HAS_MEDIA, FieldPredicateExpressionFactory.enumOf(BooleanValue.class, Expressions.enumPath(BooleanValue.class, QProductView.productView, "hasMedia")));
        PRODUCT_SEARCH_BY_EXPRESSION.put(SearchByField.Product.SOURCE, FieldPredicateExpressionFactory.stringListOf(Expressions.stringPath(QProductView.productView, "source")));

        CUSTOMER_SEARCH_BY_EXPRESSION.put(SearchByField.Customer.STATE, FieldPredicateExpressionFactory.enumOf(CustomerState.class, Expressions.enumPath(CustomerState.class, QCustomerView.customerView, "state")));
        CUSTOMER_SEARCH_BY_EXPRESSION.put(SearchByField.Customer.ERP_ID, FieldPredicateExpressionFactory.stringOf(Expressions.stringPath(QCustomerView.customerView, "erpId")));
        CUSTOMER_SEARCH_BY_EXPRESSION.put(SearchByField.Customer.COMPANY_NAME, FieldPredicateExpressionFactory.stringOf(Expressions.stringPath(QCustomerView.customerView, "companyName")));
        CUSTOMER_SEARCH_BY_EXPRESSION.put(SearchByField.Customer.ADDRESS, FieldPredicateExpressionFactory.stringOf(Expressions.stringPath(QCustomerView.customerView, "address")));
        CUSTOMER_SEARCH_BY_EXPRESSION.put(SearchByField.Customer.NATIVE_STATUS, FieldPredicateExpressionFactory.enumOf(CustomerStatus.class, Expressions.enumPath(CustomerStatus.class, QCustomerView.customerView, "localStatus")));
        CUSTOMER_SEARCH_BY_EXPRESSION.put(SearchByField.Customer.NATIVE_CREATED_DATE, FieldPredicateExpressionFactory.offsetDateTimeOf(Expressions.dateTimePath(OffsetDateTime.class, QCustomerView.customerView, "nativeCreatedDate")));
        CUSTOMER_SEARCH_BY_EXPRESSION.put(SearchByField.Customer.TYPE, FieldPredicateExpressionFactory.enumOf(CustomerType.class, Expressions.enumPath(CustomerType.class, QCustomerView.customerView, "type")));
        CUSTOMER_SEARCH_BY_EXPRESSION.put(SearchByField.Customer.SOURCE, FieldPredicateExpressionFactory.stringListOf(Expressions.stringPath(QCustomerView.customerView, "source")));
        CUSTOMER_SEARCH_BY_EXPRESSION.put(SearchByField.Customer.REJECTION_REASON, FieldPredicateExpressionFactory.enumOf(RejectionReason.class, Expressions.enumPath(RejectionReason.class, QCustomerView.customerView.rejectionReason, "rejectionReason")));

        AUDIT_SEARCH_BY_EXPRESSION.put(SearchByField.Audit.DATA_SET, FieldPredicateExpressionFactory.enumOf(DataSet.class, Expressions.enumPath(DataSet.class, QAudit.audit, "dataSet")));
        AUDIT_SEARCH_BY_EXPRESSION.put(SearchByField.Audit.DATE, FieldPredicateExpressionFactory.offsetDateTimeOf(Expressions.dateTimePath(OffsetDateTime.class, QAudit.audit, "logTime")));
        AUDIT_SEARCH_BY_EXPRESSION.put(SearchByField.Audit.HEADER, FieldPredicateExpressionFactory.stringOf(Expressions.stringPath(QAudit.audit, "transactionHeader")));
        AUDIT_SEARCH_BY_EXPRESSION.put(SearchByField.Audit.INITIATOR, FieldPredicateExpressionFactory.stringOf(Expressions.stringPath(QAudit.audit, "logBy")));
        AUDIT_SEARCH_BY_EXPRESSION.put(SearchByField.Audit.MESSAGE, FieldPredicateExpressionFactory.stringOf(Expressions.stringPath(QAudit.audit, "transactionMessage")));
    }


    public Predicate buildCustomerPredicate(Set<SearchBy<SearchByField.Customer>> searchBySet, Language language) {
        StringPath stateNativeLanguagePath = QCustomerView.customerView.stateNativeLanguage;
        StringPath localStatusLanguagePath = QCustomerView.customerView.localStatusLanguage;
        StringPath typeLanguagePath = QCustomerView.customerView.typeLanguage;
        StringPath rejectionReasonLanguagePath = QCustomerView.customerView.rejectionReasonLanguage;

        BooleanBuilder predicateBuilder = new BooleanBuilder()
                .and(stateNativeLanguagePath.isNull().or(stateNativeLanguagePath.equalsIgnoreCase(language.getValue())))
                .and(localStatusLanguagePath.isNull().or(localStatusLanguagePath.equalsIgnoreCase(language.getValue())))
                .and(typeLanguagePath.isNull().or(typeLanguagePath.equalsIgnoreCase(language.getValue())))
                .and(rejectionReasonLanguagePath.isNull().or(rejectionReasonLanguagePath.equalsIgnoreCase(language.getValue())));

        searchBySet
                .forEach(searchBy -> {
                    FieldPredicateExpressionFactory<?> fieldPredicateExpressionFactory = CUSTOMER_SEARCH_BY_EXPRESSION.get(searchBy.getSearchByField());
                    predicateBuilder.and(fieldPredicateExpressionFactory.create(searchBy.getValues()));
                });

        return predicateBuilder;
    }

    public Predicate buildProductPredicate(Set<SearchBy<SearchByField.Product>> searchBySet, Language language) {
        StringPath availabilityLanguagePath = QProductView.productView.availabilityLanguage;
        StringPath isVisibleLanguagePath = QProductView.productView.isVisibleLanguage;
        StringPath hasMediaLanguagePath = QProductView.productView.hasMediaLanguage;

        BooleanBuilder predicateBuilder = new BooleanBuilder()
                .and(availabilityLanguagePath.isNull().or(availabilityLanguagePath.equalsIgnoreCase(language.getValue())))
                .and(isVisibleLanguagePath.isNull().or(isVisibleLanguagePath.equalsIgnoreCase(language.getValue())))
                .and(hasMediaLanguagePath.isNull().or(hasMediaLanguagePath.equalsIgnoreCase(language.getValue())));

        searchBySet
                .forEach(searchBy -> {
                    FieldPredicateExpressionFactory<?> fieldPredicateExpressionFactory = PRODUCT_SEARCH_BY_EXPRESSION.get(searchBy.getSearchByField());
                    predicateBuilder.and(fieldPredicateExpressionFactory.create(searchBy.getValues()));
                });
        return predicateBuilder;
    }

    public Predicate buildAuditPredicate(Set<SearchBy<SearchByField.Audit>> searchBySet) {
        BooleanBuilder predicateBuilder = new BooleanBuilder();

        searchBySet
                .forEach(searchBy -> {
                    FieldPredicateExpressionFactory<?> fieldPredicateExpressionFactory = AUDIT_SEARCH_BY_EXPRESSION.get(searchBy.getSearchByField());
                    predicateBuilder.and(fieldPredicateExpressionFactory.create(searchBy.getValues()));
                });
        return predicateBuilder;
    }
}
