package de.telran.lesson20230901;

public class House {


    public static void main(String[] args) {
        Cat.printCatCount();

        Cat cat1 = new Cat( "Vasua", 3);
        Cat cat2 = new Cat( "Tom", 1);

        System.out.println(cat1.isHungry());
        cat1.feed();
        System.out.println(cat1.isHungry());
        System.out.println(cat2.isHungry());

        Cat cat3 = cat1;
        System.out.println(cat3.isHungry());

        Cat.printCatCount();

        System.out.println("cat1 age: " + cat1.getAge());

        Cat.Kitten kitten1 = cat1.new Kitten();
        Cat.Kitten kitten2 = cat1.createKitten();
        System.out.println("Kitten parent name: " + kitten1.getParentName());
        System.out.println("Kitten parent name: " + kitten2.getParentName());

    }



}
