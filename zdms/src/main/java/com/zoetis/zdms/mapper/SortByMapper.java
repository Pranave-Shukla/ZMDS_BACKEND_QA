package com.zoetis.zdms.mapper;

import com.zoetis.zdms.api.dto.SortAuditsByDto;
import com.zoetis.zdms.api.dto.SortCustomersByDto;
import com.zoetis.zdms.api.dto.SortProductsByDto;
import com.zoetis.zdms.model.dictionary.pageparameter.sort.SortBy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SortByMapper {

    SortBy.Customer mapSortCustomersByDto(SortCustomersByDto sortCustomersByDto);

    SortBy.Product mapSortProductsByDto(SortProductsByDto sortProductsByDto);

    SortBy.Audit mapSortAuditsDto(SortAuditsByDto sortAuditsByDto);

}
