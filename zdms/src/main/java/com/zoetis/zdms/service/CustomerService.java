package com.zoetis.zdms.service;

import com.zoetis.zdms.model.Customer;
import com.zoetis.zdms.model.CustomerPartial;
import com.zoetis.zdms.model.dictionary.Language;
import com.zoetis.zdms.model.dictionary.pageparameter.search.SearchBy;
import com.zoetis.zdms.model.dictionary.pageparameter.search.SearchByField;
import com.zoetis.zdms.model.dictionary.pageparameter.sort.SortBy;
import com.zoetis.zdms.model.dictionary.pageparameter.sort.SortDirection;
import com.zoetis.zdms.model.view.CustomerLookupView;
import com.zoetis.zdms.model.view.CustomerView;
import org.springframework.data.domain.Page;

import java.util.Set;

public interface CustomerService {

    Page<CustomerView> getCustomerViews(Integer pageNumber, Language language, Integer pageSize,
                                        SortDirection sortDirection, SortBy.Customer sortBy, Set<SearchBy<SearchByField.Customer>> searchBy);

    Customer getCustomer(String id);

    Customer updateCustomer(String id, CustomerPartial customerPartial);

    CustomerLookupView getCustomerLookup(String id);
}
