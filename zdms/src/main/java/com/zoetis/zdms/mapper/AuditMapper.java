package com.zoetis.zdms.mapper;

import com.zoetis.zdms.api.dto.AuditDto;
import com.zoetis.zdms.api.dto.AuditsResponseDto;
import com.zoetis.zdms.model.Audit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuditMapper {

    default AuditsResponseDto pagedAuditsToGetAuditsResponseDto(Page<Audit> pagedAudits) {
        return pagedAuditsToGetAuditsResponseDto(pagedAudits.getNumber(), pagedAudits.getContent(),
                pagedAudits.getTotalPages(), pagedAudits.getTotalElements());
    }

    @Mapping(target = "pageInfo.pageNumber", source = "pageNumber")
    @Mapping(target = "pageInfo.totalElements", source = "totalElements")
    @Mapping(target = "pageInfo.totalPages", source = "totalPages")
    @Mapping(target = "audits", source = "elements")
    AuditsResponseDto pagedAuditsToGetAuditsResponseDto(Integer pageNumber, List<Audit> elements, Integer totalPages, Long totalElements);

    @Mapping(target = "header", source = "transactionHeader")
    @Mapping(target = "message", source = "transactionMessage")
    @Mapping(target = "initiator", source = "logBy")
    @Mapping(target = "date", source = "logTime")
    AuditDto auditToAuditDto(Audit audit);
}
