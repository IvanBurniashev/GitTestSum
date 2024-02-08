package de.telran.lesson20230922;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorExamples {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("Tom");
        names.add("Jenny");
        names.add("Mary");
        names.add("Jack");

        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()){
            String current = iterator.next();
            System.out.println(current);
            if (current.equals("Mary")) iterator.remove();
        }

        System.out.println("After remove operation:");
        iterator = names.iterator();
        while (iterator.hasNext()){
            String current = iterator.next();
            System.out.println(current);
        }

        for (String s : names) {
            System.out.println(s);
        }

        List<Integer> integers = new ArrayList<>();
        integers.add(100);
        integers.add(200);
        integers.add(300);
        integers.add(400);
        integers.add(500);
        integers.add(300);
        integers.add(300);

        ListIterator<Integer> listIterator = integers.listIterator();
        while (listIterator.hasNext()){
            Integer next = listIterator.next();
            if (next == 300) {
                listIterator.previous();
                listIterator.previous();
                listIterator.set(3000);
                listIterator.next();
                listIterator.next();
//                break;
            }
        }

        for (Integer i : integers) {
            System.out.println(i);
        }




    }



}
