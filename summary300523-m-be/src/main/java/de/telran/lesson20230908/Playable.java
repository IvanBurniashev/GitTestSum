package de.telran.lesson20230908;

public interface Playable {

    int number = 10; // public static final

    void play();

    void play(Playable playable);


    static void staticMethod() {
//        this.play();
        System.out.println("Static method " + number);
    }

    default void defaultMethod() {
        System.out.println("Default method");
        this.play();
    }

}
