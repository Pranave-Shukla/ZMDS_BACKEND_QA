package com.zoetis.zdms.mapper;

import com.zoetis.zdms.UnitTest;
import com.zoetis.zdms.api.dto.PageInfoDto;
import com.zoetis.zdms.api.dto.ProductDto;
import com.zoetis.zdms.api.dto.ProductsResponseDto;
import com.zoetis.zdms.model.dictionary.Availability;
import com.zoetis.zdms.model.dictionary.BooleanValue;
import com.zoetis.zdms.model.view.ProductView;
import com.zoetis.zdms.util.factory.ProductFactory;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.data.domain.Page;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ProductMapperTest extends UnitTest {
    private static final Integer PAGE_NUMBER = 0;
    private static final Integer TOTAL_PAGES = 2;
    private static final Long TOTAL_ELEMENTS = 20L;

    @Mock
    private Page<ProductView> pagedProductViews;

    @Mock
    private DictionariesMapperImpl dictionariesMapper;

    @Spy
    private SourceSystemMapperImpl sourceSystemMapper;

    @Spy
    @InjectMocks
    private ProductMapperImpl productMapper;

    @Test
    void shouldMapPagedProductViewsToGetProductsResponseDto() {
        //given
        List<ProductView> productViewList = Collections.singletonList(ProductFactory.buildDefaultProductView());
        //when
        when(pagedProductViews.getNumber()).thenReturn(PAGE_NUMBER);
        when(pagedProductViews.getTotalElements()).thenReturn(TOTAL_ELEMENTS);
        when(pagedProductViews.getTotalPages()).thenReturn(TOTAL_PAGES);
        when(pagedProductViews.getContent()).thenReturn(productViewList);

        ProductsResponseDto mappingResult = productMapper.pagedProductViewsToProductsResponseDto(pagedProductViews);

        //then
        //pageInfo
        PageInfoDto mappingResultPageInfo = mappingResult.getPageInfo();
        assertEquals(PAGE_NUMBER, mappingResultPageInfo.getPageNumber());
        assertEquals(TOTAL_ELEMENTS, mappingResultPageInfo.getTotalElements());
        assertEquals(TOTAL_PAGES, mappingResultPageInfo.getTotalPages());

        //productViews
        List<ProductDto> mappingResultProducts = mappingResult.getProducts();
        assertEquals(1, mappingResultProducts.size());

        ProductDto mappingResultProductElement = mappingResultProducts.get(0);

        assertEquals(ProductFactory.PRODUCT_ID, Integer.valueOf(mappingResultProductElement.getId()));
        assertEquals(ProductFactory.STATUS_ID, Integer.valueOf(mappingResultProductElement.getStatusId()));
        assertEquals(ProductFactory.IS_VISIBLE, BooleanValue.valueOf(mappingResultProductElement.getIsVisible().getValue()));
        assertEquals(ProductFactory.AVAILABILITY, Availability.valueOf(mappingResultProductElement.getAvailability().getValue()));
        assertEquals(ProductFactory.DESCRIPTION, mappingResultProductElement.getDescription());
        assertEquals(ProductFactory.MINIMUM_ORDER_QUANTITY, mappingResultProductElement.getMinimumOrderQuantity());
        assertEquals(ProductFactory.MAXIMUM_ORDER_QUANTITY, mappingResultProductElement.getMaximumOrderQuantity());
        assertEquals(ProductFactory.HAS_MEDIA, BooleanValue.valueOf(mappingResultProductElement.getHasMedia().getValue()));
        assertEquals(ProductFactory.SOURCE, mappingResultProductElement.getSourceSystem().getName());
    }

}
