package ru.demidov.task1;

import java.lang.reflect.Field;

public abstract class Entity {
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(this.getClass().getSimpleName() + "{");
        Field[] fields = this.getClass().getDeclaredFields();

        try {
            boolean first = true;
            for (Field field : fields) {
                field.setAccessible(true);
                if (!first) {
                    result.append(", ");
                }
                result.append(field.getName()).append("=").append(field.get(this));
                first = false;
            }

            // Добавляем поля родительских классов
            Class<?> superclass = this.getClass().getSuperclass();
            while (superclass != null && superclass != Object.class) {
                Field[] parentFields = superclass.getDeclaredFields();
                for (Field field : parentFields) {
                    field.setAccessible(true);
                    result.append(", ").append(field.getName()).append("=").append(field.get(this));
                }
                superclass = superclass.getSuperclass();
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        result.append("}");
        return result.toString();
    }
}
