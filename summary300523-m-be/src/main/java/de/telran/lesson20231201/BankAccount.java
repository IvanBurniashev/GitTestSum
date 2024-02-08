package de.telran.lesson20231201;

import java.math.BigDecimal;

public class BankAccount {

    private static double money;
    private static BigDecimal wiseMoney;

    private int accountA;
    private int accountB;

    public static void main(String[] args) {
        money = 0;
        for (int i = 0; i < 10000; i++) {
            money = money + 0.1;
        }

        wiseMoney = BigDecimal.ZERO;
        for (int i = 0; i < 10000; i++) {
            wiseMoney = wiseMoney.add(BigDecimal.valueOf(0.1));
        }

        // 1/10 be something like 0.010101011010110111110000111111   1/3 = 0.333333333333333333

        System.out.println(money == 1000.0);
        System.out.println(money);
        System.out.println(wiseMoney);

        BankAccount account = new BankAccount();
        System.out.println(account.getAccountA());

        new Thread(){
            public void run() {
                account.depositA(1000);
            }
        }.start();
        new Thread(){
            public void run() {
                account.withdrawA(500);
            }
        }.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(account.getAccountA());

        new Thread(){
            public void run() {
                account.moveMoney(500);
            }
        }.start();

        synchronized (account) {
            System.out.println("Total sum: " + (account.getAccountA() + account.getAccountB()));
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (account) {
            System.out.println("Total sum: " + (account.getAccountA() + account.getAccountB()));
        }

        System.out.println("accountA = " + account.getAccountA());
        System.out.println("accountB = " + account.getAccountB());
    }

    public synchronized void moveMoney(int amount) {
        depositB(amount);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        withdrawA(amount);
    }

    public synchronized void depositA(int amount){
//        synchronized (this) {
            accountA = accountA + amount;
//        }
    }

    public synchronized void withdrawA(int amount){
        accountA = accountA - amount;
    }

    public synchronized void depositB(int amount){
        accountB = accountB + amount;
    }

    public synchronized void withdrawB(int amount){
        accountB = accountB - amount;
    }

    public synchronized int getAccountA() {
        return accountA;
    }

    public synchronized void setAccountA(int accountA) {
        this.accountA = accountA;
    }

    public synchronized void setAccountB(int accountB) {
        this.accountB = accountB;
    }

    public synchronized int getAccountB() {
        return accountB;
    }

    public synchronized static void method(){
//        synchronized (BankAccount.class){
            // do something
//        }
    }

    public synchronized static void method2(){
        // do something
    }


}
