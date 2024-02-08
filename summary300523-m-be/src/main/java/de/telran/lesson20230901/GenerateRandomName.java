package de.telran.lesson20230901;

import java.util.Random;

public class GenerateRandomName {


    public static void main(String[] args) {
        String[] names = {"Batman", "Superman", "Spiderman", "Joker"};
        Random random = new Random();
        String randomName = names[random.nextInt(names.length)];
        System.out.println(randomName);
    }



}
