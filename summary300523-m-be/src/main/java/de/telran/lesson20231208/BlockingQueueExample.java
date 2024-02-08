package de.telran.lesson20231208;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class BlockingQueueExample {

    static BlockingQueue<String> data = new ArrayBlockingQueue<>(5, true);
//    static BlockingQueue<String> data = new SynchronousQueue<>(true);

    public static void main(String[] args) {
        new Producer().start();
        new Producer().start();
        new Producer().start();
        new Consumer().start();
    }

    static class Producer extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    data.put(Thread.currentThread().getName() + " data " + i);
                    System.out.println(Thread.currentThread().getName() + " inserted data in the queue");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    static class Consumer extends Thread {

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("Queue size: " + data.size());
                    System.out.println("Data got by " + Thread.currentThread().getName() + ": " + data.take());
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }




}
