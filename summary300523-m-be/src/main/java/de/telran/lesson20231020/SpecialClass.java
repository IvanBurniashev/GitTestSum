package de.telran.lesson20231020;

public class SpecialClass<T> {

    private Integer data;
    private T dataParametrized;


    public SpecialClass(T dataParametrized) {
        this.dataParametrized = dataParametrized;
    }

    public void usualMethod(){
        System.out.println("usualMethod with " + data);
    }

    public T getDataParametrized(){
        return dataParametrized;
    }

    public void setDataParametrized(T dataParametrized){
        this.dataParametrized = dataParametrized;
    }

    public void processData(){
        if (dataParametrized instanceof String) {
            System.out.println("Processing string data: " + dataParametrized);
        } else if (dataParametrized instanceof Number) {
            Number number = (Number) dataParametrized;
            int newValue = number.intValue() + 100;
            System.out.println("Processing numeric data: " + newValue);
        }
    }

}
