package com.zoetis.zdms.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.util.NoSuchElementException;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class NullableValue<T> implements Serializable {

    private final T value;
    private final boolean isPresent;

    public static <T> NullableValue<T> undefined() {
        return new NullableValue<T>(null, false);
    }

    public static <T> NullableValue<T> of(T value) {
        return new NullableValue<T>(value, true);
    }

    public T get() {
        if (!this.isPresent) {
            throw new NoSuchElementException("Value is undefined");
        } else {
            return this.value;
        }
    }

    public boolean isPresent() {
        return this.isPresent;
    }
}
