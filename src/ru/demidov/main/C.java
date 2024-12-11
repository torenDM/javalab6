package ru.demidov.main;

import ru.demidov.task3.Entity2;
import ru.demidov.task3.ToString2;
import static ru.demidov.task3.ToString2.Value.*;

class C extends Entity2 {
    String s = "hello";

    @ToString2(NO)
    int x = 42;
}
