package ru.demidov.main;

import ru.demidov.task3.ToString2;
import static ru.demidov.task3.ToString2.Value.*;

@ToString2(NO)
class D extends C {
    String s = "hello";

    @ToString2(YES)
    String text = "B";
}
