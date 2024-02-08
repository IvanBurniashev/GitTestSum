package de.telran.lesson20231201;

public class BusyWait {

    private volatile static boolean shouldDo = false;

    public static void main(String[] args) {
        Thread thread = new Thread(new Task());
        thread.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        shouldDo = true;

    }

    static class Task implements Runnable{

        @Override
        public void run() {
            while (!shouldDo){
                // do nothing
            }

            System.out.println("Doing task...");
        }
    }


}
