package de.telran.lesson20231110;

import java.util.function.Predicate;

public class MyStream<T> extends ParentStream<T, MyStream<T>> {

    public MyStream<T> filter(Predicate<? super T> predicate){
        return null;
    }

}
