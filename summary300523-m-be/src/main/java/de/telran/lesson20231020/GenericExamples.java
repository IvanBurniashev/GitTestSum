package de.telran.lesson20231020;

import de.telran.lesson20230929.Monkey;

import java.util.ArrayList;
import java.util.List;

public class GenericExamples {

    public static void main(String[] args) {

//        List<String> list = new ArrayList<String>();
        List list2 = new ArrayList();
        list2.add(new Object());
        List<String> list = new ArrayList<>();
//        list.add(10);

//        SpecialClass stringClass = new SpecialClass<>("Hello world"); // bad practise

        SpecialClass<String> stringClass = new SpecialClass<>("Hello world");

//        new SpecialClass<String>("Hello world").usualMethod(); // anonymous generic class

        stringClass.processData();

        SpecialClass<Integer> integerClass = new SpecialClass<>(1000);
        integerClass.processData();
        SpecialClass<Double> doubleClass = new SpecialClass<>(10.0);
        doubleClass.processData();

        SpecialClassWithGenericMethod specialClass = new SpecialClassWithGenericMethod();
        Integer intData = specialClass.processM(10, "Hello");
        Monkey monkey = specialClass.processM(new Monkey("A", 10, "black", true, 10.0), 123);
    }


}
