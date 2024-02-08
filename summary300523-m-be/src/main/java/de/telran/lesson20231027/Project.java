package de.telran.lesson20231027;

import java.util.Arrays;

public class Project {

    public static void main(String[] args) {

        try {
            method1();
        } catch (CustomExceptionForProject e) {
            String message = e.getMessage();
            System.out.println(message);
            StackTraceElement[] stackTrace = e.getStackTrace();
            System.out.println(Arrays.toString(stackTrace));
//            e.printStackTrace();
        }

        Exception myException = new Exception("Special message");
    }

    public static void method1() throws CustomExceptionForProject {
        System.out.println("Method 1 works");
        throw new CustomExceptionForProject("Some problem in method 1");
    }

}
