package de.telran.lesson20230922;

import java.util.LinkedList;

public class MyStack {

    private LinkedList<String> list = new LinkedList<>();

    public void push(String data) {
        list.addFirst(data);
    }

    public String pop(){
        return list.removeFirst();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push("A");
        myStack.push("B");
        myStack.push("C");

        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());

    }



}
