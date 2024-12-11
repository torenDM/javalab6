package ru.demidov.main;

import ru.demidov.task1.*;
import ru.demidov.task2.*;
import ru.demidov.task3.*;

// Основной класс для тестирования
public class Main {
    public static void main(String[] args) throws Exception {
        // Задача 1.1: Рефлексия
        System.out.println("\nЗадача 1.1: Рефлексия");
        B b = new B();
        System.out.println("Ответ: "+b);

        // Задача 2.1: Аннотации @Invoke
        System.out.println("\nЗадача 2.1: Аннотации @Invoke");
        ExampleInvoke exampleInvoke = new ExampleInvoke();
        exampleInvoke.getClass().getMethod("annotatedMethod").invoke(exampleInvoke);

        // Задача 2.2: Аннотации @Default
        System.out.println("\nЗадача 2.2: Аннотации @Default");
        ExampleDefault exampleDefault = new ExampleDefault();
        System.out.println("Класс с @Default: " + exampleDefault.name);

        // Задача 2.3: Аннотации @ToString
        System.out.println("\nЗадача 2.3: Аннотации @ToString");
        ExampleToString exampleToString = new ExampleToString();
        System.out.println("Класс с @ToString: " + exampleToString);

        // Задача 2.4: Аннотации @Validate
        System.out.println("\nЗадача 2.4: Аннотации @Validate");
        ExampleValidate exampleValidate = new ExampleValidate();
        System.out.println("Класс с @Validate: " + exampleValidate.validatedField);

        // Задача 2.5 Аннотации @Two
        System.out.println("\nЗадача 2.5: Аннотации @Two");
        ExampleTwo exampleTwo = new ExampleTwo();
        Two twoAnnotation = exampleTwo.getClass().getAnnotation(Two.class);
        System.out.println("Класс с @Two: первый = "  + twoAnnotation.first() + ", второй = " + twoAnnotation.second());

        // Задача 2.6: Аннотации @Cache
        System.out.println("\nЗадача 2.6: Аннотации @Cache");
        ExampleCache exampleCache = new ExampleCache();
        Cache cacheAnnotation = exampleCache.getClass().getAnnotation(Cache.class);
        System.out.println("Класс с @Cache: " + String.join(", ", cacheAnnotation.value()));

        // Задача 3.1 К строке
        System.out.println("\nЗадача 3.1 К строке");
        C c = new C(); // Пример 1: класс A
        System.out.println(c); // Ожидаемый вывод: A{s=hello}
        D d = new D();         // Пример 2: класс B
        System.out.println(d); // Ожидаемый вывод: B{includeField=included, defaultField=default}

        // Задача 4.1: Тестирование
        System.out.println("\nЗадача 4.1: Тестирование");
    }
}
