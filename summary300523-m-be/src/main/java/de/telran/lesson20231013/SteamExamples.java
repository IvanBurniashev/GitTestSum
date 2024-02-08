package de.telran.lesson20231013;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SteamExamples {

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("A", "B", "SS", "VV");

        for (String s : stringList) {
            // do something with "s"
            System.out.println(s);
        }

//        Stream<String> stringStream = stringList.stream();
//        stringStream.forEach(System.out::println);

//        stringList.stream().forEach(System.out::println);
        stringList.forEach(System.out::println);

        System.out.println("Starting to work with stream");
        Stream<String> stream1 = stringList.stream(); // generation
        Stream<String> stream2 = stream1.filter(s -> s.length() == 2); // intermediate
        Stream<String> stream3 = stream2.map(s -> "Word: " + s); // intermediate
        Stream<String> stream4 = stream3.peek(s -> System.out.println("Intermediate operations with " + s)); // intermediate

        // some other operations
        System.out.println("Some other operations");

//        stream1.forEach(System.out::println);

        List<String> finalList = stream4.toList(); // terminal
        finalList.stream().forEach(System.out::println);

//        List<String> list = stream4.toList();


        List<Integer> integers = Arrays.asList(1, 4, 55, 87);
        List<String> result = integers.stream().filter(integer -> integer % 2 == 1)
                .peek(System.out::println)
                .peek(System.err::println)
                .map(integer -> "Filtered " + integer)
                .toList(); // terminal

        List<List<String>> schoolGroups = new ArrayList<>();
        List<String> group1 = Arrays.asList("Ivan", "Peter", "James");
        List<String> group2 = Arrays.asList("Jane", "Mary");
        List<String> group3 = Arrays.asList("Tom", "Mark");
        schoolGroups.add(group1);
        schoolGroups.add(group2);
        schoolGroups.add(group3);

        List<String> schoolStudents = schoolGroups.stream().flatMap(group -> group.stream()).toList();
        schoolStudents.forEach(System.out::println);

        List<String> words = Arrays.asList("Lorem", "Ipsum", "hello", "world", "!!!");
        words.stream().flatMap(s -> s.chars().boxed())
                .map(Character::toString)
                .distinct()
                .forEach(System.out::println);

    }

}
