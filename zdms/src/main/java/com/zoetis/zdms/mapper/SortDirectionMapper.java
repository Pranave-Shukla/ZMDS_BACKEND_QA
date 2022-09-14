package com.zoetis.zdms.mapper;

import com.zoetis.zdms.api.dto.SortDirectionDto;
import com.zoetis.zdms.model.dictionary.pageparameter.sort.SortDirection;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SortDirectionMapper {

    SortDirection map(SortDirectionDto sortDirectionDto);
}
