package de.telran.lesson20231124;

import java.util.concurrent.*;

public class CountPrimes {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread());

        // Последовательные вычисления
//        int count1 = getCount(2, 33_000);
//        int count2 = getCount(33_000, 66_000);
//        int count3 = getCount(66_000, 100_000);
//        System.out.println("Total numbers of primes: " + (count1 + count2 + count3));

        // Параллельные вычисления с помощью потоков
        Task task1 = new Task(2, 33_000);
        Task task2 = new Task(33_000, 66_000);
        Task task3 = new Task(66_000, 100_000);
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        Thread thread3 = new Thread(task3);
        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            System.out.println("Total numbers of primes: "
                    + (task1.count + task2.count + task3.count));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Параллельные вычисления с помощью экзекуторов
        System.out.println("Available Processors: " + Runtime.getRuntime().availableProcessors());
//        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() / 2);
//        ExecutorService executorService = Executors.newFixedThreadPool(4);
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> future1 = executorService.submit(new TaskForExecutor(2, 33_000));
        Future<Integer> future2 = executorService.submit(new TaskForExecutor(33_000, 66_000));
        Future<Integer> future3 = executorService.submit(new TaskForExecutor(66_000, 100_000));

        // some other logic in main thread ...

        try {
            System.out.println("Total numbers of primes with CachedThreadPool: "
                    + (future1.get() + future2.get() + future3.get()));
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();

    }

    private static int getCount(int start, int end) {
        int count = 0;
        for (int i = start; i < end; i++) {
            boolean isPrime = true;
            for (int j= 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime)
                count++;
        }
        return count;
    }

    static class Task implements Runnable {
        int count = 0;
        int start;
        int end;

        public Task(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            count = getCount(start, end);
        }
    }

    static class TaskForExecutor implements Callable<Integer> {
        int start;
        int end;

        public TaskForExecutor(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public Integer call() throws Exception {
            return getCount(start, end);
        }
    }


}
