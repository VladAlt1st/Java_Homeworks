package Homework2023_03_22;

// TODO: Сделать по аналогии с примером с аннотацией  @MyName (см. код в репозитории):
//Имеется класс Student с полями name, surname, age. Создать аннотацию @StudentInfo и соответствующий инжектор через рефлексию,
//чтобы с их помощью иметь возможность инициализировать переменные типа Student. Например:
//public class School {
//@StudentInfo(name = "Tom", surname = "Smith", age = 15)
//private Student student1;
//@StudentInfo(name = "Mary", surname = "Jennings", age = 17)
//private Student student2;
//}

import java.lang.reflect.Field;

public class School {

    @StudentInfo(name = "Tom", surname = "Smith", age = 15)
    private Student student1;

    @StudentInfo(name = "Mary", surname = "Jennings", age = 17)
    private Student student2;

    public static void main(String[] args) {
        School school = new School();

        System.out.println(school.student1);
        System.out.println(school.student2);

        Injector.inject(school);

        System.out.println(school.student1);
        System.out.println(school.student2);
    }

    static class Injector {
        public static void inject(Object instance) {
            Field[] fields = instance.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(StudentInfo.class)) {
                    StudentInfo annotation = field.getAnnotation(StudentInfo.class);
                    field.setAccessible(true);
                    try {
                        field.set(instance, new Student(annotation.name(), annotation.surname(), annotation.age()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
