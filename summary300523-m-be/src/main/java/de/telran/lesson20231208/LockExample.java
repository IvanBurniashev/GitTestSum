package de.telran.lesson20231208;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {

    static Object object = new Object();
    static Lock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        new Thread(LockExample::task, "Thread 1").start();
        new Thread(LockExample::task, "Thread 2").start();
        new Thread(LockExample::task2, "Thread 3").start();
    }

    public static void task() {
        while (true) {
//            synchronized (object) {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " got access to the object");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                lock.unlock();
            }
//            }
        }

    }

    public static void task2() {
        while (true) {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " got access to the object");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                boolean flag = true;
                if (flag) throw new RuntimeException("Something bad happened");
            } finally {
                lock.unlock();
            }
        }

    }
}
