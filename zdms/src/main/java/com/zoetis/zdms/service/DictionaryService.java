package com.zoetis.zdms.service;

import com.zoetis.zdms.model.dictionary.Language;
import com.zoetis.zdms.model.dictionary.localized.booleanvalue.LocalizedBooleanValue;
import com.zoetis.zdms.model.dictionary.localized.customerstate.LocalizedCustomerState;
import com.zoetis.zdms.model.dictionary.localized.customerstatus.LocalizedCustomerStatus;
import com.zoetis.zdms.model.dictionary.localized.customertype.LocalizedCustomerType;
import com.zoetis.zdms.model.dictionary.localized.errorcode.LocalizedErrorCode;
import com.zoetis.zdms.model.dictionary.localized.productavailability.LocalizedProductAvailability;
import com.zoetis.zdms.model.dictionary.localized.rejectionreason.LocalizedRejectionReason;

import java.util.List;

public interface DictionaryService {

    List<LocalizedBooleanValue> getLocalizedBooleanValues(Language language);
    List<LocalizedCustomerState> getLocalizedCustomerStates(Language language);
    List<LocalizedCustomerStatus> getLocalizedCustomerStatuses(Language language);
    List<LocalizedCustomerType> getLocalizedCustomerTypes(Language language);
    List<LocalizedProductAvailability> getLocalizedProductAvailabilities(Language language);
    List<LocalizedRejectionReason> getLocalizedRejectionReason(Language language);
    List<LocalizedErrorCode> getLocalizedErrorCodes(Language language);
}
