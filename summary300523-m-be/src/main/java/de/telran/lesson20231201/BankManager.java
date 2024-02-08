package de.telran.lesson20231201;

import java.util.Stack;

public class BankManager {

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount();

//        Stack<String> stack1 = new Stack<>();
//        Stack<String> stack2 = new Stack<>();
//        stack1.push("A");
//        stack2.push("B");

        synchronized (account1) {
            account1.depositB(1000);
            account1.withdrawB(1000);
        }

        synchronized (account2) {
            account2.depositB(1000);
            account2.withdrawB(1000);
        }

        synchronized (BankAccount.class) {
            BankAccount.method();
            account1.method();
            account2.method();
            BankAccount.method2();
        }

    }


}
