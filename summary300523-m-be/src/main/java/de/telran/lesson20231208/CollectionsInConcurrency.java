package de.telran.lesson20231208;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsInConcurrency {


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> synchronizedList = Collections.synchronizedList(list);
        synchronizedList.add("One");
        synchronizedList.add("Two");
        synchronizedList.add("Three");

        // see more info here: https://java-online.ru/concurrent-collections.xhtml
    }
}
