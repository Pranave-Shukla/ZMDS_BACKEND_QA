package com.zoetis.zdms.service.impl.factory;

import com.querydsl.core.types.Path;
import com.zoetis.zdms.model.QAudit;
import com.zoetis.zdms.model.dictionary.pageparameter.sort.SortBy;
import com.zoetis.zdms.model.dictionary.pageparameter.sort.SortDirection;
import com.zoetis.zdms.model.view.QCustomerView;
import com.zoetis.zdms.model.view.QProductView;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PageFactory {

    public static final Map<SortBy.Customer, List<String>> CUSTOMER_SORT_KEYS = new EnumMap<>(SortBy.Customer.class);
    private static final Map<SortBy.Product, List<String>> PRODUCT_SORT_KEYS = new EnumMap<>(SortBy.Product.class);
    private static final Map<SortBy.Audit, List<String>> AUDITS_SORT_KEYS = new EnumMap<>(SortBy.Audit.class);

    static {
        /*
            erpId has been added to keep the order of retrieved data consistent when paged
         */
        CUSTOMER_SORT_KEYS.put(SortBy.Customer.STATE, Arrays.asList(getFieldNameFor(QCustomerView.customerView.stateNativeLocalized), getFieldNameFor(QCustomerView.customerView.erpId)));
        CUSTOMER_SORT_KEYS.put(SortBy.Customer.ERP_ID, Collections.singletonList(getFieldNameFor(QCustomerView.customerView.erpId)));
        CUSTOMER_SORT_KEYS.put(SortBy.Customer.COMPANY_NAME, Arrays.asList(getFieldNameFor(QCustomerView.customerView.companyName), getFieldNameFor(QCustomerView.customerView.erpId)));
        CUSTOMER_SORT_KEYS.put(SortBy.Customer.ADDRESS, Arrays.asList(getFieldNameFor(QCustomerView.customerView.address), getFieldNameFor(QCustomerView.customerView.erpId)));
        CUSTOMER_SORT_KEYS.put(SortBy.Customer.NATIVE_STATUS, Arrays.asList(getFieldNameFor(QCustomerView.customerView.localStatusLocalized), getFieldNameFor(QCustomerView.customerView.erpId)));
        CUSTOMER_SORT_KEYS.put(SortBy.Customer.TYPE, Arrays.asList(getFieldNameFor(QCustomerView.customerView.typeLocalized), getFieldNameFor(QCustomerView.customerView.erpId)));
        CUSTOMER_SORT_KEYS.put(SortBy.Customer.NATIVE_CREATED_DATE, Arrays.asList(getFieldNameFor(QCustomerView.customerView.nativeCreatedDate), getFieldNameFor(QCustomerView.customerView.erpId)));
        CUSTOMER_SORT_KEYS.put(SortBy.Customer.SOURCE, Arrays.asList(getFieldNameFor(QCustomerView.customerView.source), getFieldNameFor(QCustomerView.customerView.erpId)));
        CUSTOMER_SORT_KEYS.put(SortBy.Customer.REJECTION_REASON, Arrays.asList(getFieldNameFor(QCustomerView.customerView.rejectionReason), getFieldNameFor(QCustomerView.customerView.erpId)));

        /*
            productId has been added to keep the order of retrieved data consistent when paged
         */
        PRODUCT_SORT_KEYS.put(SortBy.Product.IS_VISIBLE, Arrays.asList(getFieldNameFor(QProductView.productView.isVisibleLocalized), getFieldNameFor(QProductView.productView.productId)));
        PRODUCT_SORT_KEYS.put(SortBy.Product.AVAILABILITY, Arrays.asList(getFieldNameFor(QProductView.productView.availability), getFieldNameFor(QProductView.productView.productId)));
        PRODUCT_SORT_KEYS.put(SortBy.Product.PRODUCT_ID, Collections.singletonList(getFieldNameFor(QProductView.productView.productId)));
        PRODUCT_SORT_KEYS.put(SortBy.Product.DESCRIPTION, Arrays.asList(getFieldNameFor(QProductView.productView.description), getFieldNameFor(QProductView.productView.productId)));
        PRODUCT_SORT_KEYS.put(SortBy.Product.MINIMUM_ORDER_QUANTITY, Arrays.asList(getFieldNameFor(QProductView.productView.minimumOrderQuantity), getFieldNameFor(QProductView.productView.productId)));
        PRODUCT_SORT_KEYS.put(SortBy.Product.MAXIMUM_ORDER_QUANTITY, Arrays.asList(getFieldNameFor(QProductView.productView.maximumOrderQuantity), getFieldNameFor(QProductView.productView.productId)));
        PRODUCT_SORT_KEYS.put(SortBy.Product.HAS_MEDIA, Arrays.asList(getFieldNameFor(QProductView.productView.hasMediaLocalized), getFieldNameFor(QProductView.productView.productId)));
        PRODUCT_SORT_KEYS.put(SortBy.Product.SOURCE, Arrays.asList(getFieldNameFor(QProductView.productView.source), getFieldNameFor(QProductView.productView.productId)));

        /*
            id has been added to keep the order of retrieved data consistent when paged
         */
        AUDITS_SORT_KEYS.put(SortBy.Audit.DATA_SET, Arrays.asList(getFieldNameFor(QAudit.audit.dataSet), getFieldNameFor(QAudit.audit.id)));
        AUDITS_SORT_KEYS.put(SortBy.Audit.HEADER, Arrays.asList(getFieldNameFor(QAudit.audit.transactionHeader), getFieldNameFor(QAudit.audit.id)));
        AUDITS_SORT_KEYS.put(SortBy.Audit.MESSAGE, Arrays.asList(getFieldNameFor(QAudit.audit.transactionMessage), getFieldNameFor(QAudit.audit.id)));
        AUDITS_SORT_KEYS.put(SortBy.Audit.DATE, Arrays.asList(getFieldNameFor(QAudit.audit.logTime), getFieldNameFor(QAudit.audit.id)));
        AUDITS_SORT_KEYS.put(SortBy.Audit.INITIATOR, Arrays.asList(getFieldNameFor(QAudit.audit.logBy), getFieldNameFor(QAudit.audit.id)));
    }

    private static String getFieldNameFor(Path<?> path) {
        return path.toString().replaceFirst(path.getRoot() + ".", StringUtils.EMPTY);
    }

    public Pageable buildCustomerPageRequest(Long elementsCounts, Integer pageNumber, Integer pageSize, SortDirection sortDirection, SortBy.Customer sortBy) {
        int maximumPageNumber = getMaximumPageNumber(elementsCounts, pageSize);
        int limitedPageNumber = pageNumber > maximumPageNumber ? maximumPageNumber : pageNumber;

        return PageRequest.of(limitedPageNumber, pageSize, Sort.by(Sort.Direction.fromString(sortDirection.getValue()), CUSTOMER_SORT_KEYS.get(sortBy).toArray(new String[0])));
    }

    public Pageable buildProductPageRequest(Long elementsCounts, Integer pageNumber, Integer pageSize, SortDirection sortDirection, SortBy.Product sortBy) {
        int maximumPageNumber = getMaximumPageNumber(elementsCounts, pageSize);
        int limitedPageNumber = pageNumber > maximumPageNumber ? maximumPageNumber : pageNumber;

        return PageRequest.of(limitedPageNumber, pageSize, Sort.by(Sort.Direction.fromString(sortDirection.getValue()), PRODUCT_SORT_KEYS.get(sortBy).toArray(new String[0])));
    }

    public Pageable buildAuditPageRequest(Long elementsCounts, Integer pageNumber, Integer pageSize, SortDirection sortDirection, SortBy.Audit sortBy) {
        int maximumPageNumber = getMaximumPageNumber(elementsCounts, pageSize);
        int limitedPageNumber = pageNumber > maximumPageNumber ? maximumPageNumber : pageNumber;

        return PageRequest.of(limitedPageNumber, pageSize, Sort.by(Sort.Direction.fromString(sortDirection.getValue()), AUDITS_SORT_KEYS.get(sortBy).toArray(new String[0])));
    }

    /* 1 has to be subtracted due to paging */
    private int getMaximumPageNumber(long elementsCount, int pageSize) {
        int maximumPageNumber =  (int)Math.ceil((double)elementsCount / (double)pageSize) - 1;

        /* if maximumPageNumber is negative set default 0 page */
        return Math.max(maximumPageNumber, 0);
    }

}
