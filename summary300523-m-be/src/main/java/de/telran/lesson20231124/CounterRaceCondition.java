package de.telran.lesson20231124;

public class CounterRaceCondition {

    static int count = 0;

    static Object mutex = new Object();
    static Object mutex2 = new Object();

    public static void main(String[] args) {

        Thread thread1 = new Thread(new Task());
        Thread thread2 = new Thread(new Task());
        thread1.start();
        thread2.start();
    }

    static class Task implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
//                synchronized (mutex) {
//                synchronized (CounterRaceCondition.class) {
//                    count++;
//                    System.out.println(count);
//                }
                increment();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private static synchronized void increment() {
//        synchronized (CounterRaceCondition.class) {
            count++;
            System.out.println(count);
//        }
    }

    private synchronized void incrementNonStatic() {
//        synchronized (this) {
            count++;
            System.out.println(count);
//        }
    }

}
