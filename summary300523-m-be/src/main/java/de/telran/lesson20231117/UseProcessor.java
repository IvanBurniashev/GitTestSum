package de.telran.lesson20231117;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class UseProcessor {

    public static void main(String[] args) {
        Processor processor = new Processor("123");
        processor.process(100);
        processor.count = 500;
        System.out.println(processor.count);

        Class<? extends Processor> aClass = processor.getClass();
        System.out.println(Arrays.toString(aClass.getDeclaredMethods()));
        try {
            Method methodProcess = aClass.getMethod("process", int.class);
            methodProcess.invoke(processor, 200);

            Method methodChangeId = aClass.getDeclaredMethod("changeId");
            methodChangeId.setAccessible(true);
            methodChangeId.invoke(processor);

            Field idField = aClass.getDeclaredField("id");
            idField.setAccessible(true);
            System.out.println("id = " + idField.get(processor));
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | NoSuchFieldException e) {
            e.printStackTrace();
        }

        try {
//            @SuppressWarnings("deprecation")
//            Processor processor1 = aClass.newInstance();
            Processor newInstance = aClass.getConstructor(String.class).newInstance("123");
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

        try {
            Class<?> newClass = Class.forName("de.telran.lesson20231117.Processor");
            Processor newProcessor = (Processor) newClass.getConstructor(String.class).newInstance("new Id");
            newProcessor.process(999);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            e.printStackTrace();
        }


    }


}
