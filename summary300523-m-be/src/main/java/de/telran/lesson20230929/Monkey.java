package de.telran.lesson20230929;

public class Monkey implements Comparable<Monkey> {

    private String name;
    private int age;
    private String colour;
    private boolean isHungry;
    private double weight;

    public Monkey(String name, int age, String colour, boolean isHungry, double weight) {
        this.name = name;
        this.age = age;
        this.colour = colour;
        this.isHungry = isHungry;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public void setHungry(boolean hungry) {
        isHungry = hungry;
    }

    @Override
    public String toString() {
        return "Monkey{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", colour='" + colour + '\'' +
                ", isHungry=" + isHungry +
                ", weight=" + weight +
                '}';
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

//    @Override
//    public int compareTo(Monkey another) {
//        return this.name.compareTo(another.name);
//    }

    @Override
    public int compareTo(Monkey another) {
        int result = this.name.compareTo(another.name); // name
        if (result != 0) return result;

        result = this.age - another.age; // age
        if (result != 0) return result;

        result = this.colour.compareTo(another.colour); // colour
        if (result != 0) return result;

        result = (this.isHungry ? 1 : 0) - (another.isHungry ? 1 : 0); // isHungry
        return result;
    }
}
