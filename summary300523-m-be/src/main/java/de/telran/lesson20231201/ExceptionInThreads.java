package de.telran.lesson20231201;

public class ExceptionInThreads {

    public static void main(String[] args) {

        Thread.setDefaultUncaughtExceptionHandler((t, e) ->
                System.out.println("Default Exception Handler dealing with thread "
                        + t.getName() + ", message: " + e.getMessage())
        );

//        Thread.currentThread().setUncaughtExceptionHandler();

        Thread thread = new Thread(){
            public void run(){
                int i = 0;
                while (true) {
                    System.out.println(i++);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (i == 20) throw new RuntimeException("Something bad happened");
                }
            }

        };
        thread.setUncaughtExceptionHandler((t, e) -> {
            System.out.println("Exception in additional thread "
                    + t.getName() + ", message: " + e.getMessage());
        });
        thread.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(1 / 0);
    }


}
