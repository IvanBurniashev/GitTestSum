package de.telran.lesson20231201;

public class NotBusyWait {

    private static Object mutex = new Object();
//    private static BankAccount bankAccount = new BankAccount();

    public static void main(String[] args) {
        Thread thread = new Thread(new Task(), "Thread 1");
        Thread thread2 = new Thread(new Task(), "Thread 2");
        thread.start();
        thread2.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        bankAccount.moveMoney(100);

        synchronized (mutex){
//            mutex.notify();
            mutex.notifyAll();
            System.out.println("notifyAll called");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    static class Task implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " starting...");
            synchronized (mutex) {
                try {
                    System.out.println(Thread.currentThread().getName() + " waiting...");
                    mutex.wait();
                    System.out.println(Thread.currentThread().getName() + " awaken");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName() + " doing task...");
        }
    }


}
