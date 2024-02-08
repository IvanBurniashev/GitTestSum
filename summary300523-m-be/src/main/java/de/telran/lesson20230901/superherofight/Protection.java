package de.telran.lesson20230901.superherofight;

import java.util.Random;

public class Protection {

    private String name;
    private int level;

    public Protection(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public static Protection generateRandomProtection() {
        String[] names = {"Helmet", "Leather jacket", "Armor", "T-shirt", "Shield"};
        int[] levels = {2, 2, 4, 1, 3};
        int number = names.length;
        Random random = new Random();
        int randomInd = random.nextInt(number);
        Protection protection = new Protection(names[randomInd], levels[randomInd]);
        return protection;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Protection{" + "name='" + name + '\'' + ", level=" + level + '}';
    }
}
