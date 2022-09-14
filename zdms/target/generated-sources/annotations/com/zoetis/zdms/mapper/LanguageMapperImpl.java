package com.zoetis.zdms.mapper;

import com.zoetis.zdms.api.dto.LanguageDto;
import com.zoetis.zdms.model.dictionary.Language;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-22T09:15:30-0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11 (Oracle Corporation)"
)
@Component
public class LanguageMapperImpl implements LanguageMapper {

    @Override
    public Language map(LanguageDto languageDto) {
        if ( languageDto == null ) {
            return null;
        }

        Language language;

        switch ( languageDto ) {
            case DE: language = Language.DE;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + languageDto );
        }

        return language;
    }

    @Override
    public LanguageDto map(Language language) {
        if ( language == null ) {
            return null;
        }

        LanguageDto languageDto;

        switch ( language ) {
            case DE: languageDto = LanguageDto.DE;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + language );
        }

        return languageDto;
    }
}
