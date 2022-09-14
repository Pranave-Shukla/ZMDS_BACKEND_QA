package com.zoetis.zdms.dao.repository;

import com.zoetis.zdms.model.ProductMediaFile;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMediaFileRepository extends PagingAndSortingRepository<ProductMediaFile, Integer>, QuerydslPredicateExecutor<ProductMediaFile> {

}
