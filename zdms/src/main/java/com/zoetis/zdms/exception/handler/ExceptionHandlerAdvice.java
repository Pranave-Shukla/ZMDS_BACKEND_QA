package com.zoetis.zdms.exception.handler;

import com.zoetis.zdms.api.dto.ErrorCodeDto;
import com.zoetis.zdms.api.dto.ErrorDto;
import com.zoetis.zdms.exception.IncorrectFreeTextValueException;
import com.zoetis.zdms.exception.common.BadRequestException;
import com.zoetis.zdms.exception.common.InternalServerException;
import com.zoetis.zdms.exception.status.ResponseStatus;
import com.zoetis.zdms.exception.status.ErrorMessage;
import com.zoetis.zdms.model.dictionary.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.OffsetDateTime;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import static org.springframework.core.annotation.AnnotatedElementUtils.findMergedAnnotation;

@ControllerAdvice
@Slf4j
public class ExceptionHandlerAdvice {

    private final Map<String, Function<String, Exception>> FIELD_TO_EXCEPTION_MAP = Map.of(
            "customerPartial.freeText", IncorrectFreeTextValueException::of
    );

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<ErrorDto> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Exception exception = ex.getBindingResult()
                .getAllErrors()
                .stream().findFirst()
                .map((error) -> {
                    String fieldName = ((FieldError) error).getField();
                    String errorMessage = error.getDefaultMessage();

                    Optional<Function<String, Exception>> optionalIncorrectFieldException = Optional.ofNullable(FIELD_TO_EXCEPTION_MAP.get(fieldName));
                    return optionalIncorrectFieldException
                            .map(incorrectFieldException -> incorrectFieldException.apply(errorMessage))
                            .orElse(BadRequestException.of("Incorrect field value."));
                })
                .orElse(InternalServerException.of("No validation errors found."));

        return handle(exception);
    }

    @ExceptionHandler
    @ResponseBody
    public ResponseEntity<ErrorDto> handle(Exception exception) {
        ErrorDto body = new ErrorDto();
        Optional<ResponseStatus> responseStatus = resolveAnnotatedResponseStatus(exception);

        HttpStatus httpStatus = getHttpStatus(responseStatus);
        ErrorCode errorCode = getErrorCode(responseStatus);
        ErrorMessage errorMessage = getErrorMessage(responseStatus);

        body.setDate(OffsetDateTime.now());
        body.setCode(ErrorCodeDto.fromValue(errorCode.getValue()));
        body.setMessage(errorMessage.getValue());

        log.error("Processing request raised exception: [{}].", exception.getMessage());
        log.error("Stack trace:", exception);

        return new ResponseEntity<>(body, httpStatus);
    }

    private Optional<ResponseStatus> resolveAnnotatedResponseStatus(Exception exception) {
        return Optional.ofNullable(findMergedAnnotation(exception.getClass(), ResponseStatus.class));
    }

    private HttpStatus getHttpStatus(Optional<ResponseStatus> optionalResponseStatus) {
        return optionalResponseStatus
                .map(ResponseStatus::value)
                .orElse(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ErrorCode getErrorCode(Optional<ResponseStatus> optionalResponseStatus) {
        return optionalResponseStatus
                .map(ResponseStatus::code)
                .orElse(ErrorCode.INTERNAL_SERVER_ERROR);
    }

    private ErrorMessage getErrorMessage(Optional<ResponseStatus> optionalResponseStatus) {
        return optionalResponseStatus
                .map(ResponseStatus::message)
                .orElse(ErrorMessage.INTERNAL_SERVER_ERROR);
    }
}
