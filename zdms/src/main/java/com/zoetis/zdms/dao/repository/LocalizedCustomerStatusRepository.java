package com.zoetis.zdms.dao.repository;

import com.zoetis.zdms.model.dictionary.localized.customerstatus.LocalizedCustomerStatus;
import com.zoetis.zdms.model.dictionary.localized.customerstatus.LocalizedCustomerStatusId;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalizedCustomerStatusRepository extends PagingAndSortingRepository<LocalizedCustomerStatus, LocalizedCustomerStatusId>, QuerydslPredicateExecutor<LocalizedCustomerStatus> {
}
