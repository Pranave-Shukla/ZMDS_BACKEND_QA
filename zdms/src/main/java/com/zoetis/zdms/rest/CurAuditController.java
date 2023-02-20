package com.zoetis.zdms.rest;
import com.zoetis.zdms.CurAuditApi.CurAuditApi;
import com.zoetis.zdms.api.dto.AuditDto;
import com.zoetis.zdms.api.dto.AuditsRequestDto;
import com.zoetis.zdms.api.dto.AuditsResponseDto;
import com.zoetis.zdms.api.rest.AuditApi;
import com.zoetis.zdms.mapper.AuditMapper;
import com.zoetis.zdms.mapper.SearchByMapper;
import com.zoetis.zdms.mapper.SortByMapper;
import com.zoetis.zdms.mapper.SortDirectionMapper;
import com.zoetis.zdms.model.Audit;
import com.zoetis.zdms.model.dictionary.pageparameter.search.SearchBy;
import com.zoetis.zdms.model.dictionary.pageparameter.search.SearchByField;
import com.zoetis.zdms.model.dictionary.pageparameter.sort.SortBy;
import com.zoetis.zdms.model.dictionary.pageparameter.sort.SortDirection;
import com.zoetis.zdms.rest.factory.ResponseEntityFactory;
import com.zoetis.zdms.service.AuditService;
import lombok.AllArgsConstructor;
import org.apache.commons.collections4.SetUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Spliterator;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@AllArgsConstructor

public class CurAuditController implements CurAuditApi {

    private final AuditService auditService ;

    private final SortByMapper sortByMapper ;
    private final SearchByMapper searchByMapper ;
    private final SortDirectionMapper sortDirectionMapper ;

    private final AuditMapper auditMapper ;

    @Override
    public ResponseEntity<AuditsResponseDto> getCurAudits(AuditsRequestDto auditsRequestDto) {
        SortDirection sortDirection = sortDirectionMapper.map(auditsRequestDto.getSortDirection());
        SortBy.Audit sortBy = sortByMapper.mapSortAuditsDto(auditsRequestDto.getSortBy());
        Integer pageNumber = auditsRequestDto.getPageNumber();
        Integer pageSize = auditsRequestDto.getPageSize();


        Set<SearchBy<SearchByField.Audit>> searchBySet = SetUtils.emptyIfNull(auditsRequestDto.getFilters())
                .stream()
                .map(searchByMapper::mapAuditSearchByField)
                .collect(Collectors.toSet());

        Page<Audit> audits = auditService.getCurAudits(pageNumber, pageSize, sortDirection, sortBy, searchBySet);

        AuditsResponseDto auditsDto = auditMapper.pagedAuditsToGetAuditsResponseDto(audits);

        return ResponseEntityFactory.buildOk(auditsDto);
    }
}