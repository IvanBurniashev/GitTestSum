package de.telran.lesson20231027;

import java.io.*;
import java.util.Scanner;

public class ReadWriteToFile {

    public static void main(String[] args) {

        File file = new File("resources/text.txt");
        System.out.println(file.exists());

        BufferedReader bufferedReader = null;
        try {
            Reader reader = new FileReader(file);
            bufferedReader = new BufferedReader(reader);

//            System.out.println(bufferedReader.readLine());
//            System.out.println(bufferedReader.readLine());
//            System.out.println(bufferedReader.readLine());

            String line;
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("IOException");
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    System.out.println("IOException");
                }
            }
        }

        try (Scanner scanner = new Scanner(file)) { // try-with-resources
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
        }


        try (Writer writer = new FileWriter(file, true); // try-with-resources
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
        ) {
//            bufferedWriter.write("Hello world");
            bufferedWriter.append("Hello world to EOF");
        } catch (IOException e) {
            System.out.println("IOException");
        } finally {
            System.out.println("Final operations");
        }

        System.out.println("Operations after catch block");
    }

}
