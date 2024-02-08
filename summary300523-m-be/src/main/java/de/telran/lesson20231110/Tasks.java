package de.telran.lesson20231110;

import java.util.Arrays;
import java.util.List;

public class Tasks {

    public static void main(String[] args) {
        // Task 1.a  - Написать Generic метод <T> List<T> makeList(T[] t), который преобразует массив в список
        List<Integer> ints = makeList(new Integer[] {1, 2, 3});
        List<String> strings = makeList(new String[] {"A", "B", "C"});

        // Task 1.b - Написать Generic метод <T> T[] makeArray(List<T> list), который преобразует список в массив
        Object[] intsArray = makeArray(Arrays.asList(1, 2, 3));
        Object[] stringsArray = makeArray(Arrays.asList("A", "B", "C"));
    }

    public static <T> List<T> makeList(T[] t) {
//        List<T> list = new ArrayList<>();
        return Arrays.asList(t);
    }

//    public static <T> T[] makeArray(List<T> list) {
    public static <T> Object[] makeArray(List<T> list) {
//        T[] ts = new T[list.size()]; // impossible
        Object[] objects = new Object[list.size()];
        for (int i = 0; i < objects.length; i++) {
            objects[i] = list.get(i);
        }
        return objects;
//        return (T []) objects;
//        return list.toArray();
    }

}
