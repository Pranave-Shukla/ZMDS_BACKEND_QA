package com.zoetis.zdms.dao.repository;

import com.zoetis.zdms.model.Customer;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, String>, QuerydslPredicateExecutor<Customer> {
}

