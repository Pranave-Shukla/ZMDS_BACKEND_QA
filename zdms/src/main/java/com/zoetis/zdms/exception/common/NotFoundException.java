package com.zoetis.zdms.exception.common;

import com.zoetis.zdms.exception.status.ResponseStatus;
import com.zoetis.zdms.exception.status.ErrorMessage;
import com.zoetis.zdms.model.dictionary.ErrorCode;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, code = ErrorCode.NOT_FOUND, message = ErrorMessage.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    protected NotFoundException(String message) {
        super(message);
    }

    public static NotFoundException of(String message) {
        return new NotFoundException(message);
    }
}
