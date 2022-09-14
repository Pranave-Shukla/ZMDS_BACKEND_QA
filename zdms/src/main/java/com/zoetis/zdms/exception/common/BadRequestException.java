package com.zoetis.zdms.exception.common;

import com.zoetis.zdms.exception.CustomerLookupNotFoundException;
import com.zoetis.zdms.exception.status.ErrorMessage;
import com.zoetis.zdms.model.dictionary.ErrorCode;
import org.springframework.http.HttpStatus;
import com.zoetis.zdms.exception.status.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, code = ErrorCode.BAD_REQUEST, message = ErrorMessage.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

    protected BadRequestException(String message) {
        super(message);
    }

    public static BadRequestException of(String message) {
        return new BadRequestException(message);
    }
}
