package com.zoetis.zdms.rest;

import com.zoetis.zdms.api.dto.CustomerDetailsResponseDto;
import com.zoetis.zdms.api.dto.CustomerPartialRequestDto;
import com.zoetis.zdms.api.dto.CustomersRequestDto;
import com.zoetis.zdms.api.dto.CustomersResponseDto;
import com.zoetis.zdms.api.rest.CustomerApi;
import com.zoetis.zdms.mapper.*;
import com.zoetis.zdms.model.Customer;
import com.zoetis.zdms.model.CustomerPartial;
import com.zoetis.zdms.model.dictionary.Language;
import com.zoetis.zdms.model.dictionary.pageparameter.search.SearchBy;
import com.zoetis.zdms.model.dictionary.pageparameter.search.SearchByField;
import com.zoetis.zdms.model.dictionary.pageparameter.sort.SortBy;
import com.zoetis.zdms.model.dictionary.pageparameter.sort.SortDirection;
import com.zoetis.zdms.model.view.CustomerView;
import com.zoetis.zdms.rest.factory.ResponseEntityFactory;
import com.zoetis.zdms.service.CustomerService;
import lombok.AllArgsConstructor;
import org.apache.commons.collections4.SetUtils;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class CustomerController implements CustomerApi {

    private final CustomerService customerService;

    private final CustomerMapper customerMapper;
    private final CustomerPartialMapper customerPartialMapper;
    private final CustomerDetailsMapper customerDetailsMapper;
    private final SortDirectionMapper sortDirectionMapper;
    private final SortByMapper sortByMapper;
    private final LanguageMapper languageMapper;
    private final SearchByMapper searchByMapper;

    @Override
    public ResponseEntity<CustomersResponseDto> getCustomers(CustomersRequestDto customersRequestDto) {
        SortDirection sortDirection = sortDirectionMapper.map(customersRequestDto.getSortDirection());
        SortBy.Customer sortBy = sortByMapper.mapSortCustomersByDto(customersRequestDto.getSortBy());
        Language language = languageMapper.map(customersRequestDto.getLanguage());
        Integer pageNumber = customersRequestDto.getPageNumber();
        Integer pageSize = customersRequestDto.getPageSize();

        Set<SearchBy<SearchByField.Customer>> searchBySet = SetUtils.emptyIfNull(customersRequestDto.getFilters())
                .stream()
                .map(searchByMapper::mapCustomerSearchByField)
                .collect(Collectors.toSet());

        Page<CustomerView> customers = customerService.getCustomerViews(pageNumber, language, pageSize, sortDirection, sortBy, searchBySet);
        CustomersResponseDto customersDto = customerMapper.pagedCustomersToGetCustomersResponseDto(customers);

        return ResponseEntityFactory.buildOk(customersDto);
    }

    @Override
    public ResponseEntity<CustomerDetailsResponseDto> getCustomerDetails(String id) {
        Customer customer = customerService.getCustomer(id);

        CustomerDetailsResponseDto customerDetailsDto = customerDetailsMapper.mapCustomerToCustomerDetailsResponseDto(customer);

        return ResponseEntityFactory.buildOk(customerDetailsDto);
    }

    @Override
    public ResponseEntity<Void> updateCustomer(String id, CustomerPartialRequestDto customerPartialRequestDto) {
        CustomerPartial customerPartial = customerPartialMapper.map(customerPartialRequestDto.getCustomerPartial());

        customerService.updateCustomer(id, customerPartial);

        return ResponseEntityFactory.buildNoContent();
    }
}
