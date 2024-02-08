package de.telran.lesson20230901.superherofight;

import java.util.Random;

public class Superhero {

    private String name;
    private Weapon weapon;
    private int force;
    private int health = 100;
    private Protection protection;

    public Superhero(String name, Weapon weapon, int force, Protection protection) {
        this.name = name;
        this.weapon = weapon;
        this.force = force;
        this.protection = protection;
    }

    public void sayHello(){
        System.out.println("Hello, I'm " + name);
    }

    // fabric method
    public static Superhero generateRandomSuperHero(){
        String name = generateRandomName();
        Weapon weapon = Weapon.generateRandomWeapon();
        int force = generateRandomForce();
        Protection protection = Protection.generateRandomProtection();
        return new Superhero(name, weapon, force, protection);
    }

    private static String generateRandomName(){
        String[] names = {"Batman", "Superman", "Spiderman", "Joker"};
        Random random = new Random();
        String randomName = names[random.nextInt(names.length)];
        return randomName;
    }

    private static int generateRandomForce() {
        Random random = new Random();
        return random.nextInt(50);
    }

    @Override
    public String toString() {
        return "Superhero{" + "name='" + name + '\'' + ", weapon=" + weapon + ", force=" + force + ", health=" + health + ", protection=" + protection + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Protection getProtection() {
        return protection;
    }

    public void setProtection(Protection protection) {
        this.protection = protection;
    }
}
