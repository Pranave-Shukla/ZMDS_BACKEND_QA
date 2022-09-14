package com.zoetis.zdms.model.dictionary.localized.rejectionreason;

import com.zoetis.zdms.model.dictionary.RejectionReason;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LocalizedRejectionReasonId implements Serializable {

    @Column(name = "LANG")
    private String language;

    @Column(name = "REASON")
    @Enumerated(EnumType.STRING)
    private RejectionReason rejectionReason;
}

