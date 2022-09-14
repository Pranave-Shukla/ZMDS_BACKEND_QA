package com.zoetis.zdms.mapper;

import com.zoetis.zdms.api.dto.CustomerDto;
import com.zoetis.zdms.api.dto.CustomerLookupDto;
import com.zoetis.zdms.api.dto.CustomerLookupResponseDto;
import com.zoetis.zdms.api.dto.CustomersResponseDto;
import com.zoetis.zdms.model.Customer;
import com.zoetis.zdms.model.view.CustomerLookupView;
import com.zoetis.zdms.model.view.CustomerView;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

import java.util.List;

/*
 *   Mapping iterable objects should be handled in this topic: https://github.com/mapstruct/mapstruct/issues/607
 *   At this moment it is beta version
 *  */

@Mapper(componentModel = "spring", uses = {DictionariesMapper.class, SourceSystemMapper.class})
public interface CustomerMapper {

    @Mapping(target = "nativeStatus", source = "localStatus")
    @Mapping(target = "sourceSystem", source = "source")
    CustomerDto customerViewToCustomerDto(CustomerView customerView);

    default CustomersResponseDto pagedCustomersToGetCustomersResponseDto(Page<CustomerView> pagedCustomers) {
        return pagedCustomersToGetCustomersResponseDto(pagedCustomers.getNumber(), pagedCustomers.getContent(),
                pagedCustomers.getTotalPages(), pagedCustomers.getTotalElements());
    }

    @Mapping(target = "pageInfo.pageNumber", source = "pageNumber")
    @Mapping(target = "pageInfo.totalElements", source = "totalElements")
    @Mapping(target = "pageInfo.totalPages", source = "totalPages")
    @Mapping(target = "customers", source = "elements")
    CustomersResponseDto pagedCustomersToGetCustomersResponseDto(Integer pageNumber, List<CustomerView> elements, Integer totalPages, Long totalElements);

    @Mapping(target = "nativeStatus", source = "status.localStatus")
    @Mapping(target = "state", source = "state")
    @Mapping(target = "address", source = "formattedAddress")
    @Mapping(target = "companyName", source = "formattedCompanyName")
    @Mapping(target = "rejectionReason", source = "status.rejectionReason")
    @Mapping(target = "sourceSystem", source = "source")
    CustomerDto customerToCustomerDto(Customer customer);

    @Mapping(target = "erpId", source = "id")
    @Mapping(target = "type", source = "accountType")
    CustomerLookupDto customerLookupViewToDto(CustomerLookupView customerLookupView);

    @Mapping(target = "customerLookup", source = "customerLookupView")
    CustomerLookupResponseDto customerLookupViewToResponseDto(CustomerLookupView customerLookupView);

}
