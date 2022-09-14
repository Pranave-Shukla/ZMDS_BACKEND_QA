package com.zoetis.zdms.mapper;

import com.zoetis.zdms.api.dto.AuditDataSetDto;
import com.zoetis.zdms.api.dto.AuditDto;
import com.zoetis.zdms.api.dto.AuditsResponseDto;
import com.zoetis.zdms.api.dto.PageInfoDto;
import com.zoetis.zdms.model.Audit;
import com.zoetis.zdms.model.dictionary.DataSet;
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
public class AuditMapperImpl implements AuditMapper {

    @Override
    public AuditsResponseDto pagedAuditsToGetAuditsResponseDto(Integer pageNumber, List<Audit> elements, Integer totalPages, Long totalElements) {
        if ( pageNumber == null && elements == null && totalPages == null && totalElements == null ) {
            return null;
        }

        AuditsResponseDto auditsResponseDto = new AuditsResponseDto();

        if ( pageNumber != null ) {
            if ( auditsResponseDto.getPageInfo() == null ) {
                auditsResponseDto.setPageInfo( new PageInfoDto() );
            }
            integerToPageInfoDto( pageNumber, auditsResponseDto.getPageInfo() );
        }
        if ( elements != null ) {
            auditsResponseDto.setAudits( auditListToAuditDtoList( elements ) );
        }
        if ( totalPages != null ) {
            if ( auditsResponseDto.getPageInfo() == null ) {
                auditsResponseDto.setPageInfo( new PageInfoDto() );
            }
            integerToPageInfoDto1( totalPages, auditsResponseDto.getPageInfo() );
        }
        if ( totalElements != null ) {
            if ( auditsResponseDto.getPageInfo() == null ) {
                auditsResponseDto.setPageInfo( new PageInfoDto() );
            }
            longToPageInfoDto( totalElements, auditsResponseDto.getPageInfo() );
        }

        return auditsResponseDto;
    }

    @Override
    public AuditDto auditToAuditDto(Audit audit) {
        if ( audit == null ) {
            return null;
        }

        AuditDto auditDto = new AuditDto();

        auditDto.setHeader( audit.getTransactionHeader() );
        auditDto.setMessage( audit.getTransactionMessage() );
        auditDto.setInitiator( audit.getLogBy() );
        auditDto.setDate( audit.getLogTime() );
        auditDto.setDataSet( dataSetToAuditDataSetDto( audit.getDataSet() ) );

        return auditDto;
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

    protected List<AuditDto> auditListToAuditDtoList(List<Audit> list) {
        if ( list == null ) {
            return null;
        }

        List<AuditDto> list1 = new ArrayList<AuditDto>( list.size() );
        for ( Audit audit : list ) {
            list1.add( auditToAuditDto( audit ) );
        }

        return list1;
    }

    protected AuditDataSetDto dataSetToAuditDataSetDto(DataSet dataSet) {
        if ( dataSet == null ) {
            return null;
        }

        AuditDataSetDto auditDataSetDto;

        switch ( dataSet ) {
            case CUSTOMER: auditDataSetDto = AuditDataSetDto.CUSTOMER;
            break;
            case PRODUCT: auditDataSetDto = AuditDataSetDto.PRODUCT;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + dataSet );
        }

        return auditDataSetDto;
    }
}
