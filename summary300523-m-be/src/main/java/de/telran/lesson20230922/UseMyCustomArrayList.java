package de.telran.lesson20230922;

import java.util.Iterator;

public class UseMyCustomArrayList {

    public static void main(String[] args) {

        MyCustomArrayList list = new MyCustomArrayList(new String[] {"One", "Two", "Three"});

        for (String data : list) {
            System.out.println(data);
        }

        Iterator<String> iterator = list.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
    }


}
