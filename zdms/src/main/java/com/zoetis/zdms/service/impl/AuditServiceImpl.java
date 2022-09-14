package com.zoetis.zdms.service.impl;

import com.querydsl.core.types.Predicate;
import com.zoetis.zdms.dao.repository.AuditRepository;
import com.zoetis.zdms.exception.IllegalParametersException;
import com.zoetis.zdms.model.Audit;
import com.zoetis.zdms.model.dictionary.pageparameter.search.SearchBy;
import com.zoetis.zdms.model.dictionary.pageparameter.search.SearchByField;
import com.zoetis.zdms.model.dictionary.pageparameter.sort.SortBy;
import com.zoetis.zdms.model.dictionary.pageparameter.sort.SortDirection;
import com.zoetis.zdms.service.AuditService;
import com.zoetis.zdms.service.impl.factory.PageFactory;
import com.zoetis.zdms.service.impl.factory.PredicateFactory;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class AuditServiceImpl implements AuditService {

    private final AuditRepository auditRepository;

    private final PageFactory pageFactory;
    private final PredicateFactory predicateFactory;

    @Override
    public Page<Audit> getAudits(Integer pageNumber, Integer pageSize, SortDirection sortDirection, SortBy.Audit sortBy, Set<SearchBy<SearchByField.Audit>> searchBy) {
        log.info("[getAudits] started processing with parameters [pageNumber = {}, pageSize = {}, sortDirection = {}, sortBy = {}, searchBy = {}]",
                pageNumber, pageSize, sortDirection, sortBy, searchBy);

        if (ObjectUtils.anyNull(pageNumber, pageSize, sortDirection, sortBy, searchBy))
            throw IllegalParametersException.of(String.format("Parameters [%s, %s, %s, %s, %s] cannot be null", pageNumber, pageSize, sortDirection, sortBy, searchBy));

        Predicate predicate = predicateFactory.buildAuditPredicate(searchBy);
        Pageable pageRequest = getPageRequestLimitedToLastPageNumber(pageNumber, pageSize, sortDirection, sortBy, predicate);

        log.debug("[AuditRepository.findAll] invoked with parameters [predicate = {}, pageRequest = {}]", predicate, pageRequest);
        return auditRepository.findAll(predicate, pageRequest);
    }

    private Pageable getPageRequestLimitedToLastPageNumber(Integer pageNumber, Integer pageSize, SortDirection sortDirection,
                                                           SortBy.Audit sortBy, Predicate predicate) {
        log.debug("[AuditRepository.count] invoked with parameters [predicate = {}]", predicate);
        long resultElementsCount = auditRepository.count(predicate);

        return pageFactory.buildAuditPageRequest(resultElementsCount, pageNumber, pageSize, sortDirection, sortBy);
    }
}
