package de.telran.lesson20230908;

public class UseChild {


    public static void main(String[] args) {
//        Parent parent = new Parent();
//        System.out.println(parent.getParentData());
//        System.out.println(parent.staticParentData);

        System.out.println("Child.childStaticData = " + Child.childStaticData);

        System.out.println("----New child object creation----");
        Child child = new Child();
        System.out.println("----New child object in use----");
        System.out.println("child.parentData = " + child.parentData);
        System.out.println("child.childData = " + child.childData);
        System.out.println("child.data = " + child.data);
    }
}
