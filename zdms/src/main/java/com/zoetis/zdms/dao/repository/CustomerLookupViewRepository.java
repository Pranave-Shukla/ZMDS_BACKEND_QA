package com.zoetis.zdms.dao.repository;

import com.zoetis.zdms.model.view.CustomerLookupView;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerLookupViewRepository extends PagingAndSortingRepository<CustomerLookupView, String> {
}
