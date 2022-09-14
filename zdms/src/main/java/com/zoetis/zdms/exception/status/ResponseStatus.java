package com.zoetis.zdms.exception.status;

import com.zoetis.zdms.model.dictionary.ErrorCode;
import org.springframework.http.HttpStatus;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ResponseStatus {

    HttpStatus value() default HttpStatus.INTERNAL_SERVER_ERROR;

    ErrorCode code() default ErrorCode.INTERNAL_SERVER_ERROR;

    ErrorMessage message() default ErrorMessage.INTERNAL_SERVER_ERROR;
}
