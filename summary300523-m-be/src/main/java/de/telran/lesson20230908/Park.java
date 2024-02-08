package de.telran.lesson20230908;

import de.telran.lesson20230901.Cat;

public class Park {


    public static void main(String[] args) {
        Animal animal = new Cat( "Tom", 1);
        animal.feed();
        animal = new Dog("Mikky", 2, "grey");
        animal.feed();
        animal.sayHello();

//        ((Dog) animal).bark(); // possible, but not save
        Dog mikky = new Dog("Mikky", 2, "grey");
        mikky.bark();

        Human human = new Human("Harry");
        Cat cat = new Cat("MyCat", 2);
        Dog dog = new Dog("MyDog", 2, "grey");
        Robot robot = new Robot();

//        human.play();
//        cat.play();
//        dog.play();
        human.play(cat);

//        Playable[] arrayOfGamers = {human, cat, dog};
//        allPlay(arrayOfGamers);
        allPlayWithVarArg(human, cat, dog, robot);



        Playable.staticMethod();
//        human.method();
//        Playable.defaultMethod();
        human.defaultMethod();
    }

    public static void allPlay(Playable[] playables) {
        for (Playable p : playables) {
            p.play();
        }

    }

    public static void allPlayWithVarArg(Playable... playables) {
        for (Playable p : playables) {
            p.play();
        }

    }

}
