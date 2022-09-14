package com.zoetis.zdms.rest;

import com.zoetis.zdms.api.dto.CustomerLookupResponseDto;
import com.zoetis.zdms.api.rest.CustomerLookupApi;
import com.zoetis.zdms.mapper.CustomerMapper;
import com.zoetis.zdms.model.view.CustomerLookupView;
import com.zoetis.zdms.rest.factory.ResponseEntityFactory;
import com.zoetis.zdms.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CustomerLookupController implements CustomerLookupApi {

    private final CustomerService customerService;

    private final CustomerMapper customerMapper;

    public ResponseEntity<CustomerLookupResponseDto> getCustomerLookup(String id) {
        CustomerLookupView customerLookup = customerService.getCustomerLookup(id);

        CustomerLookupResponseDto customerLookupResponseDto = customerMapper.customerLookupViewToResponseDto(customerLookup);

        return ResponseEntityFactory.buildOk(customerLookupResponseDto);
    }
}
