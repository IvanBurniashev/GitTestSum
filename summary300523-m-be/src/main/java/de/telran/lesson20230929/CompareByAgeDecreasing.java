package de.telran.lesson20230929;

import java.util.Comparator;

public class CompareByAgeDecreasing implements Comparator<Monkey> {
    @Override
    public int compare(Monkey o1, Monkey o2) {
        return o2.getAge() - o1.getAge();
    }
}
