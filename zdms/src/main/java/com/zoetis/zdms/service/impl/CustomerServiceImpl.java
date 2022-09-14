package com.zoetis.zdms.service.impl;

import com.querydsl.core.types.Predicate;
import com.zoetis.zdms.dao.repository.CustomerLookupViewRepository;
import com.zoetis.zdms.dao.repository.CustomerRepository;
import com.zoetis.zdms.dao.repository.CustomerViewRepository;
import com.zoetis.zdms.exception.CustomerLookupNotFoundException;
import com.zoetis.zdms.exception.CustomerNotFoundException;
import com.zoetis.zdms.exception.IllegalParametersException;
import com.zoetis.zdms.model.Customer;
import com.zoetis.zdms.model.CustomerPartial;
import com.zoetis.zdms.model.dictionary.BooleanValue;
import com.zoetis.zdms.model.dictionary.Language;
import com.zoetis.zdms.model.dictionary.pageparameter.search.SearchBy;
import com.zoetis.zdms.model.dictionary.pageparameter.search.SearchByField;
import com.zoetis.zdms.model.dictionary.pageparameter.sort.SortBy;
import com.zoetis.zdms.model.dictionary.pageparameter.sort.SortDirection;
import com.zoetis.zdms.model.view.CustomerLookupView;
import com.zoetis.zdms.model.view.CustomerView;
import com.zoetis.zdms.service.CustomerService;
import com.zoetis.zdms.service.UserService;
import com.zoetis.zdms.service.impl.factory.PageFactory;
import com.zoetis.zdms.service.impl.factory.PredicateFactory;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerViewRepository customerViewRepository;
    private final CustomerLookupViewRepository customerLookupViewRepository;

    private final PredicateFactory predicateFactory;
    private final PageFactory pageFactory;

    private final UserService userService;

    @Override
    public Page<CustomerView> getCustomerViews(Integer pageNumber, Language language, Integer pageSize, SortDirection sortDirection,
                                               SortBy.Customer sortBy, Set<SearchBy<SearchByField.Customer>> searchBy) {
        log.info("[getCustomers] started processing with parameters [pageNumber = {}, language = {}, pageSize = {}, sortDirection = {}, sortBy = {}]",
                pageNumber, language, pageSize, sortDirection, sortBy);

        if (ObjectUtils.anyNull(pageNumber, language, pageSize, sortDirection, sortBy))
            throw IllegalParametersException.of(String.format("Parameters [%s, %s, %s, %s] cannot be null", pageNumber, pageSize, sortDirection, sortBy));

        Predicate predicate = predicateFactory.buildCustomerPredicate(searchBy, language);
        Pageable pageRequest = getPageRequestLimitedToLastPageNumber(pageNumber, pageSize, sortDirection, sortBy, predicate);

        log.debug("[CustomerViewRepository.findAll] invoked with parameters [predicate = {}, pageRequest = {}]", predicate, pageRequest);
        return customerViewRepository.findAll(predicate, pageRequest);
    }

    @Override
    public Customer getCustomer(String id) {
        log.info("[getCustomerDetails] started processing with parameters [id = {}]", id);
        log.debug("[CustomerRepository.findById] invoked with parameters [id = {}]", id);
        return customerRepository.findById(id)
                .orElseThrow(() -> CustomerNotFoundException.of("Customer not found"));
    }

    @Override
    @Transactional
    public Customer updateCustomer(String id, CustomerPartial customerPartial) {
        log.info("[updateCustomer] started processing with parameters [id = {}, customerPartial = {}]", id, customerPartial);
        log.debug("[CustomerRepository.findById] invoked with parameters [id = {}]", id);
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> CustomerNotFoundException.of("Customer not found"));
        com.zoetis.zdms.model.CustomerStatus customerStatus = customer.getStatus();

        customerStatus.setRejectionReason(customerPartial.getRejectionReason());
        customerStatus.setFreeText(customerPartial.getFreeText());
        customerStatus.setLocalStatus(customerPartial.getLocalStatus());

        customerStatus.setUpdatedBy(userService.getUser().getEmailAddress());
        customerStatus.setUpdatedDate(OffsetDateTime.now());
        customerStatus.setAppProcessed(BooleanValue.TRUE);
        log.debug("[CustomerRepository.save] invoked with parameters [customer = {}]", customer);
        return customerRepository.save(customer);
    }

    @Override
    public CustomerLookupView getCustomerLookup(String id) {
        log.info("[getCustomerLookup] started processing with parameters [id = {}]", id);
        log.debug("[CustomerLookupViewRepository.findById] invoked with parameters [id = {}]", id);
        return customerLookupViewRepository.findById(id)
                .orElseThrow(() -> CustomerLookupNotFoundException.of("Customer lookup not found"));
    }

    private Pageable getPageRequestLimitedToLastPageNumber(Integer pageNumber, Integer pageSize, SortDirection sortDirection,
                                                           SortBy.Customer sortBy, Predicate predicate) {
        log.debug("[CustomerViewRepository.count] invoked with parameters [predicate = {}]", predicate);
        long resultElementsCount = customerViewRepository.count(predicate);

        return pageFactory.buildCustomerPageRequest(resultElementsCount, pageNumber, pageSize, sortDirection, sortBy);
    }
}
