package com.zoetis.zdms.mapper;

import com.zoetis.zdms.UnitTest;
import com.zoetis.zdms.api.dto.AuditDto;
import com.zoetis.zdms.api.dto.AuditsResponseDto;
import com.zoetis.zdms.api.dto.PageInfoDto;
import com.zoetis.zdms.model.Audit;
import com.zoetis.zdms.model.dictionary.DataSet;
import com.zoetis.zdms.util.factory.AuditFactory;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.data.domain.Page;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class AuditMapperTest extends UnitTest {

    private static final Integer PAGE_NUMBER = 0;
    private static final Integer TOTAL_PAGES = 2;
    private static final Long TOTAL_ELEMENTS = 20L;

    @Mock
    private Page<Audit> pagedAudits;

    @Spy
    private AuditMapperImpl auditMapper;

    @Test
    void shouldMapPagedAuditsToGetAuditsResponseDto() {
        //given
        List<Audit> auditList = Collections.singletonList(AuditFactory.buildDefaultAudit());
        //when
        when(pagedAudits.getNumber()).thenReturn(PAGE_NUMBER);
        when(pagedAudits.getTotalElements()).thenReturn(TOTAL_ELEMENTS);
        when(pagedAudits.getTotalPages()).thenReturn(TOTAL_PAGES);
        when(pagedAudits.getContent()).thenReturn(auditList);

        AuditsResponseDto mappingResult = auditMapper.pagedAuditsToGetAuditsResponseDto(pagedAudits);
        //then
        //pageInfo
        PageInfoDto mappingResultPageInfo = mappingResult.getPageInfo();
        assertEquals(PAGE_NUMBER, mappingResultPageInfo.getPageNumber());
        assertEquals(TOTAL_ELEMENTS, mappingResultPageInfo.getTotalElements());
        assertEquals(TOTAL_PAGES, mappingResultPageInfo.getTotalPages());

        //audits
        List<AuditDto> mappingResultAudits = mappingResult.getAudits();
        assertEquals(1, mappingResultAudits.size());

        AuditDto mappingResultAuditElement = mappingResultAudits.get(0);
        assertEquals(AuditFactory.DATA_SET, DataSet.valueOf(mappingResultAuditElement.getDataSet().getValue()));
        assertEquals(AuditFactory.TRANSACTION_HEADER, mappingResultAuditElement.getHeader());
        assertEquals(AuditFactory.TRANSACTION_MESSAGE, mappingResultAuditElement.getMessage());
        assertEquals(AuditFactory.LOG_BY, mappingResultAuditElement.getInitiator());
        assertEquals(AuditFactory.LOG_TIME, mappingResultAuditElement.getDate());
    }

}
