package de.telran.lesson20231117;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
//@Repeatable(MyNames.class)
public @interface MyName {

    String value();

    int age() default 18;

}
