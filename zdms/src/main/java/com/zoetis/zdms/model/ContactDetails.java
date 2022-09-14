package com.zoetis.zdms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class ContactDetails {

    private String email;
    private String phoneNumber;
    private String searchTerms;
}
