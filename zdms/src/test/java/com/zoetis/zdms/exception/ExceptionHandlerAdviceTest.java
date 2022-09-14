package com.zoetis.zdms.exception;

import com.zoetis.zdms.UnitTest;
import com.zoetis.zdms.api.dto.ErrorCodeDto;
import com.zoetis.zdms.api.dto.ErrorDto;
import com.zoetis.zdms.exception.common.BadRequestException;
import com.zoetis.zdms.exception.handler.ExceptionHandlerAdvice;
import com.zoetis.zdms.exception.status.ErrorMessage;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExceptionHandlerAdviceTest extends UnitTest {

    private final ExceptionHandlerAdvice exceptionHandler = new ExceptionHandlerAdvice();

    @Test
    public void testHandleCommonException() {
        BadRequestException ex = BadRequestException.of("Error message");

        ResponseEntity<ErrorDto> handleResult = exceptionHandler.handle(ex);

        assertEquals(HttpStatus.BAD_REQUEST, handleResult.getStatusCode());
        assertEquals(HttpStatus.BAD_REQUEST.value(), handleResult.getStatusCodeValue());
        ErrorDto handleResultBody = handleResult.getBody();
        assertEquals(ErrorMessage.BAD_REQUEST.getValue(), handleResultBody.getMessage());
        assertEquals(ErrorCodeDto.BAD_REQUEST, handleResultBody.getCode());
    }

    @Test
    public void testHandleCustomException() {
        CustomerLookupNotFoundException ex = CustomerLookupNotFoundException.of("Error message");

        ResponseEntity<ErrorDto> handleResult = exceptionHandler.handle(ex);

        assertEquals(HttpStatus.NOT_FOUND, handleResult.getStatusCode());
        assertEquals(HttpStatus.NOT_FOUND.value(), handleResult.getStatusCodeValue());
        ErrorDto handleResultBody = handleResult.getBody();
        assertEquals(ErrorMessage.CUSTOMER_LOOKUP_NOT_FOUND.getValue(), handleResultBody.getMessage());
        assertEquals(ErrorCodeDto.NOT_FOUND, handleResultBody.getCode());
    }

    @Test
    public void testHandleExceptionWithoutAnnotation() {
        RuntimeException ex = new RuntimeException();

        ResponseEntity<ErrorDto> handleResult = exceptionHandler.handle(ex);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, handleResult.getStatusCode());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), handleResult.getStatusCodeValue());
        ErrorDto handleResultBody = handleResult.getBody();
        assertEquals(ErrorMessage.INTERNAL_SERVER_ERROR.getValue(), handleResultBody.getMessage());
        assertEquals(ErrorCodeDto.INTERNAL_SERVER_ERROR, handleResultBody.getCode());
    }
}
