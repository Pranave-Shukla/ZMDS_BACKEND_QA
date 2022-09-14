package com.zoetis.zdms.dao.repository;

import com.zoetis.zdms.dao.projection.SourceSystemName;
import com.zoetis.zdms.model.SourceSystem;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface SourceSystemRepository extends PagingAndSortingRepository<SourceSystem, Integer>, QuerydslPredicateExecutor<SourceSystem> {


    Collection<SourceSystemName> findAllBy();
}