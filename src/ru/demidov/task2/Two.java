package ru.demidov.task2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Определение аннотации @Two
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Two {
    String first();
    int second();
}