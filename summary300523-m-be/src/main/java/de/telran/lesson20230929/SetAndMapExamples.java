package de.telran.lesson20230929;

import de.telran.lesson20230908.Dog;

import java.util.*;

public class SetAndMapExamples {

    public static void main(String[] args) {
        Set<String> names = new HashSet<>();

        names.add("Tom");
        names.add("Mary");
        names.add("James");
        names.add("Ivan");
        names.add("Mary");

        Iterator<String> iterator = names.iterator();

        System.out.println(names);

        Dog dog1 = new Dog("Tommy", 12, "grey");
        Dog dog2 = new Dog("Mikky", 12, "grey");
        Set<Dog> dogs = new HashSet<>();
        dogs.add(dog1);
        dogs.add(dog2);

        System.out.println(dogs);

        Map<String, Integer> map = new HashMap<>();
//        map = new TreeMap<>();
//        map = new ArrayList<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Two", 40);
        map.put("Three", 3);
        System.out.println(map.get("Two"));

//        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }

        Comparator<String> reversed = Comparator.reverseOrder();
        Set<String> animals = new TreeSet<>(reversed);
        animals.add("monkey");
        animals.add("cat");
        animals.add("dove");
        animals.add("elephant");
        animals.add("sparrow");

        for (String a : animals) {
            System.out.println(a);
        }




    }




}
