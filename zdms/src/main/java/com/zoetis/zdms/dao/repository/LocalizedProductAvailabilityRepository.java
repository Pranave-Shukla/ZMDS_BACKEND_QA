package com.zoetis.zdms.dao.repository;

import com.zoetis.zdms.model.dictionary.localized.productavailability.LocalizedProductAvailability;
import com.zoetis.zdms.model.dictionary.localized.productavailability.LocalizedProductAvailabilityId;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalizedProductAvailabilityRepository extends PagingAndSortingRepository<LocalizedProductAvailability, LocalizedProductAvailabilityId>, QuerydslPredicateExecutor<LocalizedProductAvailability> {
}
