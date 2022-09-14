package com.zoetis.zdms.mapper;

import com.zoetis.zdms.api.dto.LanguageDto;
import com.zoetis.zdms.model.dictionary.Language;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LanguageMapper {

     Language map(LanguageDto languageDto);
     LanguageDto map(Language language);
}
