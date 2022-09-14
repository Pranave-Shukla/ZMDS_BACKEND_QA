package com.zoetis.zdms.mapper;

import com.zoetis.zdms.api.dto.BooleanValueDto;
import com.zoetis.zdms.api.dto.CustomerNativeStatusDto;
import com.zoetis.zdms.api.dto.CustomerStateDto;
import com.zoetis.zdms.api.dto.CustomerTypeDto;
import com.zoetis.zdms.api.dto.ErrorCodeDto;
import com.zoetis.zdms.api.dto.LocalizedBooleanValueDto;
import com.zoetis.zdms.api.dto.LocalizedCustomerNativeStatusDto;
import com.zoetis.zdms.api.dto.LocalizedCustomerStateDto;
import com.zoetis.zdms.api.dto.LocalizedCustomerTypeDto;
import com.zoetis.zdms.api.dto.LocalizedErrorCodeDto;
import com.zoetis.zdms.api.dto.LocalizedProductAvailabilityDto;
import com.zoetis.zdms.api.dto.LocalizedRejectionReasonDto;
import com.zoetis.zdms.api.dto.ProductAvailabilityDto;
import com.zoetis.zdms.api.dto.RejectionReasonDto;
import com.zoetis.zdms.model.dictionary.AccountType;
import com.zoetis.zdms.model.dictionary.Availability;
import com.zoetis.zdms.model.dictionary.BooleanValue;
import com.zoetis.zdms.model.dictionary.CustomerState;
import com.zoetis.zdms.model.dictionary.CustomerStatus;
import com.zoetis.zdms.model.dictionary.CustomerType;
import com.zoetis.zdms.model.dictionary.ErrorCode;
import com.zoetis.zdms.model.dictionary.RejectionReason;
import com.zoetis.zdms.model.dictionary.localized.booleanvalue.LocalizedBooleanValue;
import com.zoetis.zdms.model.dictionary.localized.booleanvalue.LocalizedBooleanValueId;
import com.zoetis.zdms.model.dictionary.localized.customerstate.LocalizedCustomerState;
import com.zoetis.zdms.model.dictionary.localized.customerstate.LocalizedCustomerStateId;
import com.zoetis.zdms.model.dictionary.localized.customerstatus.LocalizedCustomerStatus;
import com.zoetis.zdms.model.dictionary.localized.customerstatus.LocalizedCustomerStatusId;
import com.zoetis.zdms.model.dictionary.localized.customertype.LocalizedCustomerType;
import com.zoetis.zdms.model.dictionary.localized.customertype.LocalizedCustomerTypeId;
import com.zoetis.zdms.model.dictionary.localized.errorcode.LocalizedErrorCode;
import com.zoetis.zdms.model.dictionary.localized.errorcode.LocalizedErrorCodeId;
import com.zoetis.zdms.model.dictionary.localized.productavailability.LocalizedProductAvailability;
import com.zoetis.zdms.model.dictionary.localized.productavailability.LocalizedProductAvailabilityId;
import com.zoetis.zdms.model.dictionary.localized.rejectionreason.LocalizedRejectionReason;
import com.zoetis.zdms.model.dictionary.localized.rejectionreason.LocalizedRejectionReasonId;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-22T09:15:30-0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11 (Oracle Corporation)"
)
@Component
public class DictionariesMapperImpl implements DictionariesMapper {

    @Override
    public CustomerTypeDto accountTypeToCustomerTypeDto(AccountType accountType) {
        if ( accountType == null ) {
            return null;
        }

        CustomerTypeDto customerTypeDto;

        switch ( accountType ) {
            case VET_PRACTICE: customerTypeDto = CustomerTypeDto.VET_PRACTICE;
            break;
            default: customerTypeDto = CustomerTypeDto.OTHER;
        }

        return customerTypeDto;
    }

    @Override
    public LocalizedBooleanValueDto mapLocalizedBooleanValueToDto(LocalizedBooleanValue localizedBooleanValue) {
        if ( localizedBooleanValue == null ) {
            return null;
        }

        LocalizedBooleanValueDto localizedBooleanValueDto = new LocalizedBooleanValueDto();

        localizedBooleanValueDto.setValue( booleanValueToBooleanValueDto( localizedBooleanValueIdValue( localizedBooleanValue ) ) );
        localizedBooleanValueDto.setLocalizedValue( localizedBooleanValue.getLocalizedValue() );

        return localizedBooleanValueDto;
    }

    @Override
    public List<LocalizedBooleanValueDto> mapLocalizedBooleanValuesToDto(List<LocalizedBooleanValue> localizedBooleanValues) {
        if ( localizedBooleanValues == null ) {
            return null;
        }

        List<LocalizedBooleanValueDto> list = new ArrayList<LocalizedBooleanValueDto>( localizedBooleanValues.size() );
        for ( LocalizedBooleanValue localizedBooleanValue : localizedBooleanValues ) {
            list.add( mapLocalizedBooleanValueToDto( localizedBooleanValue ) );
        }

        return list;
    }

    @Override
    public LocalizedErrorCodeDto mapLocalizedErrorCodeToDto(LocalizedErrorCode localizedErrorCode) {
        if ( localizedErrorCode == null ) {
            return null;
        }

        LocalizedErrorCodeDto localizedErrorCodeDto = new LocalizedErrorCodeDto();

        localizedErrorCodeDto.setErrorCode( errorCodeToErrorCodeDto( localizedErrorCodeIdErrorCode( localizedErrorCode ) ) );
        localizedErrorCodeDto.setLocalizedErrorCode( localizedErrorCode.getLocalizedErrorCode() );

        return localizedErrorCodeDto;
    }

    @Override
    public List<LocalizedErrorCodeDto> mapLocalizedErrorCodesToDto(List<LocalizedErrorCode> localizedErrorCodes) {
        if ( localizedErrorCodes == null ) {
            return null;
        }

        List<LocalizedErrorCodeDto> list = new ArrayList<LocalizedErrorCodeDto>( localizedErrorCodes.size() );
        for ( LocalizedErrorCode localizedErrorCode : localizedErrorCodes ) {
            list.add( mapLocalizedErrorCodeToDto( localizedErrorCode ) );
        }

        return list;
    }

    @Override
    public LocalizedCustomerStateDto mapLocalizedCustomerStateToDto(LocalizedCustomerState localizedCustomerState) {
        if ( localizedCustomerState == null ) {
            return null;
        }

        LocalizedCustomerStateDto localizedCustomerStateDto = new LocalizedCustomerStateDto();

        localizedCustomerStateDto.setState( customerStateToCustomerStateDto( localizedCustomerStateIdState( localizedCustomerState ) ) );
        localizedCustomerStateDto.setLocalizedState( localizedCustomerState.getLocalizedState() );

        return localizedCustomerStateDto;
    }

    @Override
    public List<LocalizedCustomerStateDto> mapLocalizedCustomerStatesToDto(List<LocalizedCustomerState> localizedCustomerStates) {
        if ( localizedCustomerStates == null ) {
            return null;
        }

        List<LocalizedCustomerStateDto> list = new ArrayList<LocalizedCustomerStateDto>( localizedCustomerStates.size() );
        for ( LocalizedCustomerState localizedCustomerState : localizedCustomerStates ) {
            list.add( mapLocalizedCustomerStateToDto( localizedCustomerState ) );
        }

        return list;
    }

    @Override
    public LocalizedCustomerNativeStatusDto mapLocalizedCustomerStatusToDto(LocalizedCustomerStatus localizedCustomerStatus) {
        if ( localizedCustomerStatus == null ) {
            return null;
        }

        LocalizedCustomerNativeStatusDto localizedCustomerNativeStatusDto = new LocalizedCustomerNativeStatusDto();

        localizedCustomerNativeStatusDto.setNativeStatus( customerStatusToCustomerNativeStatusDto( localizedCustomerStatusIdStatus( localizedCustomerStatus ) ) );
        localizedCustomerNativeStatusDto.setLocalizedNativeStatus( localizedCustomerStatus.getLocalizedStatus() );

        return localizedCustomerNativeStatusDto;
    }

    @Override
    public List<LocalizedCustomerNativeStatusDto> mapLocalizedCustomerStatusesToDto(List<LocalizedCustomerStatus> localizedCustomerStatuses) {
        if ( localizedCustomerStatuses == null ) {
            return null;
        }

        List<LocalizedCustomerNativeStatusDto> list = new ArrayList<LocalizedCustomerNativeStatusDto>( localizedCustomerStatuses.size() );
        for ( LocalizedCustomerStatus localizedCustomerStatus : localizedCustomerStatuses ) {
            list.add( mapLocalizedCustomerStatusToDto( localizedCustomerStatus ) );
        }

        return list;
    }

    @Override
    public LocalizedCustomerTypeDto mapLocalizedCustomerTypeToDto(LocalizedCustomerType localizedCustomerType) {
        if ( localizedCustomerType == null ) {
            return null;
        }

        LocalizedCustomerTypeDto localizedCustomerTypeDto = new LocalizedCustomerTypeDto();

        localizedCustomerTypeDto.setType( customerTypeToCustomerTypeDto( localizedCustomerTypeIdType( localizedCustomerType ) ) );
        localizedCustomerTypeDto.setLocalizedType( localizedCustomerType.getLocalizedType() );

        return localizedCustomerTypeDto;
    }

    @Override
    public List<LocalizedCustomerTypeDto> mapLocalizedCustomerTypesToDto(List<LocalizedCustomerType> localizedCustomerTypes) {
        if ( localizedCustomerTypes == null ) {
            return null;
        }

        List<LocalizedCustomerTypeDto> list = new ArrayList<LocalizedCustomerTypeDto>( localizedCustomerTypes.size() );
        for ( LocalizedCustomerType localizedCustomerType : localizedCustomerTypes ) {
            list.add( mapLocalizedCustomerTypeToDto( localizedCustomerType ) );
        }

        return list;
    }

    @Override
    public LocalizedProductAvailabilityDto mapLocalizedProductAvailabilityToDto(LocalizedProductAvailability localizedProductAvailability) {
        if ( localizedProductAvailability == null ) {
            return null;
        }

        LocalizedProductAvailabilityDto localizedProductAvailabilityDto = new LocalizedProductAvailabilityDto();

        localizedProductAvailabilityDto.setAvailability( availabilityToProductAvailabilityDto( localizedProductAvailabilityIdAvailability( localizedProductAvailability ) ) );
        localizedProductAvailabilityDto.setLocalizedAvailability( localizedProductAvailability.getLocalizedAvailability() );

        return localizedProductAvailabilityDto;
    }

    @Override
    public List<LocalizedProductAvailabilityDto> mapLocalizedProductAvailabilitiesToDto(List<LocalizedProductAvailability> localizedProductAvailabilities) {
        if ( localizedProductAvailabilities == null ) {
            return null;
        }

        List<LocalizedProductAvailabilityDto> list = new ArrayList<LocalizedProductAvailabilityDto>( localizedProductAvailabilities.size() );
        for ( LocalizedProductAvailability localizedProductAvailability : localizedProductAvailabilities ) {
            list.add( mapLocalizedProductAvailabilityToDto( localizedProductAvailability ) );
        }

        return list;
    }

    @Override
    public LocalizedRejectionReasonDto mapLocalizedRejectionReasonToDto(LocalizedRejectionReason rejectionReason) {
        if ( rejectionReason == null ) {
            return null;
        }

        LocalizedRejectionReasonDto localizedRejectionReasonDto = new LocalizedRejectionReasonDto();

        localizedRejectionReasonDto.setRejectionReason( rejectionReasonToRejectionReasonDto( rejectionReasonIdRejectionReason( rejectionReason ) ) );
        localizedRejectionReasonDto.setLocalizedRejectionReason( rejectionReason.getLocalizedRejectionReason() );

        return localizedRejectionReasonDto;
    }

    @Override
    public List<LocalizedRejectionReasonDto> mapLocalizedRejectionReasonsToDto(List<LocalizedRejectionReason> rejectionReasons) {
        if ( rejectionReasons == null ) {
            return null;
        }

        List<LocalizedRejectionReasonDto> list = new ArrayList<LocalizedRejectionReasonDto>( rejectionReasons.size() );
        for ( LocalizedRejectionReason localizedRejectionReason : rejectionReasons ) {
            list.add( mapLocalizedRejectionReasonToDto( localizedRejectionReason ) );
        }

        return list;
    }

    private BooleanValue localizedBooleanValueIdValue(LocalizedBooleanValue localizedBooleanValue) {
        if ( localizedBooleanValue == null ) {
            return null;
        }
        LocalizedBooleanValueId id = localizedBooleanValue.getId();
        if ( id == null ) {
            return null;
        }
        BooleanValue value = id.getValue();
        if ( value == null ) {
            return null;
        }
        return value;
    }

    protected BooleanValueDto booleanValueToBooleanValueDto(BooleanValue booleanValue) {
        if ( booleanValue == null ) {
            return null;
        }

        BooleanValueDto booleanValueDto;

        switch ( booleanValue ) {
            case TRUE: booleanValueDto = BooleanValueDto.TRUE;
            break;
            case FALSE: booleanValueDto = BooleanValueDto.FALSE;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + booleanValue );
        }

        return booleanValueDto;
    }

    private ErrorCode localizedErrorCodeIdErrorCode(LocalizedErrorCode localizedErrorCode) {
        if ( localizedErrorCode == null ) {
            return null;
        }
        LocalizedErrorCodeId id = localizedErrorCode.getId();
        if ( id == null ) {
            return null;
        }
        ErrorCode errorCode = id.getErrorCode();
        if ( errorCode == null ) {
            return null;
        }
        return errorCode;
    }

    protected ErrorCodeDto errorCodeToErrorCodeDto(ErrorCode errorCode) {
        if ( errorCode == null ) {
            return null;
        }

        ErrorCodeDto errorCodeDto;

        switch ( errorCode ) {
            case INTERNAL_SERVER_ERROR: errorCodeDto = ErrorCodeDto.INTERNAL_SERVER_ERROR;
            break;
            case BAD_REQUEST: errorCodeDto = ErrorCodeDto.BAD_REQUEST;
            break;
            case FORBIDDEN: errorCodeDto = ErrorCodeDto.FORBIDDEN;
            break;
            case NOT_FOUND: errorCodeDto = ErrorCodeDto.NOT_FOUND;
            break;
            case CONFLICT: errorCodeDto = ErrorCodeDto.CONFLICT;
            break;
            case INCORRECT_FREE_TEXT_VALUE: errorCodeDto = ErrorCodeDto.INCORRECT_FREE_TEXT_VALUE;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + errorCode );
        }

        return errorCodeDto;
    }

    private CustomerState localizedCustomerStateIdState(LocalizedCustomerState localizedCustomerState) {
        if ( localizedCustomerState == null ) {
            return null;
        }
        LocalizedCustomerStateId id = localizedCustomerState.getId();
        if ( id == null ) {
            return null;
        }
        CustomerState state = id.getState();
        if ( state == null ) {
            return null;
        }
        return state;
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

    private CustomerStatus localizedCustomerStatusIdStatus(LocalizedCustomerStatus localizedCustomerStatus) {
        if ( localizedCustomerStatus == null ) {
            return null;
        }
        LocalizedCustomerStatusId id = localizedCustomerStatus.getId();
        if ( id == null ) {
            return null;
        }
        CustomerStatus status = id.getStatus();
        if ( status == null ) {
            return null;
        }
        return status;
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

    private CustomerType localizedCustomerTypeIdType(LocalizedCustomerType localizedCustomerType) {
        if ( localizedCustomerType == null ) {
            return null;
        }
        LocalizedCustomerTypeId id = localizedCustomerType.getId();
        if ( id == null ) {
            return null;
        }
        CustomerType type = id.getType();
        if ( type == null ) {
            return null;
        }
        return type;
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

    private Availability localizedProductAvailabilityIdAvailability(LocalizedProductAvailability localizedProductAvailability) {
        if ( localizedProductAvailability == null ) {
            return null;
        }
        LocalizedProductAvailabilityId id = localizedProductAvailability.getId();
        if ( id == null ) {
            return null;
        }
        Availability availability = id.getAvailability();
        if ( availability == null ) {
            return null;
        }
        return availability;
    }

    protected ProductAvailabilityDto availabilityToProductAvailabilityDto(Availability availability) {
        if ( availability == null ) {
            return null;
        }

        ProductAvailabilityDto productAvailabilityDto;

        switch ( availability ) {
            case AVAILABLE: productAvailabilityDto = ProductAvailabilityDto.AVAILABLE;
            break;
            case NOT_AVAILABLE: productAvailabilityDto = ProductAvailabilityDto.NOT_AVAILABLE;
            break;
            case SHORT_TERM_NOT_AVAILABLE: productAvailabilityDto = ProductAvailabilityDto.SHORT_TERM_NOT_AVAILABLE;
            break;
            case MEDIUM_TERM_NOT_AVAILABLE: productAvailabilityDto = ProductAvailabilityDto.MEDIUM_TERM_NOT_AVAILABLE;
            break;
            case LONG_TERM_NOT_AVAILABLE: productAvailabilityDto = ProductAvailabilityDto.LONG_TERM_NOT_AVAILABLE;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + availability );
        }

        return productAvailabilityDto;
    }

    private RejectionReason rejectionReasonIdRejectionReason(LocalizedRejectionReason localizedRejectionReason) {
        if ( localizedRejectionReason == null ) {
            return null;
        }
        LocalizedRejectionReasonId id = localizedRejectionReason.getId();
        if ( id == null ) {
            return null;
        }
        RejectionReason rejectionReason = id.getRejectionReason();
        if ( rejectionReason == null ) {
            return null;
        }
        return rejectionReason;
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
}
