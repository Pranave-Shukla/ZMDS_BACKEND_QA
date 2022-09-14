package com.zoetis.zdms.service.impl;

import com.zoetis.zdms.dao.repository.*;
import com.zoetis.zdms.model.dictionary.Language;
import com.zoetis.zdms.model.dictionary.localized.booleanvalue.LocalizedBooleanValue;
import com.zoetis.zdms.model.dictionary.localized.booleanvalue.QLocalizedBooleanValue;
import com.zoetis.zdms.model.dictionary.localized.customerstate.LocalizedCustomerState;
import com.zoetis.zdms.model.dictionary.localized.customerstate.QLocalizedCustomerState;
import com.zoetis.zdms.model.dictionary.localized.customerstatus.LocalizedCustomerStatus;
import com.zoetis.zdms.model.dictionary.localized.customerstatus.QLocalizedCustomerStatus;
import com.zoetis.zdms.model.dictionary.localized.customertype.LocalizedCustomerType;
import com.zoetis.zdms.model.dictionary.localized.customertype.QLocalizedCustomerType;
import com.zoetis.zdms.model.dictionary.localized.errorcode.LocalizedErrorCode;
import com.zoetis.zdms.model.dictionary.localized.errorcode.QLocalizedErrorCode;
import com.zoetis.zdms.model.dictionary.localized.productavailability.LocalizedProductAvailability;
import com.zoetis.zdms.model.dictionary.localized.productavailability.QLocalizedProductAvailability;
import com.zoetis.zdms.model.dictionary.localized.rejectionreason.LocalizedRejectionReason;
import com.zoetis.zdms.model.dictionary.localized.rejectionreason.QLocalizedRejectionReason;
import com.zoetis.zdms.service.DictionaryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
@Slf4j
public class DictionaryServiceImpl implements DictionaryService {

    private final LocalizedBooleanValueRepository localizedBooleanValueRepository;
    private final LocalizedCustomerStateRepository localizedCustomerStateRepository;
    private final LocalizedCustomerStatusRepository localizedCustomerStatusRepository;
    private final LocalizedCustomerTypeRepository localizedCustomerTypeRepository;
    private final LocalizedProductAvailabilityRepository localizedProductAvailabilityRepository;
    private final LocalizedRejectionReasonRepository localizedRejectionReasonRepository;
    private final LocalizedErrorCodesRepository localizedErrorCodesRepository;

    @Override
    @Cacheable("getLocalizedBooleanValues")
    public List<LocalizedBooleanValue> getLocalizedBooleanValues(Language language) {
        log.info("[getLocalizedBooleanValues] started processing with parameters [language = {}]}", language);
        return StreamSupport
                .stream(localizedBooleanValueRepository.findAll(QLocalizedBooleanValue.localizedBooleanValue.id.language.equalsIgnoreCase(language.getValue())).spliterator(), true)
                .collect(Collectors.toList());
    }

    @Override
    @Cacheable("getLocalizedCustomerStates")
    public List<LocalizedCustomerState> getLocalizedCustomerStates(Language language) {
        log.info("[getLocalizedCustomerStates] started processing with parameters [language = {}]}", language);
        return StreamSupport
                .stream(localizedCustomerStateRepository.findAll(QLocalizedCustomerState.localizedCustomerState.id.language.equalsIgnoreCase(language.getValue())).spliterator(), true)
                .collect(Collectors.toList());
    }

    @Override
    @Cacheable("getLocalizedCustomerStatuses")
    public List<LocalizedCustomerStatus> getLocalizedCustomerStatuses(Language language) {
        log.info("[getLocalizedCustomerStatuses] started processing with parameters [language = {}]}", language);
        return StreamSupport
                .stream(localizedCustomerStatusRepository.findAll(QLocalizedCustomerStatus.localizedCustomerStatus.id.language.equalsIgnoreCase(language.getValue())).spliterator(), true)
                .collect(Collectors.toList());
    }

    @Override
    @Cacheable("getLocalizedCustomerTypes")
    public List<LocalizedCustomerType> getLocalizedCustomerTypes(Language language) {
        log.info("[getLocalizedCustomerTypes] started processing with parameters [language = {}]}", language);
        return StreamSupport
                .stream(localizedCustomerTypeRepository.findAll(QLocalizedCustomerType.localizedCustomerType.id.language.equalsIgnoreCase(language.getValue())).spliterator(), true)
                .collect(Collectors.toList());
    }

    @Override
    @Cacheable("getLocalizedProductAvailabilities")
    public List<LocalizedProductAvailability> getLocalizedProductAvailabilities(Language language) {
        log.info("[getLocalizedProductAvailabilities] started processing with parameters [language = {}]}", language);
        return StreamSupport
                .stream(localizedProductAvailabilityRepository.findAll(QLocalizedProductAvailability.localizedProductAvailability.id.language.equalsIgnoreCase(language.getValue())).spliterator(), true)
                .collect(Collectors.toList());
    }

    @Override
    @Cacheable("getLocalizedRejectionReason")
    public List<LocalizedRejectionReason> getLocalizedRejectionReason(Language language) {
        log.info("[getLocalizedRejectionReason] started processing with parameters [language = {}]}", language);
        return StreamSupport
                .stream(localizedRejectionReasonRepository.findAll(QLocalizedRejectionReason.localizedRejectionReason1.id.language.equalsIgnoreCase(language.getValue())).spliterator(), true)
                .collect(Collectors.toList());
    }

    @Override
    @Cacheable("getLocalizedErrorCodes")
    public List<LocalizedErrorCode> getLocalizedErrorCodes(Language language) {
        return StreamSupport
                .stream(localizedErrorCodesRepository.findAll(QLocalizedErrorCode.localizedErrorCode1.id.language.equalsIgnoreCase(language.getValue())).spliterator(), true)
                .collect(Collectors.toList());
    }
}
