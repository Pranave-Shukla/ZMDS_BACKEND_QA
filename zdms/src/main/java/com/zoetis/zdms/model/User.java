package com.zoetis.zdms.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "of")
public class User {

    private String firstName;
    private String lastName;
    private String emailAddress;
}
