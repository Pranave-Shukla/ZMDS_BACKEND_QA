package com.zoetis.zdms.util.factory;

import com.zoetis.zdms.model.dictionary.Language;
import com.zoetis.zdms.model.dictionary.RejectionReason;
import com.zoetis.zdms.model.dictionary.localized.rejectionreason.LocalizedRejectionReason;
import com.zoetis.zdms.model.dictionary.localized.rejectionreason.LocalizedRejectionReasonId;
import lombok.experimental.UtilityClass;

@UtilityClass
public class LocalizedRejectionReasonFactory {

    public static final Language LANGUAGE = Language.DE;
    public static final RejectionReason REJECTION_REASON = RejectionReason.ADDRESS;
    public static final String LOCALIZED_REJECTION_REASON = "localized rejection reason";

    public LocalizedRejectionReason buildDefault() {
        return LocalizedRejectionReason.of(new LocalizedRejectionReasonId(LANGUAGE.getValue(), REJECTION_REASON), LOCALIZED_REJECTION_REASON);
    }
}
