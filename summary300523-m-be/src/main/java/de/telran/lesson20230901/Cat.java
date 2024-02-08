package de.telran.lesson20230901;

import de.telran.lesson20230908.Animal;
import de.telran.lesson20230908.Playable;

public class Cat extends Animal {

//    private Kitten kitten = new Kitten();

    private static int catCount = 0;

    public static void printCatCount(){
        // age++; impossible
        System.out.println("Total cat count: " + catCount);
    }

    public Cat(String catName, int catAge){
        super(catName, catAge);
        catCount++;
    }

    public Kitten createKitten(){
        Kitten kitten = new Kitten();
        kitten.kittenName = "New name";
        return kitten;
    }

    @Override
    public void sayHello() {
        System.out.println("Meow!");
    }

    @Override
    public void play(Playable playable) {
        System.out.println("Cat plays with " + playable);
    }

    public class Kitten extends Animal {
        private String kittenName;

        public String getParentName(){
            return super.getName();
        }

        @Override
        public void sayHello() {
            System.out.println("Meow!");
        }

        @Override
        public void play(Playable playable) {
            System.out.println("Kitten plays with " + playable);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}


