package de.telran.lesson20230915;

import de.telran.lesson20230908.Human;

public class TestEquals {

    public static void main(String[] args) {

        Human human3 = null;
//        human3.play(); // impossible
        someMethod(human3);

        Human human1 = new Human("Tom");
        Human human2 = new Human("Tom");
        human3 = human1;

        System.out.println(human1.equals(human2));
        System.out.println(human1 == human2);

        System.out.println(human1.hashCode());
        System.out.println(human2.hashCode());
        System.out.println(human3.hashCode());

        String s1 = "Some string";
        String s2 = "Some string";
        String s3 = s1;
        String s4 = new String("Some string");

        System.out.println(s1 == s2); // true
        System.out.println(s1 == s3); // true
        System.out.println(s1 == s4); // false

        System.out.println(s1.equals(s2)); // true
        System.out.println(s1.equals(s3)); // true
        System.out.println(s1.equals(s4)); // true
    }

    public static void someMethod(Human human) {
        if (human != null) {
            human.play();
        } else {
            human = new Human("Default object");
            human.play();
        }
    }


}
