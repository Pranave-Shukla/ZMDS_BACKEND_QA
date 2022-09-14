package com.zoetis.zdms.service.factory;

import com.zoetis.zdms.UnitTest;
import com.zoetis.zdms.model.dictionary.pageparameter.sort.SortBy;
import com.zoetis.zdms.model.dictionary.pageparameter.sort.SortDirection;
import com.zoetis.zdms.service.impl.factory.PageFactory;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.data.domain.Pageable;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PageFactoryTest extends UnitTest {

    private static final Long ELEMENTS_COUNT = 5L;
    private static final Long ELEMENTS_COUNT_EMPTY = 0L;
    private static final Integer PAGE_NUMBER = 0;
    private static final Integer PAGE_NUMBER_OUT_OF_SCOPE = 1;
    private static final Integer PAGE_SIZE = 5;

    @InjectMocks
    private PageFactory pageFactory;

    @Test
    public void shouldBuildPageRequestWhenNoResult() {
        //given
        SortDirection sortDirection = SortDirection.ASC;
        SortBy.Audit auditSortBy = SortBy.Audit.DATA_SET;
        SortBy.Customer customerSortBy = SortBy.Customer.ADDRESS;
        SortBy.Product productSortBy = SortBy.Product.PRODUCT_ID;

        //when
        Pageable resultAuditPageable = pageFactory.buildAuditPageRequest(ELEMENTS_COUNT_EMPTY, PAGE_NUMBER_OUT_OF_SCOPE, PAGE_SIZE, sortDirection, auditSortBy);
        Pageable resultCustomerPageable = pageFactory.buildCustomerPageRequest(ELEMENTS_COUNT_EMPTY, PAGE_NUMBER_OUT_OF_SCOPE, PAGE_SIZE, sortDirection, customerSortBy);
        Pageable resultProductPageable = pageFactory.buildProductPageRequest(ELEMENTS_COUNT_EMPTY, PAGE_NUMBER_OUT_OF_SCOPE, PAGE_SIZE, sortDirection, productSortBy);

        /* 0 means pageNumber parameter with value 1 has been out of scope */
        assertEquals(PAGE_NUMBER, resultAuditPageable.getPageNumber());
        assertEquals(PAGE_SIZE, resultAuditPageable.getPageSize());

        assertEquals(PAGE_NUMBER, resultCustomerPageable.getPageNumber());
        assertEquals(PAGE_SIZE, resultCustomerPageable.getPageSize());

        assertEquals(PAGE_NUMBER, resultProductPageable.getPageNumber());
        assertEquals(PAGE_SIZE, resultProductPageable.getPageSize());
    }

    @Test
    public void shouldBuildAuditPageRequestWhenRequestPageNumberOutOfScope() {
        //given
        SortDirection sortDirection = SortDirection.ASC;
        SortBy.Audit sortBy = SortBy.Audit.DATA_SET;

        //when
        Pageable resultPageable = pageFactory.buildAuditPageRequest(ELEMENTS_COUNT, PAGE_NUMBER_OUT_OF_SCOPE, PAGE_SIZE, sortDirection, sortBy);

        /* 0 means pageNumber parameter with value 1 has been out of scope */
        assertEquals(PAGE_NUMBER, resultPageable.getPageNumber());
        assertEquals(PAGE_SIZE, resultPageable.getPageSize());
    }

    @Test
    public void shouldBuildAuditPageRequest() {
        //given
        SortDirection sortDirection = SortDirection.ASC;
        SortBy.Audit sortBy = SortBy.Audit.DATA_SET;

        //when
        Pageable resultPageable = pageFactory.buildAuditPageRequest(ELEMENTS_COUNT, PAGE_NUMBER, PAGE_SIZE, sortDirection, sortBy);

        assertEquals(PAGE_NUMBER, resultPageable.getPageNumber());
        assertEquals(PAGE_SIZE, resultPageable.getPageSize());
    }

    @Test
    public void shouldBuildCustomerPageRequestWhenRequestPageNumberOutOfScope() {
        //given
        SortDirection sortDirection = SortDirection.ASC;
        SortBy.Customer sortBy = SortBy.Customer.ADDRESS;

        //when
        Pageable resultPageable = pageFactory.buildCustomerPageRequest(ELEMENTS_COUNT, PAGE_NUMBER_OUT_OF_SCOPE, PAGE_SIZE, sortDirection, sortBy);

        /* 0 means pageNumber parameter with value 1 has been out of scope */
        assertEquals(PAGE_NUMBER, resultPageable.getPageNumber());
        assertEquals(ELEMENTS_COUNT, resultPageable.getPageSize());
    }

    @Test
    public void shouldBuildCustomerPageRequest() {
        //given
        SortDirection sortDirection = SortDirection.ASC;
        SortBy.Customer sortBy = SortBy.Customer.ADDRESS;

        //when
        Pageable resultPageable = pageFactory.buildCustomerPageRequest(ELEMENTS_COUNT, PAGE_NUMBER, PAGE_SIZE, sortDirection, sortBy);

        assertEquals(PAGE_NUMBER, resultPageable.getPageNumber());
        assertEquals(ELEMENTS_COUNT, resultPageable.getPageSize());
    }

    @Test
    public void shouldBuildProductPageRequestWhenRequestPageNumberOutOfScope() {
        //given
        SortDirection sortDirection = SortDirection.ASC;
        SortBy.Product sortBy = SortBy.Product.DESCRIPTION;

        //when
        Pageable resultPageable = pageFactory.buildProductPageRequest(ELEMENTS_COUNT, PAGE_NUMBER_OUT_OF_SCOPE, PAGE_SIZE, sortDirection, sortBy);

        /* 0 means pageNumber parameter with value 1 has been out of scope */
        assertEquals(PAGE_NUMBER, resultPageable.getPageNumber());
        assertEquals(ELEMENTS_COUNT, resultPageable.getPageSize());
    }

    @Test
    public void shouldBuildProductPageRequest() {
        //given
        SortDirection sortDirection = SortDirection.ASC;
        SortBy.Product sortBy = SortBy.Product.DESCRIPTION;

        //when
        Pageable resultPageable = pageFactory.buildProductPageRequest(ELEMENTS_COUNT, PAGE_NUMBER, PAGE_SIZE, sortDirection, sortBy);

        assertEquals(PAGE_NUMBER, resultPageable.getPageNumber());
        assertEquals(ELEMENTS_COUNT, resultPageable.getPageSize());
    }
}
