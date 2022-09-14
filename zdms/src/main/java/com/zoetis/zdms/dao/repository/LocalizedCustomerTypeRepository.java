package com.zoetis.zdms.dao.repository;

import com.zoetis.zdms.model.dictionary.localized.customertype.LocalizedCustomerType;
import com.zoetis.zdms.model.dictionary.localized.customertype.LocalizedCustomerTypeId;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalizedCustomerTypeRepository extends PagingAndSortingRepository<LocalizedCustomerType, LocalizedCustomerTypeId>, QuerydslPredicateExecutor<LocalizedCustomerType> {
}
