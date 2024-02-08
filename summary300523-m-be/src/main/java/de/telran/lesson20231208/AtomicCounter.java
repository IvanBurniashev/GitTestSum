package de.telran.lesson20231208;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {

    static int count;
    static AtomicInteger atomicCount = new AtomicInteger(0);

    public static void main(String[] args) {

        new Thread(new Task()).start();
        new Thread(new Task()).start();


    }

    static class Task implements Runnable {

        @Override
        public void run() {
            while (true) {
//                ++count;
//                atomicCount.incrementAndGet();
//                System.out.println(atomicCount.get());

                int old;
                int tmp;
                boolean isUpdated;
                do {
                    old = atomicCount.get();
                    tmp = old;
                    tmp++;
                    System.out.println(tmp);
                    isUpdated = atomicCount.compareAndSet(old, tmp);
                    if (!isUpdated) System.out.println("Not updated!!!");
                } while (!isUpdated);

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
