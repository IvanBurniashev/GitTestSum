package de.telran.lesson20231013;

import de.telran.lesson20230929.Monkey;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {

        String string = getString();
        string = (string != null) ? string : "Default value";
//        if (string != null) {
//            string = string;
//        } else {
//            string = "Default value";
//        }

        System.out.println(string.toUpperCase());

        String result = getOptionalString().orElse("Default value");
        System.out.println(result.toUpperCase());

        Optional<Integer> integerOptional = Optional.ofNullable(10);
//        Optional<Monkey> monkeyOptional = Optional.ofNullable(null);
        Optional<Monkey> monkeyOptional = Optional.empty();

        Optional<String> optional = Arrays.asList("One", "Two", "Three")
                .stream().filter(s -> s.length() == 10)
                .findAny();
        System.out.println(optional.orElse("No results found"));

        List<String> list = Arrays.asList("One", "Two", "Three").stream().filter(s -> s.length() == 10).toList();
        System.out.println(list.size());
    }

    public static String getString() {
//        return "String from method";
        return null;
    }

    public static Optional<String> getOptionalString() {
//        return Optional.of("String from method");
        return Optional.empty();
    }

}
