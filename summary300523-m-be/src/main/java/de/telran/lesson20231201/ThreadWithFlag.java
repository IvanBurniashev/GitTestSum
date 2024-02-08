package de.telran.lesson20231201;

public class ThreadWithFlag {

    private static int count = 0;

    private static volatile boolean shouldStop = false;


    public static void main(String[] args) {

        Thread thread = new Thread(new Task());
        thread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // stop logic
//        thread.interrupt(); // count = 810623000 819933000
//        shouldStop = true; // count = 955574000 908096000 non-volatile
        shouldStop = true; // count = 814486000 786110000 volatile

    }

    static class Task implements Runnable {

        @Override
        public void run() {
//            while (!Thread.interrupted()) {
            while (!shouldStop) {
                count++;
                if (count % 1_000 == 0) System.out.println(count);
            }
        }
    }


}
