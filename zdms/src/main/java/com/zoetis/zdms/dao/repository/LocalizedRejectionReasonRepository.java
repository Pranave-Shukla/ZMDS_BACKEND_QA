package com.zoetis.zdms.dao.repository;

import com.zoetis.zdms.model.dictionary.localized.rejectionreason.LocalizedRejectionReason;
import com.zoetis.zdms.model.dictionary.localized.rejectionreason.LocalizedRejectionReasonId;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalizedRejectionReasonRepository extends PagingAndSortingRepository<LocalizedRejectionReason, LocalizedRejectionReasonId>, QuerydslPredicateExecutor<LocalizedRejectionReason> {
}
