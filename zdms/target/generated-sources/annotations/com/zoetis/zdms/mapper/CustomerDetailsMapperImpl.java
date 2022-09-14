package com.zoetis.zdms.mapper;

import com.zoetis.zdms.api.dto.CustomerDetailsDto;
import com.zoetis.zdms.api.dto.CustomerDetailsResponseDto;
import com.zoetis.zdms.api.dto.CustomerNativeStatusDto;
import com.zoetis.zdms.api.dto.CustomerStateDto;
import com.zoetis.zdms.api.dto.CustomerTypeDto;
import com.zoetis.zdms.api.dto.SourceSystemDto;
import com.zoetis.zdms.model.Address;
import com.zoetis.zdms.model.Customer;
import com.zoetis.zdms.model.CustomerStatus;
import com.zoetis.zdms.model.dictionary.CustomerState;
import com.zoetis.zdms.model.dictionary.CustomerType;
import com.zoetis.zdms.model.dictionary.RejectionReason;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-22T09:15:31-0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11 (Oracle Corporation)"
)
@Component
public class CustomerDetailsMapperImpl implements CustomerDetailsMapper {

    @Autowired
    private RejectionReasonMapper rejectionReasonMapper;

    @Override
    public CustomerDetailsResponseDto mapCustomerToCustomerDetailsResponseDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDetailsResponseDto customerDetailsResponseDto = new CustomerDetailsResponseDto();

        customerDetailsResponseDto.setCustomer( mapCustomerToCustomerDetailsDto( customer ) );

        return customerDetailsResponseDto;
    }

    @Override
    public CustomerDetailsDto mapCustomerToCustomerDetailsDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDetailsDto customerDetailsDto = new CustomerDetailsDto();

        customerDetailsDto.setSourceSystem( customerToSourceSystemDto( customer ) );
        customerDetailsDto.setFreeText( customerStatusFreeText( customer ) );
        customerDetailsDto.setNativeStatus( customerStatusToCustomerNativeStatusDto( customerStatusLocalStatus( customer ) ) );
        customerDetailsDto.setRejectionReason( rejectionReasonMapper.map( customerStatusRejectionReason( customer ) ) );
        customerDetailsDto.setCity( customerAddressCity( customer ) );
        customerDetailsDto.setCountryCode( customerAddressCountryCode( customer ) );
        customerDetailsDto.setPostalCode( customerAddressPostalCode( customer ) );
        customerDetailsDto.setId( customer.getId() );
        customerDetailsDto.setErpId( customer.getErpId() );
        customerDetailsDto.setFirstName( customer.getFirstName() );
        customerDetailsDto.setLastName( customer.getLastName() );
        customerDetailsDto.setNativeId( customer.getNativeId() );
        customerDetailsDto.setTitle( customer.getTitle() );
        customerDetailsDto.setCompanyName( customer.getCompanyName() );
        customerDetailsDto.setType( customerTypeToCustomerTypeDto( customer.getType() ) );
        customerDetailsDto.setState( customerStateToCustomerStateDto( customer.getState() ) );
        customerDetailsDto.setNativeCreatedDate( customer.getNativeCreatedDate() );

        customerDetailsDto.setStreetAddress( streetAndStreetNumberToStreetAddress(customer.getAddress().getStreet(), customer.getAddress().getStreetNumber()) );

        return customerDetailsDto;
    }

    protected SourceSystemDto customerToSourceSystemDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        SourceSystemDto sourceSystemDto = new SourceSystemDto();

        sourceSystemDto.setName( customer.getSource() );

        return sourceSystemDto;
    }

    private String customerStatusFreeText(Customer customer) {
        if ( customer == null ) {
            return null;
        }
        CustomerStatus status = customer.getStatus();
        if ( status == null ) {
            return null;
        }
        String freeText = status.getFreeText();
        if ( freeText == null ) {
            return null;
        }
        return freeText;
    }

    private com.zoetis.zdms.model.dictionary.CustomerStatus customerStatusLocalStatus(Customer customer) {
        if ( customer == null ) {
            return null;
        }
        CustomerStatus status = customer.getStatus();
        if ( status == null ) {
            return null;
        }
        com.zoetis.zdms.model.dictionary.CustomerStatus localStatus = status.getLocalStatus();
        if ( localStatus == null ) {
            return null;
        }
        return localStatus;
    }

    protected CustomerNativeStatusDto customerStatusToCustomerNativeStatusDto(com.zoetis.zdms.model.dictionary.CustomerStatus customerStatus) {
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

    private RejectionReason customerStatusRejectionReason(Customer customer) {
        if ( customer == null ) {
            return null;
        }
        CustomerStatus status = customer.getStatus();
        if ( status == null ) {
            return null;
        }
        RejectionReason rejectionReason = status.getRejectionReason();
        if ( rejectionReason == null ) {
            return null;
        }
        return rejectionReason;
    }

    private String customerAddressCity(Customer customer) {
        if ( customer == null ) {
            return null;
        }
        Address address = customer.getAddress();
        if ( address == null ) {
            return null;
        }
        String city = address.getCity();
        if ( city == null ) {
            return null;
        }
        return city;
    }

    private String customerAddressCountryCode(Customer customer) {
        if ( customer == null ) {
            return null;
        }
        Address address = customer.getAddress();
        if ( address == null ) {
            return null;
        }
        String countryCode = address.getCountryCode();
        if ( countryCode == null ) {
            return null;
        }
        return countryCode;
    }

    private String customerAddressPostalCode(Customer customer) {
        if ( customer == null ) {
            return null;
        }
        Address address = customer.getAddress();
        if ( address == null ) {
            return null;
        }
        String postalCode = address.getPostalCode();
        if ( postalCode == null ) {
            return null;
        }
        return postalCode;
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
}
