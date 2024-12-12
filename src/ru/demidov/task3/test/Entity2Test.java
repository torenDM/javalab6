package ru.demidov.task3.test;

import org.junit.jupiter.api.Test;
import ru.demidov.task3.Entity2;
import ru.demidov.task3.ToString2;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Тест для проверки поля с аннотацией @ToString
class Entity2Test {

    // Тестовый класс 1: Поля не помечены аннотацией, используются настройки по умолчанию
    static class TestClass1 extends Entity2 {
        String name = "Test";
        int value = 42;
    }

    // Тестовый класс 2: Аннотация на уровне полей
    static class TestClass2 extends Entity2 {
        @ToString2(ToString2.Value.NO)
        String hidden = "Hidden";
        String visible = "Visible";
    }

    // Тестовый класс 3: Аннотация на уровне класса
    @ToString2(ToString2.Value.NO)
    static class TestClass3 extends Entity2 {
        String ignored = "Ignored";
        @ToString2(ToString2.Value.YES)
        String included = "Included";
    }

    @Test
    void testToString_DefaultBehavior() {
        // Объект без аннотаций
        TestClass1 obj = new TestClass1();

        // Ожидаемое строковое представление
        String expected = "TestClass1{name=Test, value=42}";

        // Проверка корректности метода toString
        assertEquals(expected, obj.toString(), "toString() должен включать все поля по умолчанию.");
    }

    @Test
    void testToString_FieldAnnotations() {
        // Объект с аннотациями на полях
        TestClass2 obj = new TestClass2();

        // Ожидаемое строковое представление
        String expected = "TestClass2{visible=Visible}";

        // Проверка корректности метода toString
        assertEquals(expected, obj.toString(), "toString() должен исключать поля с @ToString(NO).");
    }

    @Test
    void testToString_ClassAnnotation() {
        // Объект с аннотацией на уровне класса
        TestClass3 obj = new TestClass3();

        // Ожидаемое строковое представление
        String expected = "TestClass3{included=Included}";

        // Проверка корректности метода toString
        assertEquals(expected, obj.toString(), "toString() должен учитывать аннотацию @ToString(NO) на уровне класса.");
    }
}