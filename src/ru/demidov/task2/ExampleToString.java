package ru.demidov.task2;

// Пример использования
@ToString
public class ExampleToString {
    @ToString(ToString.Value.NO)
    private String hiddenField = "Скрыт";
    private String visibleField = "Открыт";
}
