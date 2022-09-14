package com.zoetis.zdms.mapper;

import com.zoetis.zdms.api.dto.SearchAuditsByDto;
import com.zoetis.zdms.api.dto.SearchAuditsByFieldDto;
import com.zoetis.zdms.api.dto.SearchByOperationDto;
import com.zoetis.zdms.api.dto.SearchCustomersByDto;
import com.zoetis.zdms.api.dto.SearchCustomersByFieldDto;
import com.zoetis.zdms.api.dto.SearchProductsByDto;
import com.zoetis.zdms.api.dto.SearchProductsByFieldDto;
import com.zoetis.zdms.model.dictionary.pageparameter.search.SearchBy;
import com.zoetis.zdms.model.dictionary.pageparameter.search.SearchByField.Audit;
import com.zoetis.zdms.model.dictionary.pageparameter.search.SearchByField.Customer;
import com.zoetis.zdms.model.dictionary.pageparameter.search.SearchByField.Product;
import com.zoetis.zdms.model.dictionary.pageparameter.search.SearchByOperation;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-22T09:15:31-0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11 (Oracle Corporation)"
)
@Component
public class SearchByMapperImpl implements SearchByMapper {

    @Override
    public Customer dtoToSearchByFieldCustomer(SearchCustomersByFieldDto searchCustomersByFieldDto) {
        if ( searchCustomersByFieldDto == null ) {
            return null;
        }

        Customer customer;

        switch ( searchCustomersByFieldDto ) {
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
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + searchCustomersByFieldDto );
        }

        return customer;
    }

    @Override
    public Product dtoToSearchByFieldProduct(SearchProductsByFieldDto searchProductsByFieldDto) {
        if ( searchProductsByFieldDto == null ) {
            return null;
        }

        Product product;

        switch ( searchProductsByFieldDto ) {
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
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + searchProductsByFieldDto );
        }

        return product;
    }

    @Override
    public Audit dtoToSearchByFieldAudit(SearchAuditsByFieldDto searchAuditsByFieldDto) {
        if ( searchAuditsByFieldDto == null ) {
            return null;
        }

        Audit audit;

        switch ( searchAuditsByFieldDto ) {
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
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + searchAuditsByFieldDto );
        }

        return audit;
    }

    @Override
    public SearchByOperation dtoToSearchByOperation(SearchByOperationDto searchByOperationDto) {
        if ( searchByOperationDto == null ) {
            return null;
        }

        SearchByOperation searchByOperation;

        switch ( searchByOperationDto ) {
            case IN: searchByOperation = SearchByOperation.IN;
            break;
            case LIKE: searchByOperation = SearchByOperation.LIKE;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + searchByOperationDto );
        }

        return searchByOperation;
    }

    @Override
    public SearchBy<Customer> mapCustomerSearchByField(SearchCustomersByDto searchCustomersByDto) {
        if ( searchCustomersByDto == null ) {
            return null;
        }

        List<String> values = null;

        List<String> list = searchCustomersByDto.getValues();
        if ( list != null ) {
            values = new ArrayList<String>( list );
        }

        Customer searchByField = dtoToSearchByFieldCustomer(searchCustomersByDto.getField());
        SearchByOperation searchByOperation = dtoToSearchByOperation(searchCustomersByDto.getOperation());

        SearchBy<Customer> searchBy = new SearchBy<Customer>( searchByField, searchByOperation, values );

        return searchBy;
    }

    @Override
    public SearchBy<Product> mapProductSearchByField(SearchProductsByDto searchProductsByDto) {
        if ( searchProductsByDto == null ) {
            return null;
        }

        List<String> values = null;

        List<String> list = searchProductsByDto.getValues();
        if ( list != null ) {
            values = new ArrayList<String>( list );
        }

        Product searchByField = dtoToSearchByFieldProduct(searchProductsByDto.getField());
        SearchByOperation searchByOperation = dtoToSearchByOperation(searchProductsByDto.getOperation());

        SearchBy<Product> searchBy = new SearchBy<Product>( searchByField, searchByOperation, values );

        return searchBy;
    }

    @Override
    public SearchBy<Audit> mapAuditSearchByField(SearchAuditsByDto searchAuditsByDto) {
        if ( searchAuditsByDto == null ) {
            return null;
        }

        List<String> values = null;

        List<String> list = searchAuditsByDto.getValues();
        if ( list != null ) {
            values = new ArrayList<String>( list );
        }

        Audit searchByField = dtoToSearchByFieldAudit(searchAuditsByDto.getField());
        SearchByOperation searchByOperation = dtoToSearchByOperation(searchAuditsByDto.getOperation());

        SearchBy<Audit> searchBy = new SearchBy<Audit>( searchByField, searchByOperation, values );

        return searchBy;
    }
}
