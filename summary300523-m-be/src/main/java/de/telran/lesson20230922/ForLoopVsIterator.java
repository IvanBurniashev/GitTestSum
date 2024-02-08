package de.telran.lesson20230922;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ForLoopVsIterator {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("One");
        list1.add("Two");
        list1.add("Three");

        // O(N)
        for (int i = 0; i < list1.size(); i++) {
            list1.get(i);
        }

        List<String> list2 = new LinkedList<>();
//        list2.add("One");
//        list2.add("Two");
//        list2.add("Three");
        for (int i = 0; i < 10000; i++) {
            list2.add(String.valueOf(i));
        }

        // O(N^2)
        long start = System.nanoTime();
        for (int i = 0; i < list2.size(); i++) {
            list2.get(i);
        }
        long end = System.nanoTime();
        System.out.println("Time: " + (end - start));

        // O(N)
        start = System.nanoTime();
        for (String s : list2) {
//            System.out.println(s);
        }
        end = System.nanoTime();
        System.out.println("Time: " + (end - start));

    }


}
