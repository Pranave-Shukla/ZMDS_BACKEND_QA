package com.zoetis.zdms.mapper;

import com.zoetis.zdms.api.dto.*;
import com.zoetis.zdms.model.dictionary.pageparameter.search.SearchBy;
import com.zoetis.zdms.model.dictionary.pageparameter.search.SearchByField;
import com.zoetis.zdms.model.dictionary.pageparameter.search.SearchByOperation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SearchByMapper {

    SearchByField.Customer dtoToSearchByFieldCustomer(SearchCustomersByFieldDto searchCustomersByFieldDto);

    SearchByField.Product dtoToSearchByFieldProduct(SearchProductsByFieldDto searchProductsByFieldDto);

    SearchByField.Audit dtoToSearchByFieldAudit(SearchAuditsByFieldDto searchAuditsByFieldDto);

    SearchByOperation dtoToSearchByOperation(SearchByOperationDto searchByOperationDto);

    @Mapping(target = "searchByField", expression = "java(dtoToSearchByFieldCustomer(searchCustomersByDto.getField()))")
    @Mapping(target = "searchByOperation", expression = "java(dtoToSearchByOperation(searchCustomersByDto.getOperation()))")
    SearchBy<SearchByField.Customer> mapCustomerSearchByField(SearchCustomersByDto searchCustomersByDto);

    @Mapping(target = "searchByField", expression = "java(dtoToSearchByFieldProduct(searchProductsByDto.getField()))")
    @Mapping(target = "searchByOperation", expression = "java(dtoToSearchByOperation(searchProductsByDto.getOperation()))")
    SearchBy<SearchByField.Product> mapProductSearchByField(SearchProductsByDto searchProductsByDto);

    @Mapping(target = "searchByField", expression = "java(dtoToSearchByFieldAudit(searchAuditsByDto.getField()))")
    @Mapping(target = "searchByOperation", expression = "java(dtoToSearchByOperation(searchAuditsByDto.getOperation()))")
    SearchBy<SearchByField.Audit> mapAuditSearchByField(SearchAuditsByDto searchAuditsByDto);
}
