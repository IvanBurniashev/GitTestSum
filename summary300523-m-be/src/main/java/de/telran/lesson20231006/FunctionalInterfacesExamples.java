package de.telran.lesson20231006;

import java.util.Random;
import java.util.function.*;

public class FunctionalInterfacesExamples {


    public static void main(String[] args) {

        // void -> data --- Supplier --- get()
        Supplier<Integer> randomGenerator = () -> {
            Random random = new Random();
            return random.nextInt();
        };

        Supplier<Integer> positiveIntsGenerator = () -> {
            Random random = new Random();
            return random.nextInt(0, 100);
        };

        System.out.println(randomGenerator.get());
        System.out.println(randomGenerator.get());
        System.out.println(randomGenerator.get());
        System.out.println(positiveIntsGenerator.get());
        System.out.println(positiveIntsGenerator.get());
        System.out.println(positiveIntsGenerator.get());

        // data -> void --- Consumer --- accept()
//        Consumer<String> printData = (s) -> System.out.println(s);
        Consumer<String> printData = System.out::println;
        printData.accept("Data 1");
        printData.accept("Data 2");

        // data1 -> data2 --- Function  / UnaryOperator (one type of input-output) --- apply()
        Function<Double, Double> multiplyTo100 = (x) -> x * 100; // UnaryOperator
        multiplyTo100.apply(10.0);

        // (data1, data2) -> data3 --- BiFunction / BinaryOperator (one type of input-output) --- apply()
        BiFunction<Double, Double, Double> multiply = (x, y) -> x * y; // BinaryOperator
        multiply.apply(10.0, 99.0);

        BiFunction<Integer, Integer, Integer> integerBiFunction = (x, y) -> (int) Math.pow((double) x, (double) y);
        BinaryOperator<Integer> integerBinaryOperator = (x, y) -> (int) Math.pow((double) x, (double) y);

        System.out.println(integerBiFunction.apply(2, 10));

        // data -> boolean --- Predicate --- test()
        Predicate<String> isLongEnough = (s) -> s.length() > 5;
        System.out.println(isLongEnough.test("Hello!"));
        System.out.println(isLongEnough.test("Hi!"));


        // Composite function example
        Function<String, String> processString = (s) -> s.substring(6, 11);
//        Function<String, String> beforeFunction = (v) -> v.toUpperCase();
        Function<String, String> beforeFunction = String::toUpperCase;
        Function<String, String> afterFunction = (p) -> "-------" + p + "-------";
        Function<String, String> finalFunction = processString.compose(beforeFunction).andThen(afterFunction);

        String result = finalFunction.apply("Hello world!!!");
        System.out.println(result);

        Function<String, String> oneFunction = (p) -> {
            String string = p.toUpperCase().substring(6, 11);
            string = "-------" + string + "-------";
            return string;
        };
        System.out.println(oneFunction.apply("Hello world!!!"));
    }


}
