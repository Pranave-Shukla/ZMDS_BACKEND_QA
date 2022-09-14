package com.zoetis.zdms.mapper;

import com.zoetis.zdms.api.dto.SortAuditsByDto;
import com.zoetis.zdms.api.dto.SortCustomersByDto;
import com.zoetis.zdms.api.dto.SortProductsByDto;
import com.zoetis.zdms.model.dictionary.pageparameter.sort.SortBy.Audit;
import com.zoetis.zdms.model.dictionary.pageparameter.sort.SortBy.Customer;
import com.zoetis.zdms.model.dictionary.pageparameter.sort.SortBy.Product;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-22T09:15:30-0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11 (Oracle Corporation)"
)
@Component
public class SortByMapperImpl implements SortByMapper {

    @Override
    public Customer mapSortCustomersByDto(SortCustomersByDto sortCustomersByDto) {
        if ( sortCustomersByDto == null ) {
            return null;
        }

        Customer customer;

        switch ( sortCustomersByDto ) {
            case NATIVE_STATUS: customer = Customer.NATIVE_STATUS;
            break;
            case ERP_ID: customer = Customer.ERP_ID;
            break;
            case COMPANY_NAME: customer = Customer.COMPANY_NAME;
            break;
            case ADDRESS: customer = Customer.ADDRESS;
            break;
            case STATE: customer = Customer.STATE;
            break;
            case TYPE: customer = Customer.TYPE;
            break;
            case NATIVE_CREATED_DATE: customer = Customer.NATIVE_CREATED_DATE;
            break;
            case SOURCE: customer = Customer.SOURCE;
            break;
            case REJECTION_REASON: customer = Customer.REJECTION_REASON;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + sortCustomersByDto );
        }

        return customer;
    }

    @Override
    public Product mapSortProductsByDto(SortProductsByDto sortProductsByDto) {
        if ( sortProductsByDto == null ) {
            return null;
        }

        Product product;

        switch ( sortProductsByDto ) {
            case IS_VISIBLE: product = Product.IS_VISIBLE;
            break;
            case AVAILABILITY: product = Product.AVAILABILITY;
            break;
            case PRODUCT_ID: product = Product.PRODUCT_ID;
            break;
            case DESCRIPTION: product = Product.DESCRIPTION;
            break;
            case MINIMUM_ORDER_QUANTITY: product = Product.MINIMUM_ORDER_QUANTITY;
            break;
            case MAXIMUM_ORDER_QUANTITY: product = Product.MAXIMUM_ORDER_QUANTITY;
            break;
            case HAS_MEDIA: product = Product.HAS_MEDIA;
            break;
            case SOURCE: product = Product.SOURCE;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + sortProductsByDto );
        }

        return product;
    }

    @Override
    public Audit mapSortAuditsDto(SortAuditsByDto sortAuditsByDto) {
        if ( sortAuditsByDto == null ) {
            return null;
        }

        Audit audit;

        switch ( sortAuditsByDto ) {
            case DATA_SET: audit = Audit.DATA_SET;
            break;
            case HEADER: audit = Audit.HEADER;
            break;
            case MESSAGE: audit = Audit.MESSAGE;
            break;
            case INITIATOR: audit = Audit.INITIATOR;
            break;
            case DATE: audit = Audit.DATE;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + sortAuditsByDto );
        }

        return audit;
    }
}
