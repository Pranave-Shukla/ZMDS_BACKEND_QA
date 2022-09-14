package com.zoetis.zdms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class Address implements Serializable {

    private String countryCode;
    private String city;
    private String postalCode;
    private String street;
    private String streetNumber;
}