package com.zoetis.zdms.exception.common;

import com.zoetis.zdms.exception.status.ResponseStatus;
import com.zoetis.zdms.exception.status.ErrorMessage;
import com.zoetis.zdms.model.dictionary.ErrorCode;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, code = ErrorCode.CONFLICT, message = ErrorMessage.CONFLICT)
public class UniqueException extends RuntimeException {

    protected UniqueException(String message) {
        super(message);
    }

    public static UniqueException of(String message) {
        return new UniqueException(message);
    }
}
