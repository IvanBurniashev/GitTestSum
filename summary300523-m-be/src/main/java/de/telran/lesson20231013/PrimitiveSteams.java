package de.telran.lesson20231013;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimitiveSteams {

    public static void main(String[] args) {
        Stream<Integer> integerStream = Arrays.asList(1, 2, 3).stream();

        IntStream primitiveInt = IntStream.rangeClosed(1, 100)
                .filter(value -> value % 3 == 0);
        int[] primitiveIntArray = primitiveInt.toArray();
//        int sum = primitiveInt.sum();
//        System.out.println(sum);

        Stream<Integer> boxedInts = IntStream.rangeClosed(1, 10).boxed();
        IntStream intStream = boxedInts.mapToInt(value -> value);

        Stream<String> stringStream = IntStream.rangeClosed(1, 10).mapToObj(value -> Integer.toString(value));

        int[] array = IntStream.rangeClosed(1, 1_000_000_000)
                .filter(value -> value % 5 == 0)
                .peek(System.out::println)
//                .findFirst()
//                .findAny()
                .skip(10)
                .limit(10)
                .toArray();
//                .sum();
        System.out.println(Arrays.toString(array));

    }



}
