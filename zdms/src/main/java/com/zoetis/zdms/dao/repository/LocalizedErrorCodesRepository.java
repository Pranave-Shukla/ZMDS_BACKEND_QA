package com.zoetis.zdms.dao.repository;

import com.zoetis.zdms.model.dictionary.localized.errorcode.LocalizedErrorCode;
import com.zoetis.zdms.model.dictionary.localized.errorcode.LocalizedErrorCodeId;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalizedErrorCodesRepository extends PagingAndSortingRepository<LocalizedErrorCode, LocalizedErrorCodeId>, QuerydslPredicateExecutor<LocalizedErrorCode> {
}
