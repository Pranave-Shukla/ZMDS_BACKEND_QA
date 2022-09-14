package com.zoetis.zdms.mapper;

import com.zoetis.zdms.api.dto.RejectionReasonDto;
import com.zoetis.zdms.model.dictionary.RejectionReason;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-22T09:15:30-0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11 (Oracle Corporation)"
)
@Component
public class RejectionReasonMapperImpl implements RejectionReasonMapper {

    @Override
    public RejectionReasonDto map(RejectionReason rejectionReason) {
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

    @Override
    public RejectionReason map(RejectionReasonDto rejectionReason) {
        if ( rejectionReason == null ) {
            return null;
        }

        RejectionReason rejectionReason1;

        switch ( rejectionReason ) {
            case ADDRESS: rejectionReason1 = RejectionReason.ADDRESS;
            break;
            case NAME: rejectionReason1 = RejectionReason.NAME;
            break;
            case OTHER: rejectionReason1 = RejectionReason.OTHER;
            break;
            case REFERENCE: rejectionReason1 = RejectionReason.REFERENCE;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + rejectionReason );
        }

        return rejectionReason1;
    }
}
