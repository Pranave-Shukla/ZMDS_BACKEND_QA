package com.zoetis.zdms.exception;

import com.zoetis.zdms.exception.common.NotFoundException;
import com.zoetis.zdms.exception.status.ResponseStatus;
import com.zoetis.zdms.exception.status.ErrorMessage;
import com.zoetis.zdms.model.dictionary.ErrorCode;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, code = ErrorCode.NOT_FOUND, message = ErrorMessage.PRODUCT_STATUS_NOT_FOUND)
public class ProductStatusNotFound extends NotFoundException {

    public ProductStatusNotFound(String message) {
        super(message);
    }

    public static ProductStatusNotFound of(String message) {
        return new ProductStatusNotFound(message);
    }
}
