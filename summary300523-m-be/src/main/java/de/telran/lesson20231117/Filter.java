package de.telran.lesson20231117;

@FunctionalInterface
public interface Filter<T> {

    boolean apply(T t);

}
