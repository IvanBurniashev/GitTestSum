package de.telran.lesson20231117;

public class ReflectionExamples {

    public static void main(String[] args) {
        Object o1 = "123";
        Object o2 = 123;
        String[] o3 = new String[]{"A", "B", "C"};
        int[] o4 = new int[]{1, 2, 3};

        Class<?> o1Class = o1.getClass();
        System.out.println(o1Class.getSimpleName());
        System.out.println(o1Class.getCanonicalName());
        System.out.println(o1Class.getName());

        Class<?> o3Class = o3.getClass();
        System.out.println(o3Class.getSimpleName());
        System.out.println(o3Class.getCanonicalName());
        System.out.println(o3Class.getName());

        Class<?> o4Class = o4.getClass();
        System.out.println(o4Class.getSimpleName());
        System.out.println(o4Class.getCanonicalName());
        System.out.println(o4Class.getName());
    }


}
