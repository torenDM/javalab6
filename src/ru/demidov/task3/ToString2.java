package ru.demidov.task3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Определение аннотации @ToString
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface ToString2 {
    enum Value { YES, NO }
    Value value() default Value.YES;
}