package com.zoetis.zdms.model;

import com.zoetis.zdms.model.dictionary.RejectionReason;
import lombok.*;

@Data
public class CustomerPartial {

    private com.zoetis.zdms.model.dictionary.CustomerStatus localStatus;
    private RejectionReason rejectionReason;
    private String freeText;
}
