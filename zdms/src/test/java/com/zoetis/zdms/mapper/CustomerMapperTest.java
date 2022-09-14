package com.zoetis.zdms.mapper;

import com.zoetis.zdms.UnitTest;
import com.zoetis.zdms.api.dto.*;
import com.zoetis.zdms.model.dictionary.CustomerState;
import com.zoetis.zdms.model.dictionary.CustomerType;
import com.zoetis.zdms.model.view.CustomerLookupView;
import com.zoetis.zdms.model.view.CustomerView;
import com.zoetis.zdms.util.factory.CustomerFactory;
import com.zoetis.zdms.util.factory.LocalizedCustomerStatusFactory;
import com.zoetis.zdms.util.factory.LocalizedRejectionReasonFactory;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.data.domain.Page;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class CustomerMapperTest extends UnitTest {

    private static final Integer PAGE_NUMBER = 0;
    private static final Integer TOTAL_PAGES = 2;
    private static final Long TOTAL_ELEMENTS = 20L;

    @Mock
    private Page<CustomerView> pagedCustomerViews;

    @Spy
    private DictionariesMapperImpl dictionariesMapper;

    @Spy
    private SourceSystemMapperImpl sourceSystemMapper;

    @Spy
    @InjectMocks
    private CustomerMapperImpl customerMapper;

    @Test
    void shouldMapPagedCustomerViewsToGetCustomersResponseDto() {
        //given
        List<CustomerView> customerViewList = Collections.singletonList(CustomerFactory.buildDefaultCustomerView());
        //when
        when(pagedCustomerViews.getNumber()).thenReturn(PAGE_NUMBER);
        when(pagedCustomerViews.getTotalElements()).thenReturn(TOTAL_ELEMENTS);
        when(pagedCustomerViews.getTotalPages()).thenReturn(TOTAL_PAGES);
        when(pagedCustomerViews.getContent()).thenReturn(customerViewList);

        CustomersResponseDto mappingResult = customerMapper.pagedCustomersToGetCustomersResponseDto(pagedCustomerViews);

        //then
        //pageInfo
        PageInfoDto mappingResultPageInfo = mappingResult.getPageInfo();
        assertEquals(PAGE_NUMBER, mappingResultPageInfo.getPageNumber());
        assertEquals(TOTAL_ELEMENTS, mappingResultPageInfo.getTotalElements());
        assertEquals(TOTAL_PAGES, mappingResultPageInfo.getTotalPages());

        //customers
        List<CustomerDto> mappingResultCustomers = mappingResult.getCustomers();
        assertEquals(1, mappingResultCustomers.size());

        CustomerDto mappingResultCustomerElement = mappingResultCustomers.get(0);
        assertEquals(CustomerFactory.ID, mappingResultCustomerElement.getId());
        assertEquals(CustomerFactory.ERP_ID, mappingResultCustomerElement.getErpId());
        assertEquals(CustomerFactory.TYPE, CustomerType.valueOf(mappingResultCustomerElement.getType().getValue()));
        assertEquals(LocalizedCustomerStatusFactory.CUSTOMER_STATUS, com.zoetis.zdms.model.dictionary.CustomerStatus.valueOf(mappingResultCustomerElement.getNativeStatus().getValue()));
        assertEquals(CustomerFactory.FORMATTED_COMPANY_NAME, mappingResultCustomerElement.getCompanyName());
        assertEquals(CustomerFactory.FORMATTED_ADDRESS, mappingResultCustomerElement.getAddress());
        assertEquals(CustomerFactory.STATE, CustomerState.valueOf(mappingResultCustomerElement.getState().getValue()));
        assertEquals(CustomerFactory.NATIVE_CREATED_DATE, mappingResultCustomerElement.getNativeCreatedDate());
        assertEquals(CustomerFactory.SOURCE, mappingResultCustomerElement.getSourceSystem().getName());
        assertEquals(RejectionReasonDto.fromValue(LocalizedRejectionReasonFactory.REJECTION_REASON.getValue()), mappingResultCustomerElement.getRejectionReason());
    }

    @Test
    void shouldMapCustomerLookupViewToCustomerLookupResponseDto() {
        //given
        CustomerLookupView customerLookupView = CustomerFactory.buildDefaultCustomerLookupView();

        //when
        CustomerLookupResponseDto mappingResult = customerMapper.customerLookupViewToResponseDto(customerLookupView);

        //then
        CustomerLookupDto mappingResultCustomerElement = mappingResult.getCustomerLookup();
        assertEquals(CustomerFactory.ID, mappingResultCustomerElement.getErpId());
        assertEquals(CustomerType.OTHER, CustomerType.valueOf(mappingResultCustomerElement.getType().getValue()));
        assertEquals(CustomerFactory.NAME_1, mappingResultCustomerElement.getName1());
        assertEquals(CustomerFactory.NAME_2, mappingResultCustomerElement.getName2());
        assertEquals(CustomerFactory.NAME_3, mappingResultCustomerElement.getName3());
        assertEquals(CustomerFactory.NAME_4, mappingResultCustomerElement.getName4());
        assertEquals(CustomerFactory.TITLE, mappingResultCustomerElement.getTitle());
        assertEquals(CustomerFactory.ADDRESS.getStreet() + CustomerFactory.ADDRESS.getStreetNumber(), mappingResultCustomerElement.getStreetAddress());
        assertEquals(CustomerFactory.ADDRESS.getPostalCode(), mappingResultCustomerElement.getPostalCode());
        assertEquals(CustomerFactory.ADDRESS.getCountryCode(), mappingResultCustomerElement.getCountryCode());
        assertEquals(CustomerFactory.ADDRESS.getCity(), mappingResultCustomerElement.getCity());

        CustomerContactDetailsDto mappingResultCustomerElementContactDetails = mappingResultCustomerElement.getContactDetails();
        assertEquals(CustomerFactory.CONTACT_DETAILS.getEmail(), mappingResultCustomerElementContactDetails.getEmail());
        assertEquals(CustomerFactory.CONTACT_DETAILS.getPhoneNumber(), mappingResultCustomerElementContactDetails.getPhoneNumber());
        assertEquals(CustomerFactory.CONTACT_DETAILS.getSearchTerms(), mappingResultCustomerElementContactDetails.getSearchTerms());
    }
}
