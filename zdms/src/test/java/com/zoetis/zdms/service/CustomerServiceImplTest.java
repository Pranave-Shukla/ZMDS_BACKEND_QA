package com.zoetis.zdms.service;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.StringPath;
import com.zoetis.zdms.UnitTest;
import com.zoetis.zdms.dao.repository.CustomerViewRepository;
import com.zoetis.zdms.model.dictionary.Language;
import com.zoetis.zdms.model.dictionary.pageparameter.search.SearchBy;
import com.zoetis.zdms.model.dictionary.pageparameter.search.SearchByField;
import com.zoetis.zdms.model.dictionary.pageparameter.sort.SortBy;
import com.zoetis.zdms.model.dictionary.pageparameter.sort.SortDirection;
import com.zoetis.zdms.model.view.CustomerView;
import com.zoetis.zdms.model.view.QCustomerView;
import com.zoetis.zdms.service.impl.CustomerServiceImpl;
import com.zoetis.zdms.service.impl.factory.PageFactory;
import com.zoetis.zdms.service.impl.factory.PredicateFactory;
import com.zoetis.zdms.util.factory.CustomerFactory;
import org.apache.commons.collections4.SetUtils;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.data.domain.*;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class CustomerServiceImplTest extends UnitTest {

    @Mock
    private CustomerViewRepository customerViewRepository;

    @Spy
    private PageFactory pageFactory;

    @Spy
    private PredicateFactory predicateFactory;

    @Captor
    private ArgumentCaptor<Pageable> pageableArgumentCaptor;

    @Captor
    private ArgumentCaptor<Predicate> predicateArgumentCaptor;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Test
    public void shouldGetPagedAndSortedCustomerViewList() {
        //given
        int pageNumber = 0;
        int pageSize = 5;
        long resultsCount = 30;
        Language language = Language.DE;
        SortDirection sortDirection = SortDirection.ASC;
        SortBy.Customer customerSortBy = SortBy.Customer.NATIVE_STATUS;
        Sort sortBy = Sort.by(Sort.Direction.valueOf(sortDirection.getValue()), PageFactory.CUSTOMER_SORT_KEYS.get(customerSortBy).toArray(new String[0]));
        Set<SearchBy<SearchByField.Customer>> searchBy = SetUtils.emptySet();

        Pageable pageable = PageRequest.of(pageNumber, pageSize, sortBy);
        List<CustomerView> customerViewList = Collections.singletonList(CustomerFactory.buildDefaultCustomerView());
        Page<CustomerView> page = new PageImpl<>(customerViewList, pageable, customerViewList.size());

        StringPath stateNativeLanguagePath = QCustomerView.customerView.stateNativeLanguage;
        StringPath localStatusLanguagePath = QCustomerView.customerView.localStatusLanguage;
        StringPath typeLanguagePath = QCustomerView.customerView.typeLanguage;
        StringPath rejectionReasonLanguagePath = QCustomerView.customerView.rejectionReasonLanguage;
        BooleanBuilder predicateBuilder = new BooleanBuilder()
                .and(stateNativeLanguagePath.isNull().or(stateNativeLanguagePath.equalsIgnoreCase(language.getValue())))
                .and(localStatusLanguagePath.isNull().or(localStatusLanguagePath.equalsIgnoreCase(language.getValue())))
                .and(typeLanguagePath.isNull().or(typeLanguagePath.equalsIgnoreCase(language.getValue())))
                .and(rejectionReasonLanguagePath.isNull().or(rejectionReasonLanguagePath.equalsIgnoreCase(language.getValue())));


        //when
        when(customerViewRepository.count(any(Predicate.class))).thenReturn(resultsCount);
        when(customerViewRepository.findAll(any(Predicate.class), any(Pageable.class))).thenReturn(page);

        Page<CustomerView> result = customerService.getCustomerViews(pageNumber, language, pageSize, sortDirection, customerSortBy, searchBy);

        Mockito.verify(customerViewRepository).findAll(predicateArgumentCaptor.capture(), pageableArgumentCaptor.capture());

        //then
        assertEquals(predicateBuilder, predicateArgumentCaptor.getValue());

        Pageable repositoryInvocationParameter = pageableArgumentCaptor.getValue();
        assertEquals(pageNumber, repositoryInvocationParameter.getPageNumber());
        List<Sort.Order> sortProperties = repositoryInvocationParameter.getSort().toList();
        assertEquals(2, sortProperties.size());

        Sort.Order firstSortProperty = sortProperties.get(0);
        assertEquals("localStatusLocalized", firstSortProperty.getProperty());
        assertEquals(Sort.Direction.valueOf(sortDirection.getValue()), firstSortProperty.getDirection());

        Sort.Order secondSortProperty = sortProperties.get(1);
        assertEquals("erpId", secondSortProperty.getProperty());
        assertEquals(Sort.Direction.valueOf(sortDirection.getValue()), secondSortProperty.getDirection());

        assertEquals(pageSize, repositoryInvocationParameter.getPageSize());

        assertEquals(pageNumber, result.getNumber());
        assertEquals(pageSize, result.getSize());
        assertEquals(sortBy, result.getSort());
        assertEquals(1, result.getTotalPages());
        assertEquals(customerViewList.size(), result.getTotalElements());
        assertEquals(customerViewList, result.getContent());
    }
}
