package com.zoetis.zdms.mapper;

import com.zoetis.zdms.api.dto.CustomerPartialDto;
import com.zoetis.zdms.model.CustomerPartial;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerPartialMapper {

    @Mapping(target = "localStatus", source = "nativeStatus")
    CustomerPartial map(CustomerPartialDto customerPartialDto);
}
