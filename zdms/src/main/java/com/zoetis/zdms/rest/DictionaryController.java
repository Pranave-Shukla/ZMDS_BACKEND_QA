package com.zoetis.zdms.rest;

import com.zoetis.zdms.api.dto.DictionariesResponseDto;
import com.zoetis.zdms.api.dto.LanguageDto;
import com.zoetis.zdms.api.rest.DictionaryApi;
import com.zoetis.zdms.mapper.DictionariesMapper;
import com.zoetis.zdms.mapper.LanguageMapper;
import com.zoetis.zdms.model.dictionary.Language;
import com.zoetis.zdms.model.dictionary.localized.booleanvalue.LocalizedBooleanValue;
import com.zoetis.zdms.model.dictionary.localized.customerstate.LocalizedCustomerState;
import com.zoetis.zdms.model.dictionary.localized.customerstatus.LocalizedCustomerStatus;
import com.zoetis.zdms.model.dictionary.localized.customertype.LocalizedCustomerType;
import com.zoetis.zdms.model.dictionary.localized.errorcode.LocalizedErrorCode;
import com.zoetis.zdms.model.dictionary.localized.productavailability.LocalizedProductAvailability;
import com.zoetis.zdms.model.dictionary.localized.rejectionreason.LocalizedRejectionReason;
import com.zoetis.zdms.rest.factory.ResponseEntityFactory;
import com.zoetis.zdms.service.DictionaryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class DictionaryController implements DictionaryApi {

    private final DictionaryService dictionaryService;

    private LanguageMapper languageMapper;
    private DictionariesMapper dictionariesMapper;

    @Override
    public ResponseEntity<DictionariesResponseDto> getDictionaries(LanguageDto languageDto) {
        Language language = languageMapper.map(languageDto);

        List<LocalizedCustomerState> localizedCustomerStates = dictionaryService.getLocalizedCustomerStates(language);
        List<LocalizedCustomerStatus> localizedCustomerStatuses = dictionaryService.getLocalizedCustomerStatuses(language);
        List<LocalizedCustomerType> localizedCustomerTypes = dictionaryService.getLocalizedCustomerTypes(language);
        List<LocalizedRejectionReason> localizedRejectionReason = dictionaryService.getLocalizedRejectionReason(language);
        List<LocalizedProductAvailability> localizedProductAvailabilities = dictionaryService.getLocalizedProductAvailabilities(language);
        List<LocalizedBooleanValue> localizedBooleanValues = dictionaryService.getLocalizedBooleanValues(language);
        List<LocalizedErrorCode> localizedErrorCodes = dictionaryService.getLocalizedErrorCodes(language);

        DictionariesResponseDto dictionariesResponseDto = dictionariesMapper.mapDictionariesToDto(
                localizedCustomerStates,
                localizedCustomerStatuses,
                localizedCustomerTypes,
                localizedRejectionReason,
                localizedProductAvailabilities,
                localizedBooleanValues,
                localizedErrorCodes
        );

        return ResponseEntityFactory.buildOk(dictionariesResponseDto);
    }

}
