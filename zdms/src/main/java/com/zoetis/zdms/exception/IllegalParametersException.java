package com.zoetis.zdms.exception;

import com.zoetis.zdms.exception.common.BadRequestException;

public class IllegalParametersException extends BadRequestException {

    private IllegalParametersException(String message) {
        super(message);
    }

    public static IllegalParametersException of(String message) {
        return new IllegalParametersException(message);
    }
}
