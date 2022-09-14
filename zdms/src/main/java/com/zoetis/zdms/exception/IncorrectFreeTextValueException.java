package com.zoetis.zdms.exception;

import com.zoetis.zdms.exception.common.BadRequestException;
import com.zoetis.zdms.exception.status.ErrorMessage;
import com.zoetis.zdms.exception.status.ResponseStatus;
import com.zoetis.zdms.model.dictionary.ErrorCode;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, code = ErrorCode.INCORRECT_FREE_TEXT_VALUE, message = ErrorMessage.INCORRECT_FREE_TEXT_VALUE)
public class IncorrectFreeTextValueException extends BadRequestException {

    public IncorrectFreeTextValueException(String message) {
        super(message);
    }

    public static IncorrectFreeTextValueException of(String message) {
        return new IncorrectFreeTextValueException(message);
    }
}
