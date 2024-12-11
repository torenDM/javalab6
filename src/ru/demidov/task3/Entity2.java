package ru.demidov.task3;

import java.lang.reflect.Field;

public abstract class Entity2 {
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(this.getClass().getSimpleName() + "{");
        boolean hasFields = false;

        // Проверка аннотации @ToString на уровне класса
        ToString2 classAnnotation = this.getClass().getAnnotation(ToString2.class);
        boolean skipAllFields = classAnnotation != null && classAnnotation.value() == ToString2.Value.NO;

        try {
            Field[] fields = this.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);

                // Проверяем аннотацию @ToString на поле
                ToString2 fieldAnnotation = field.getAnnotation(ToString2.class);

                if (skipAllFields) {
                    // Включаем только поля с @ToString(YES), если класс помечен @ToString(NO)
                    if (fieldAnnotation != null && fieldAnnotation.value() == ToString2.Value.YES) {
                        if (hasFields) result.append(", ");
                        result.append(field.getName()).append("=").append(field.get(this));
                        hasFields = true;
                    }
                } else {
                    // Исключаем поля с @ToString(NO), остальные включаем
                    if (fieldAnnotation == null || fieldAnnotation.value() == ToString2.Value.YES) {
                        if (hasFields) result.append(", ");
                        result.append(field.getName()).append("=").append(field.get(this));
                        hasFields = true;
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        result.append("}");
        return result.toString();
    }
}