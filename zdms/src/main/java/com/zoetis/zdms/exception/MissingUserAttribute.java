package com.zoetis.zdms.exception;

import com.zoetis.zdms.exception.common.InternalServerException;

public class MissingUserAttribute extends InternalServerException {

    public MissingUserAttribute(String message) {
        super(message);
    }

    public static MissingUserAttribute of(String message) {
        return new MissingUserAttribute(message);
    }
}
