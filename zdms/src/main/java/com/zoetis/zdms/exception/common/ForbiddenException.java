package com.zoetis.zdms.exception.common;

import com.zoetis.zdms.exception.status.ResponseStatus;
import com.zoetis.zdms.exception.status.ErrorMessage;
import com.zoetis.zdms.model.dictionary.ErrorCode;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, code = ErrorCode.FORBIDDEN, message = ErrorMessage.FORBIDDEN)
public class ForbiddenException extends RuntimeException {

    protected ForbiddenException(String message) {
        super(message);
    }

    public static ForbiddenException of(String message) {
        return new ForbiddenException(message);
    }
}
