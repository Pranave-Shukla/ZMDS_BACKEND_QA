package com.zoetis.zdms.dao.repository;

import com.zoetis.zdms.model.Audit;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditRepository extends PagingAndSortingRepository<Audit, Integer>, QuerydslPredicateExecutor<Audit> {
}
