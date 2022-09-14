package com.zoetis.zdms.service;

import com.zoetis.zdms.model.Audit;
import com.zoetis.zdms.model.dictionary.pageparameter.search.SearchBy;
import com.zoetis.zdms.model.dictionary.pageparameter.search.SearchByField;
import com.zoetis.zdms.model.dictionary.pageparameter.sort.SortBy;
import com.zoetis.zdms.model.dictionary.pageparameter.sort.SortDirection;
import org.springframework.data.domain.Page;

import java.util.Set;

public interface AuditService {

    Page<Audit> getAudits(Integer pageNumber, Integer pageSize, SortDirection sortDirection, SortBy.Audit sortBy, Set<SearchBy<SearchByField.Audit>> searchBy);
}
