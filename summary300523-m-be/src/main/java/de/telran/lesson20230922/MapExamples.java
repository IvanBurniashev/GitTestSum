package de.telran.lesson20230922;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapExamples {

    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();
//        Map<Integer, String> map2 = new TreeMap<>();
//        map = map2;

        map.put(9432, "Ivan Ivanov");
        map.put(3231, "Peter Petrov");
        map.put(3231, "New person");
        map.put(3211, "Mary Smiths");

        System.out.println(map.get(3231));

        Set<Integer> keys = map.keySet();
        for (Integer k : keys) {
            System.out.println(k);
        }

        System.out.println(map.values());

        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for (Map.Entry<Integer, String> e: entries) {
            System.out.println("key = " + e.getKey() + " value = " + e.getValue());
        }

    }



}
