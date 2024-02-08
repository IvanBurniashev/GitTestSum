package de.telran.lesson20231110;

public class ParentStream<T, S extends ParentStream<T, S>> {

    public S sequential(){
        return null;
    }

    public S parallel(){
        return null;

    }

}
