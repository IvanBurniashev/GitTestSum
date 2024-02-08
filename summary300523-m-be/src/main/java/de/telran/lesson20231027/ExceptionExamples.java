package de.telran.lesson20231027;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.ZipException;

public class ExceptionExamples {

    private static boolean isZip = true;

    public static void main(String[] args) {

//        System.out.println( 1 / 0);

//        int[] data = new int[5];
//        System.out.println(data[5]);
//

//        try {
//          throw new RuntimeException("Something bad happened");
//        } catch (RuntimeException e){
//            System.out.println("Hello!");
//        }

//        try {
//            someMethod();
//        } catch (FileNotFoundException | ZipException e) { // multi-catch
////            System.out.println("File not found");
//            e.printStackTrace();
//        }

//        try {
//            someMethod();
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found");
//        } catch (ZipException e) {
//            System.out.println("Zip file not found");
//        }

        try {
            someMethod();
        } catch (IOException e) { // general input-output exception
            System.out.println("File or zip file not found");
        }


        System.out.println("Some other actions");

    }

    private static void someMethod() throws FileNotFoundException, ZipException {
        if (isZip) throw new ZipException();
        throw new FileNotFoundException();
    }


}
