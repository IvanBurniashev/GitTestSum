package de.telran.lesson20231013;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PythagoreanTriple {

    public static void main(String[] args) {

        Stream<int[]> stream = IntStream.rangeClosed(1, 1000).boxed()
                .flatMap(
                        a -> IntStream.rangeClosed(a, 1000)
                                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                                .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                );

        stream.limit(10).forEach(ints -> System.out.println(Arrays.toString(ints)));

        // a^2 + b^2 = c^2    c = sqrt(a^2 + b^2)
        // [3, 4, 5]

    }


}
