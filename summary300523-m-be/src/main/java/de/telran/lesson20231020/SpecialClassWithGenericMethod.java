package de.telran.lesson20231020;

public class SpecialClassWithGenericMethod {

    public <M, E> M processM(M m, E e){
        M innerM;
        E innerE;
        System.out.println("processM invoked: " + m);
        return m;
    }



}
