package com.zoetis.zdms.dao.repository;

import com.zoetis.zdms.model.dictionary.localized.customerstate.LocalizedCustomerState;
import com.zoetis.zdms.model.dictionary.localized.customerstate.LocalizedCustomerStateId;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalizedCustomerStateRepository extends PagingAndSortingRepository<LocalizedCustomerState, LocalizedCustomerStateId>, QuerydslPredicateExecutor<LocalizedCustomerState> {
}
