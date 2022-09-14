package com.zoetis.zdms.util.factory;

import com.zoetis.zdms.model.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserFactory {

    public static final String FIRST_NAME = "first name";
    public static final String LAST_NAME = "last name";
    public static final String EMAIL_ADDRESS = "email address";

    public static User buildDefaultUser() {
        return User.of(FIRST_NAME, LAST_NAME, EMAIL_ADDRESS);
    }
}
