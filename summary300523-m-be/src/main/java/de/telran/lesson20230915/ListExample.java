package de.telran.lesson20230915;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListExample {

    public static void main(String[] args) {

        List objectList = new ArrayList();
        objectList.add(1);
        objectList.add("ABC");
        objectList.add(2.0);

        Integer data = (Integer) objectList.get(0);
//        Integer data2 = (Integer) objectList.get(1); // impossible

        System.out.println(data);
        System.out.println(objectList.get(1));
        System.out.println(objectList.get(2));


        List<Double> numbers = new ArrayList<>();
        numbers.add(20.0);

        List<String> names = new ArrayList<String>();
//        names = new LinkedList<>();
        names.add("Mary");
        names.add("Jane");
        names.add("John");

        System.out.println(names.get(0));
        System.out.println(names.get(1));
        System.out.println(names.get(2));

        System.out.println(names.contains("Mary"));
        System.out.println(names.indexOf("Jane"));


        String[] namesArray = {"Mary", "Jane", "John"};
        for (int i = 0; i < namesArray.length; i++) {
            System.out.println(namesArray[i]);
        }

//        for (String s : names) {
//            System.out.println(s);
//        }

        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()){
            String name = iterator.next();
            System.out.println(name);
        }

    }



}
