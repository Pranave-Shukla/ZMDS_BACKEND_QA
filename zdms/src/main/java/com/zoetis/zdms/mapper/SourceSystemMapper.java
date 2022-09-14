package com.zoetis.zdms.mapper;

import com.zoetis.zdms.api.dto.SourceSystemDto;
import com.zoetis.zdms.api.dto.SourceSystemsResponseDto;
import com.zoetis.zdms.model.SourceSystem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface SourceSystemMapper {

    @Mapping(target = "name", source = "sourceSystem.name")
    SourceSystemDto mapSourceSystemToDto(SourceSystem sourceSystem);

    @Mapping(target = "name", source = "sourceSystem")
    SourceSystemDto mapSourceSystemNameToDto(String sourceSystem);

    default SourceSystemsResponseDto mapSourceSystemNamesToDto(Set<String> sourceSystemNames) {
        List<SourceSystemDto> sourceSystemDtoList = sourceSystemNames.stream()
                .map(this::mapSourceSystemNameToDto)
                .collect(Collectors.toList());

        return new SourceSystemsResponseDto()
                .sourceSystems(sourceSystemDtoList);
    }
}
