package de.telran.lesson20231124;

public class ThreadExamples {

    public static void main(String[] args) {

        // Последовательные действия в осоновном потоке
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread());

        int i = 0;

        System.out.println("!!!");

        i++;

        System.out.println(i);
    }



}
