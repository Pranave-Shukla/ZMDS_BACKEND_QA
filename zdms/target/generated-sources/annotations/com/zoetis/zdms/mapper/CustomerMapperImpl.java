package com.zoetis.zdms.mapper;

import com.zoetis.zdms.api.dto.CustomerContactDetailsDto;
import com.zoetis.zdms.api.dto.CustomerDto;
import com.zoetis.zdms.api.dto.CustomerLookupDto;
import com.zoetis.zdms.api.dto.CustomerLookupResponseDto;
import com.zoetis.zdms.api.dto.CustomerNativeStatusDto;
import com.zoetis.zdms.api.dto.CustomerStateDto;
import com.zoetis.zdms.api.dto.CustomerTypeDto;
import com.zoetis.zdms.api.dto.CustomersResponseDto;
import com.zoetis.zdms.api.dto.PageInfoDto;
import com.zoetis.zdms.api.dto.RejectionReasonDto;
import com.zoetis.zdms.model.ContactDetails;
import com.zoetis.zdms.model.Customer;
import com.zoetis.zdms.model.dictionary.CustomerState;
import com.zoetis.zdms.model.dictionary.CustomerStatus;
import com.zoetis.zdms.model.dictionary.CustomerType;
import com.zoetis.zdms.model.dictionary.RejectionReason;
import com.zoetis.zdms.model.view.CustomerLookupView;
import com.zoetis.zdms.model.view.CustomerView;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-22T09:15:31-0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Autowired
    private DictionariesMapper dictionariesMapper;
    @Autowired
    private SourceSystemMapper sourceSystemMapper;

    @Override
    public CustomerDto customerViewToCustomerDto(CustomerView customerView) {
        if ( customerView == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setNativeStatus( customerStatusToCustomerNativeStatusDto( customerView.getLocalStatus() ) );
        customerDto.setSourceSystem( sourceSystemMapper.mapSourceSystemNameToDto( customerView.getSource() ) );
        customerDto.setId( customerView.getId() );
        customerDto.setErpId( customerView.getErpId() );
        customerDto.setType( customerTypeToCustomerTypeDto( customerView.getType() ) );
        customerDto.setCompanyName( customerView.getCompanyName() );
        customerDto.setAddress( customerView.getAddress() );
        customerDto.setState( customerStateToCustomerStateDto( customerView.getState() ) );
        customerDto.setNativeCreatedDate( customerView.getNativeCreatedDate() );
        customerDto.setRejectionReason( rejectionReasonToRejectionReasonDto( customerView.getRejectionReason() ) );

        return customerDto;
    }

    @Override
    public CustomersResponseDto pagedCustomersToGetCustomersResponseDto(Integer pageNumber, List<CustomerView> elements, Integer totalPages, Long totalElements) {
        if ( pageNumber == null && elements == null && totalPages == null && totalElements == null ) {
            return null;
        }

        CustomersResponseDto customersResponseDto = new CustomersResponseDto();

        if ( pageNumber != null ) {
            if ( customersResponseDto.getPageInfo() == null ) {
                customersResponseDto.setPageInfo( new PageInfoDto() );
            }
            integerToPageInfoDto( pageNumber, customersResponseDto.getPageInfo() );
        }
        if ( elements != null ) {
            customersResponseDto.setCustomers( customerViewListToCustomerDtoList( elements ) );
        }
        if ( totalPages != null ) {
            if ( customersResponseDto.getPageInfo() == null ) {
                customersResponseDto.setPageInfo( new PageInfoDto() );
            }
            integerToPageInfoDto1( totalPages, customersResponseDto.getPageInfo() );
        }
        if ( totalElements != null ) {
            if ( customersResponseDto.getPageInfo() == null ) {
                customersResponseDto.setPageInfo( new PageInfoDto() );
            }
            longToPageInfoDto( totalElements, customersResponseDto.getPageInfo() );
        }

        return customersResponseDto;
    }

    @Override
    public CustomerDto customerToCustomerDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setNativeStatus( customerStatusToCustomerNativeStatusDto( customerStatusLocalStatus( customer ) ) );
        customerDto.setState( customerStateToCustomerStateDto( customer.getState() ) );
        customerDto.setAddress( customer.getFormattedAddress() );
        customerDto.setCompanyName( customer.getFormattedCompanyName() );
        customerDto.setRejectionReason( rejectionReasonToRejectionReasonDto( customerStatusRejectionReason( customer ) ) );
        customerDto.setSourceSystem( sourceSystemMapper.mapSourceSystemNameToDto( customer.getSource() ) );
        customerDto.setId( customer.getId() );
        customerDto.setErpId( customer.getErpId() );
        customerDto.setType( customerTypeToCustomerTypeDto( customer.getType() ) );
        customerDto.setNativeCreatedDate( customer.getNativeCreatedDate() );

        return customerDto;
    }

    @Override
    public CustomerLookupDto customerLookupViewToDto(CustomerLookupView customerLookupView) {
        if ( customerLookupView == null ) {
            return null;
        }

        CustomerLookupDto customerLookupDto = new CustomerLookupDto();

        customerLookupDto.setErpId( customerLookupView.getId() );
        customerLookupDto.setType( dictionariesMapper.accountTypeToCustomerTypeDto( customerLookupView.getAccountType() ) );
        customerLookupDto.setName1( customerLookupView.getName1() );
        customerLookupDto.setName2( customerLookupView.getName2() );
        customerLookupDto.setName3( customerLookupView.getName3() );
        customerLookupDto.setName4( customerLookupView.getName4() );
        customerLookupDto.setTitle( customerLookupView.getTitle() );
        customerLookupDto.setStreetAddress( customerLookupView.getStreetAddress() );
        customerLookupDto.setPostalCode( customerLookupView.getPostalCode() );
        customerLookupDto.setCountryCode( customerLookupView.getCountryCode() );
        customerLookupDto.setCity( customerLookupView.getCity() );
        customerLookupDto.setContactDetails( contactDetailsToCustomerContactDetailsDto( customerLookupView.getContactDetails() ) );

        return customerLookupDto;
    }

    @Override
    public CustomerLookupResponseDto customerLookupViewToResponseDto(CustomerLookupView customerLookupView) {
        if ( customerLookupView == null ) {
            return null;
        }

        CustomerLookupResponseDto customerLookupResponseDto = new CustomerLookupResponseDto();

        customerLookupResponseDto.setCustomerLookup( customerLookupViewToDto( customerLookupView ) );

        return customerLookupResponseDto;
    }

    protected CustomerNativeStatusDto customerStatusToCustomerNativeStatusDto(CustomerStatus customerStatus) {
        if ( customerStatus == null ) {
            return null;
        }

        CustomerNativeStatusDto customerNativeStatusDto;

        switch ( customerStatus ) {
            case IN_REVIEW: customerNativeStatusDto = CustomerNativeStatusDto.IN_REVIEW;
            break;
            case VALIDATED: customerNativeStatusDto = CustomerNativeStatusDto.VALIDATED;
            break;
            case BLOCKED: customerNativeStatusDto = CustomerNativeStatusDto.BLOCKED;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + customerStatus );
        }

        return customerNativeStatusDto;
    }

    protected CustomerTypeDto customerTypeToCustomerTypeDto(CustomerType customerType) {
        if ( customerType == null ) {
            return null;
        }

        CustomerTypeDto customerTypeDto;

        switch ( customerType ) {
            case DELIVERY: customerTypeDto = CustomerTypeDto.DELIVERY;
            break;
            case VET_PRACTICE: customerTypeDto = CustomerTypeDto.VET_PRACTICE;
            break;
            case OTHER: customerTypeDto = CustomerTypeDto.OTHER;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + customerType );
        }

        return customerTypeDto;
    }

    protected CustomerStateDto customerStateToCustomerStateDto(CustomerState customerState) {
        if ( customerState == null ) {
            return null;
        }

        CustomerStateDto customerStateDto;

        switch ( customerState ) {
            case ACTIVE: customerStateDto = CustomerStateDto.ACTIVE;
            break;
            case DELETED: customerStateDto = CustomerStateDto.DELETED;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + customerState );
        }

        return customerStateDto;
    }

    protected RejectionReasonDto rejectionReasonToRejectionReasonDto(RejectionReason rejectionReason) {
        if ( rejectionReason == null ) {
            return null;
        }

        RejectionReasonDto rejectionReasonDto;

        switch ( rejectionReason ) {
            case ADDRESS: rejectionReasonDto = RejectionReasonDto.ADDRESS;
            break;
            case NAME: rejectionReasonDto = RejectionReasonDto.NAME;
            break;
            case OTHER: rejectionReasonDto = RejectionReasonDto.OTHER;
            break;
            case REFERENCE: rejectionReasonDto = RejectionReasonDto.REFERENCE;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + rejectionReason );
        }

        return rejectionReasonDto;
    }

    protected void integerToPageInfoDto(Integer integer, PageInfoDto mappingTarget) {
        if ( integer == null ) {
            return;
        }

        mappingTarget.setPageNumber( integer );
    }

    protected void longToPageInfoDto(Long long1, PageInfoDto mappingTarget) {
        if ( long1 == null ) {
            return;
        }

        mappingTarget.setTotalElements( long1 );
    }

    protected void integerToPageInfoDto1(Integer integer, PageInfoDto mappingTarget) {
        if ( integer == null ) {
            return;
        }

        mappingTarget.setTotalPages( integer );
    }

    protected List<CustomerDto> customerViewListToCustomerDtoList(List<CustomerView> list) {
        if ( list == null ) {
            return null;
        }

        List<CustomerDto> list1 = new ArrayList<CustomerDto>( list.size() );
        for ( CustomerView customerView : list ) {
            list1.add( customerViewToCustomerDto( customerView ) );
        }

        return list1;
    }

    private CustomerStatus customerStatusLocalStatus(Customer customer) {
        if ( customer == null ) {
            return null;
        }
        com.zoetis.zdms.model.CustomerStatus status = customer.getStatus();
        if ( status == null ) {
            return null;
        }
        CustomerStatus localStatus = status.getLocalStatus();
        if ( localStatus == null ) {
            return null;
        }
        return localStatus;
    }

    private RejectionReason customerStatusRejectionReason(Customer customer) {
        if ( customer == null ) {
            return null;
        }
        com.zoetis.zdms.model.CustomerStatus status = customer.getStatus();
        if ( status == null ) {
            return null;
        }
        RejectionReason rejectionReason = status.getRejectionReason();
        if ( rejectionReason == null ) {
            return null;
        }
        return rejectionReason;
    }

    protected CustomerContactDetailsDto contactDetailsToCustomerContactDetailsDto(ContactDetails contactDetails) {
        if ( contactDetails == null ) {
            return null;
        }

        CustomerContactDetailsDto customerContactDetailsDto = new CustomerContactDetailsDto();

        customerContactDetailsDto.setEmail( contactDetails.getEmail() );
        customerContactDetailsDto.setPhoneNumber( contactDetails.getPhoneNumber() );
        customerContactDetailsDto.setSearchTerms( contactDetails.getSearchTerms() );

        return customerContactDetailsDto;
    }
}
