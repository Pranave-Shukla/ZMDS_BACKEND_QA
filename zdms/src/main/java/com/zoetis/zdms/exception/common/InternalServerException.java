package com.zoetis.zdms.exception.common;

import com.zoetis.zdms.exception.status.ResponseStatus;
import com.zoetis.zdms.exception.status.ErrorMessage;
import com.zoetis.zdms.model.dictionary.ErrorCode;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, code = ErrorCode.INTERNAL_SERVER_ERROR, message = ErrorMessage.INTERNAL_SERVER_ERROR)
public class InternalServerException extends RuntimeException {

    protected InternalServerException(String message) {
        super(message);
    }

    protected InternalServerException(Throwable throwable) {
        super(throwable);
    }

    public static InternalServerException of(String message) {
        return new InternalServerException(message);
    }

    public static InternalServerException of(Throwable throwable) {
        return new InternalServerException(throwable);
    }
}
