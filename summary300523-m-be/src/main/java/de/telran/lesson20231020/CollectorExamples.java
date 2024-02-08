package de.telran.lesson20231020;

import de.telran.lesson20230929.Monkey;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorExamples {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Tom", "Mary", "Jane", "Edward", "Mary", "Tom");

//        List<String> list = names.stream().filter(s -> s.length() == 4).toList(); - unmodifiable list
//        List<String> list = names.stream().filter(s -> s.length() == 4).collect(Collectors.toList()); // - ArrayList
        List<String> list = names.stream().filter(s -> s.length() == 4).collect(Collectors.toCollection(LinkedList::new));
        System.out.println(list.getClass());
        list.add("Vasua");

        Set<String> namesSet = names.stream().collect(Collectors.toSet());
//        Set<String> namesSet = new HashSet<>(names);
        System.out.println(namesSet);


        Map<String, Integer> uniqueNamesCountMap = names.stream().collect(Collectors.toMap(name -> name, name -> 1, Integer::sum));
        System.out.println(uniqueNamesCountMap);

        Map<String, Boolean> namesStartWithT = names.stream().collect(Collectors.toMap(name -> name, name -> name.startsWith("T"), (x, y) -> x));
        System.out.println(namesStartWithT);

        // Map<Integer, Integer>  число букв / число имен с данным числом букв
        Map<Integer, Integer> lettersCount = names.stream().collect(Collectors.toMap(String::length, name -> 1, Integer::sum));
        Map<Integer, Long> lettersCount2 = names.stream().collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println(lettersCount);
        System.out.println(lettersCount2);

        // Map<Integer, List<String>>  число букв / список имен с данным числом букв
        Map<Integer, List<String>> groupByNameLength = names.stream().collect(Collectors.groupingBy(String::length, Collectors.toList()));
        System.out.println(groupByNameLength);

    }

}
