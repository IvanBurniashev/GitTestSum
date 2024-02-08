package de.telran.lesson20231117;

import java.lang.reflect.Field;

//@Service
//@AllArgsConstructor
public class Persons {

    @MyName(value = "Peter", age = 35)
    public String person1;

    @MyName(value = "Jane")
    public String person2;

    @MyName("Mark")
    public String person3;

    public static void main(String[] args) {

        Persons persons = new Persons();
        System.out.println(persons.person1);
        System.out.println(persons.person2);
        System.out.println(persons.person3);

        Injector.inject(persons);

        System.out.println(persons.person1);
        System.out.println(persons.person2);
        System.out.println(persons.person3);

        try {
            MyName annotation = persons.getClass().getField("person1").getAnnotation(MyName.class);
            System.out.println(annotation.value());
            System.out.println(annotation.age());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


    }

    static class Injector {
        public static void inject(Object instance) {
            Field[] fields = instance.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(MyName.class)) {
                    MyName annotation = field.getAnnotation(MyName.class);
                    field.setAccessible(true); // should work on private fields
                    try {
                        field.set(instance, annotation.value());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }



}
