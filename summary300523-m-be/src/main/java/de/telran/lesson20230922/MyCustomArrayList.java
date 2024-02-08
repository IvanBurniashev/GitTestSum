package de.telran.lesson20230922;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyCustomArrayList implements Iterable<String>{

    private String[] data;

    public MyCustomArrayList(String[] data) {
        this.data = data;
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {

            int current = data.length - 1;

            @Override
            public boolean hasNext() {
                return current >= 0;
            }

            @Override
            public String next() {
                if (!hasNext()){
                    throw new NoSuchElementException("Cannot invoke next()");
                }
                return data[current--];
            }
        };
    }
}
