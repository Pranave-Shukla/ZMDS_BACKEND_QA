package com.zoetis.zdms.mapper;

import com.zoetis.zdms.api.dto.CustomerDetailsDto;
import com.zoetis.zdms.api.dto.CustomerDetailsResponseDto;
import com.zoetis.zdms.model.Customer;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {DictionariesMapper.class, RejectionReasonMapper.class, SourceSystemMapper.class})
public interface CustomerDetailsMapper {

    @Mapping(target = "customer", source = "customer")
    CustomerDetailsResponseDto mapCustomerToCustomerDetailsResponseDto(Customer customer);

    @Mapping(target = "freeText", source = "customer.status.freeText")
    @Mapping(target = "nativeStatus", source = "customer.status.localStatus")
    @Mapping(target = "rejectionReason", source = "customer.status.rejectionReason")
    @Mapping(target = "city", source = "customer.address.city")
    @Mapping(target = "countryCode", source = "customer.address.countryCode")
    @Mapping(target = "postalCode", source = "customer.address.postalCode")
    @Mapping(target = "streetAddress", expression = "java(streetAndStreetNumberToStreetAddress(customer.getAddress().getStreet(), customer.getAddress().getStreetNumber()))")
    @Mapping(target = "sourceSystem.name", source = "customer.source")
    CustomerDetailsDto mapCustomerToCustomerDetailsDto(Customer customer);

    default String streetAndStreetNumberToStreetAddress(String street, String streetNumber) {
        return StringUtils.isNotEmpty(streetNumber) ? street + " " + streetNumber : street;
    }
}
