package de.telran.lesson20230901.superherofight;

import java.util.Random;

public class Weapon {

    private String name;
    private int force;

    public Weapon(String name, int force) {
        this.name = name;
        this.force = force;
    }

    public static Weapon generateRandomWeapon(){
        String[] names = {"Sword", "Knife", "Gun", "Stick", "Baseball bat"};
        int[] forces = {20, 10, 50, 2, 5};
        int number = names.length;
        Random random = new Random();
        int randomInd = random.nextInt(number);
        Weapon weapon = new Weapon(names[randomInd], forces[randomInd]);
        return weapon;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    @Override
    public String toString() {
        return "Weapon{" + "name='" + name + '\'' + ", force=" + force + '}';
    }
}
