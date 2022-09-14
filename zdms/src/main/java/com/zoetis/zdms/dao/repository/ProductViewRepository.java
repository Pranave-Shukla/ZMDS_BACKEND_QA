package com.zoetis.zdms.dao.repository;

import com.zoetis.zdms.model.view.ProductView;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductViewRepository extends PagingAndSortingRepository<ProductView, String>, QuerydslPredicateExecutor<ProductView> {
}
