package de.telran.lesson20230901.superherofight;

public class Battle {


    public static void main(String[] args) {
        Superhero superhero = new Superhero("Cool guy", new Weapon("Gun", 20), 20, new Protection("T-shirt", 1));
        Superhero hero1 = Superhero.generateRandomSuperHero();
        Superhero hero2 = Superhero.generateRandomSuperHero();

        System.out.println("Welcome to battle!");
        superhero.sayHello();
        hero1.sayHello();
        hero2.sayHello();
        System.out.println("Detailed info: " + superhero);
        System.out.println("Detailed info: " + hero1);
        System.out.println("Detailed info: " + hero2);

        System.out.println("______Fight 1______");
        fight(hero1, hero2);
        System.out.println("Fight result:");
        System.out.println(hero1.getName() + " got " + hero1.getHealth() + " health");
        System.out.println(hero2.getName() + " got " + hero2.getHealth() + " health");

        System.out.println("______Fight 2______");
        fight(superhero, hero1);
        System.out.println("Fight result:");
        System.out.println(superhero.getName() + " got " + superhero.getHealth() + " health");
        System.out.println(hero1.getName() + " got " + hero1.getHealth() + " health");
    }

    public static void fight(Superhero hero1, Superhero hero2) {
        System.out.println(hero1.getName() + " fights with " + hero2.getName());
        int hero1Force = hero1.getForce() + hero1.getWeapon().getForce();
        int hero2Force = hero2.getForce() + hero2.getWeapon().getForce();
        int forceDifference = hero1Force - hero2Force;
        if (forceDifference > 0) {
            System.out.println(hero1.getName() + " wins!");
            hero2.setHealth(hero2.getHealth() - (forceDifference / hero2.getProtection().getLevel()));
        } else if (forceDifference < 0) {
            System.out.println(hero2.getName() + " wins!");
            hero1.setHealth(hero1.getHealth() + (forceDifference / hero1.getProtection().getLevel()));
        } else {
            System.out.println("No one won. Powers were equal");
        }
    }

}
