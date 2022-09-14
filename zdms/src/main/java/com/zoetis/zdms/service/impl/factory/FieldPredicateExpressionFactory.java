package com.zoetis.zdms.service.impl.factory;

import com.querydsl.core.types.dsl.*;
import com.zoetis.zdms.model.dictionary.BooleanValue;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

//todo refactor!!
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
@Slf4j
public class FieldPredicateExpressionFactory<T> {

    private static final String LIKE_CHARACTER = "%";

    private static final BiFunction<String, StringPath, BooleanExpression> SEARCH_OPERATION_LIKE_STRING = (value, stringPath) -> stringPath.likeIgnoreCase(LIKE_CHARACTER + value + LIKE_CHARACTER);
    private static final BiFunction<Integer, NumberPath<Integer>, BooleanExpression> SEARCH_OPERATION_LIKE_INTEGER = (value, integerPath) -> integerPath.like(LIKE_CHARACTER + value + LIKE_CHARACTER);
    private static final BiFunction<Integer, NumberPath<Integer>, BooleanExpression> SEARCH_OPERATION_GOE_INTEGER = (value, integerPath) -> integerPath.goe(value);
    private static final BiFunction<Integer, NumberPath<Integer>, BooleanExpression> SEARCH_OPERATION_NULL_OR_LOE_INTEGER = (value, integerPath) -> integerPath.isNull().or(integerPath.loe(value));


    private static final BiFunction<Date, DateTimePath<OffsetDateTime>, BooleanExpression> SEARCH_OPERATION_LIKE_OFFSET_DATE_TIME = (value, dateTimePath) ->
            dateTimePath.between(value.toInstant().atOffset(OffsetDateTime.now().getOffset()), value.toInstant().plus(1, ChronoUnit.DAYS).atOffset(OffsetDateTime.now().getOffset()));

    private static final BiFunction<List<? extends Enum>, EnumPath, BooleanExpression> SEARCH_OPERATION_IN_ENUM = (values, enumPath) -> enumPath.in(values);
    private static final BiFunction<List<String>, StringPath, BooleanExpression> SEARCH_OPERATION_IN_STRING = (values, stringPath) -> stringPath.in(values);

    private FieldType fieldType;

    private StringPath stringPath;

    private NumberPath<Integer> numberPath;

    private DateTimePath<OffsetDateTime> dateTimePath;

    private EnumPath<? extends Enum> enumPath;

    private Class<? extends Enum> enumExpressionClass;

    public static <T extends Enum> FieldPredicateExpressionFactory<T> enumOf(Class<T> enumExpressionClass, EnumPath enumPath) {
        return new FieldPredicateExpressionFactory.FieldPredicateExpressionFactoryBuilder<T>()
                .fieldType(FieldType.ENUM)
                .enumPath(enumPath)
                .enumExpressionClass(enumExpressionClass)
                .build();
    }

    public static FieldPredicateExpressionFactory<OffsetDateTime> offsetDateTimeOf(DateTimePath<OffsetDateTime> dateTimePath) {
        return new FieldPredicateExpressionFactoryBuilder<OffsetDateTime>()
                .fieldType(FieldType.DATE_TIME)
                .dateTimePath(dateTimePath)
                .build();
    }

    public static FieldPredicateExpressionFactory<String> stringOf(StringPath stringPath) {
        return new FieldPredicateExpressionFactoryBuilder<String>()
                .fieldType(FieldType.STRING)
                .stringPath(stringPath)
                .build();
    }

    public static FieldPredicateExpressionFactory<String> stringListOf(StringPath stringPath) {
        return new FieldPredicateExpressionFactoryBuilder<String>()
                .fieldType(FieldType.STRING_LIST)
                .stringPath(stringPath)
                .build();
    }

    public static FieldPredicateExpressionFactory<Integer> integerOf(NumberPath<Integer> numberPath) {
        return new FieldPredicateExpressionFactoryBuilder<Integer>()
                .fieldType(FieldType.NUMBER)
                .numberPath(numberPath)
                .build();
    }

    public static FieldPredicateExpressionFactory<Integer> integerToBooleanOf(NumberPath<Integer> numberPath) {
        return new FieldPredicateExpressionFactoryBuilder<Integer>()
                .fieldType(FieldType.NUMBER_TO_BOOLEAN)
                .numberPath(numberPath)
                .build();
    }

    public BooleanExpression create(List<String> values) {
        try {
            if (fieldType.equals(FieldType.STRING_LIST)) {
                return SEARCH_OPERATION_IN_STRING.apply(values, stringPath);
            }
            if (fieldType.equals(FieldType.STRING)) {
                return SEARCH_OPERATION_LIKE_STRING.apply(values.stream().findFirst().orElseThrow(), stringPath);
            } else if (fieldType.equals(FieldType.NUMBER)) {
                Integer integerValue = values.stream()
                        .map(Integer::valueOf)
                        .findFirst()
                        .orElseThrow();
                return SEARCH_OPERATION_LIKE_INTEGER.apply(integerValue, numberPath);
            } else if (fieldType.equals(FieldType.NUMBER_TO_BOOLEAN)) {
                BooleanExpression booleanExpression = null;
                List<BooleanValue> booleanValue = values.stream()
                        .map(BooleanValue::valueOf)
                        .collect(Collectors.toList());

                if (booleanValue.contains(BooleanValue.TRUE))
                    booleanExpression = SEARCH_OPERATION_GOE_INTEGER.apply(1, numberPath);
                if (booleanValue.contains(BooleanValue.FALSE)) {
                    BooleanExpression apply = SEARCH_OPERATION_NULL_OR_LOE_INTEGER.apply(0, numberPath);
                    booleanExpression = Objects.isNull(booleanExpression) ? apply : booleanExpression.or(apply);
                }

                return booleanExpression;

            } else if (fieldType.equals(FieldType.ENUM)) {
                List<? extends Enum> enumValues = values.stream()
                        .map(value -> Enum.valueOf(enumExpressionClass, value))
                        .collect(Collectors.toList());
                return SEARCH_OPERATION_IN_ENUM.apply(enumValues, enumPath);
            } else if (fieldType.equals(FieldType.DATE_TIME)) {
                String value = values.stream()
                        .findFirst()
                        .orElseThrow();
                Date dateValue = new SimpleDateFormat("yyyy-MM-dd").parse(value);
                return SEARCH_OPERATION_LIKE_OFFSET_DATE_TIME.apply(dateValue, dateTimePath);
            } else {
                throw new IllegalArgumentException("Unsupported field operation");
            }
        } catch (Exception ex) {
            log.error("Unexpected exception during creating Predicate Expression", ex);
            throw new IllegalArgumentException("Unsupported field operation");
        }
    }

    enum FieldType {
        STRING, STRING_LIST, ENUM, DATE_TIME, NUMBER, NUMBER_TO_BOOLEAN
    }
}
