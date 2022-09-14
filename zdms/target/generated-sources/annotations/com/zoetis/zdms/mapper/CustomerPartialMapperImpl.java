package com.zoetis.zdms.mapper;

import com.zoetis.zdms.api.dto.CustomerNativeStatusDto;
import com.zoetis.zdms.api.dto.CustomerPartialDto;
import com.zoetis.zdms.api.dto.RejectionReasonDto;
import com.zoetis.zdms.model.CustomerPartial;
import com.zoetis.zdms.model.dictionary.CustomerStatus;
import com.zoetis.zdms.model.dictionary.RejectionReason;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-22T09:15:30-0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11 (Oracle Corporation)"
)
@Component
public class CustomerPartialMapperImpl implements CustomerPartialMapper {

    @Override
    public CustomerPartial map(CustomerPartialDto customerPartialDto) {
        if ( customerPartialDto == null ) {
            return null;
        }

        CustomerPartial customerPartial = new CustomerPartial();

        customerPartial.setLocalStatus( customerNativeStatusDtoToCustomerStatus( customerPartialDto.getNativeStatus() ) );
        customerPartial.setRejectionReason( rejectionReasonDtoToRejectionReason( customerPartialDto.getRejectionReason() ) );
        customerPartial.setFreeText( customerPartialDto.getFreeText() );

        return customerPartial;
    }

    protected CustomerStatus customerNativeStatusDtoToCustomerStatus(CustomerNativeStatusDto customerNativeStatusDto) {
        if ( customerNativeStatusDto == null ) {
            return null;
        }

        CustomerStatus customerStatus;

        switch ( customerNativeStatusDto ) {
            case IN_REVIEW: customerStatus = CustomerStatus.IN_REVIEW;
            break;
            case VALIDATED: customerStatus = CustomerStatus.VALIDATED;
            break;
            case BLOCKED: customerStatus = CustomerStatus.BLOCKED;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + customerNativeStatusDto );
        }

        return customerStatus;
    }

    protected RejectionReason rejectionReasonDtoToRejectionReason(RejectionReasonDto rejectionReasonDto) {
        if ( rejectionReasonDto == null ) {
            return null;
        }

        RejectionReason rejectionReason;

        switch ( rejectionReasonDto ) {
            case ADDRESS: rejectionReason = RejectionReason.ADDRESS;
            break;
            case NAME: rejectionReason = RejectionReason.NAME;
            break;
            case OTHER: rejectionReason = RejectionReason.OTHER;
            break;
            case REFERENCE: rejectionReason = RejectionReason.REFERENCE;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + rejectionReasonDto );
        }

        return rejectionReason;
    }
}
