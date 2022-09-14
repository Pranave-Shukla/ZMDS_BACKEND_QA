package com.zoetis.zdms.dao.repository;

import com.zoetis.zdms.model.dictionary.localized.booleanvalue.LocalizedBooleanValue;
import com.zoetis.zdms.model.dictionary.localized.booleanvalue.LocalizedBooleanValueId;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalizedBooleanValueRepository extends PagingAndSortingRepository<LocalizedBooleanValue, LocalizedBooleanValueId>, QuerydslPredicateExecutor<LocalizedBooleanValue> {
}
