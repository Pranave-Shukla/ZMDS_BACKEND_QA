package com.zoetis.zdms.dao.repository;

import com.zoetis.zdms.model.view.CustomerView;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerViewRepository extends PagingAndSortingRepository<CustomerView, String>, QuerydslPredicateExecutor<CustomerView> {
}
