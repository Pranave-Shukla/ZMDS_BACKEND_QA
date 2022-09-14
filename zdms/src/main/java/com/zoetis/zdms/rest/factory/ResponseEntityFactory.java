package com.zoetis.zdms.rest.factory;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ResponseEntityFactory {

    public static <T> ResponseEntity<T> buildOk(T entity) {
        return Objects.nonNull(entity) ? ResponseEntity.ok(entity) : ResponseEntity.notFound().build();
    }

    public static ResponseEntity<Void> buildNoContent() {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
