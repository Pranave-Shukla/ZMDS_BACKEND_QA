package com.zoetis.zdms.dao.repository;

import com.zoetis.zdms.model.Product;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Integer>, QuerydslPredicateExecutor<Product> {
}
