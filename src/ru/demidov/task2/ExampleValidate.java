package ru.demidov.task2;

// Пример использования
@Validate({ExampleValidate.class})
public class ExampleValidate {
    public String validatedField = "Validated";
}
