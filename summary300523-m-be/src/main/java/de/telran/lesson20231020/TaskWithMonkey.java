package de.telran.lesson20231020;

import de.telran.lesson20230929.Monkey;

import java.util.*;
import java.util.stream.Collectors;

public class TaskWithMonkey {

    public static void main(String[] args) {
        Monkey monkey1 = new Monkey("A", 3, "grey", false, 10.9);
        Monkey monkey2 = new Monkey("A", 2, "white", true, 10.9);
        Monkey monkey3 = new Monkey("T", 3, "grey", false, 50);
        Monkey monkey4 = new Monkey("J", 2, "black", true, 10.9);
        Monkey monkey5 = new Monkey("Y", 1, "grey", true, 6);

        List<Monkey> monkeys = new ArrayList<>();
        monkeys.add(monkey1);
        monkeys.add(monkey2);
        monkeys.add(monkey3);
        monkeys.add(monkey4);
        monkeys.add(monkey5);

//        monkeys.forEach(System.out::println);

        // Получить Map имя / информация, голодна ли обезьянка
        Map<String, Boolean> nameAndIsHungry = monkeys.stream().collect(Collectors.toMap(Monkey::getName, Monkey::isHungry, (x, y) -> x));

        //Получить Map цвет / количество обезьян данного цвета
        Map<String, Long> groupByColour = monkeys.stream().collect(Collectors.groupingBy(Monkey::getColour, Collectors.counting()));

        //Получить Map цвет / список имен обезьян данного цвета
        Map<String, List<String>> groupByColourToList = monkeys.stream().collect(
                Collectors.groupingBy(Monkey::getColour, Collectors.mapping(Monkey::getName, Collectors.toList()))
        );
        System.out.println(groupByColourToList);

        //Создать компаратор и отсортировать исходный список по весу и имени
//        monkeys.stream().sorted((o1, o2) ->  o1.getWeight() == o2.getWeight() ? 0 : (o1.getWeight() < o2.getWeight() ? -1 : 1));
//        monkeys.stream().sorted((o1, o2) ->  Double.compare(o1.getWeight(), o2.getWeight()));
        List<Monkey> sorted = monkeys.stream().sorted(Comparator.comparingDouble(Monkey::getWeight).thenComparing(Monkey::getName)).toList();
        sorted.forEach(System.out::println);


        List<String> words = Arrays.asList("Hello", "World", "!!!!!");

        String concatString = words.stream().collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
//        String concatString = words.stream().collect(StringBuilder::new, (stringBuilder, s) -> stringBuilder.replace(0, 5, s), (stringBuilder, stringBuilder2) -> {}).toString();
        System.out.println(concatString);

        List<Integer> data = Arrays.asList(1, 4, 5, 12, 32);
        ArrayList<Integer> data2 = data.stream().collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
//        ArrayList<Integer> data2 = data.stream().collect(ArrayList::new, ArrayList::add, (array1, array2) -> System.out.println("Combiner in action"));
        System.out.println(data2);


    }


}
