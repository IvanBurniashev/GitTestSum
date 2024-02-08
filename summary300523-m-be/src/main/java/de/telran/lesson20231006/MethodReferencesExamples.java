package de.telran.lesson20231006;

import java.util.function.Consumer;

public class MethodReferencesExamples {

    public static void main(String[] args) {

//        Consumer<String> doSomethingConsumer = (s) -> doSomething(s);
        Consumer<String> doSomethingConsumer = MethodReferencesExamples::doSomething;

        MethodReferencesExamples examples = new MethodReferencesExamples();

        Consumer<String> consumer = examples::doSomethingNonstatic;
        Consumer<String> consumer2 = consumer.andThen(System.out::println);

        Consumer<String> consumerFinal =
                ((Consumer<String>) examples::doSomethingNonstatic)
                        .andThen(System.err::println)
                        .andThen(System.out::println);


        consumer.accept("Test 1");
        System.out.println("----------");
        consumer2.accept("Test 2");
        System.out.println("----------");
        consumerFinal.accept("Test 3");
    }


    public static void doSomething(String s){
        System.out.println("doing something with " + s);
    }

    public void doSomethingNonstatic(String s){
        System.out.println("doing something nonstatic with " + s);
    }

    public void someMethod(String s){
        Consumer<String> consumer = this::doSomethingNonstatic;
    }



}
