package de.telran.lesson20230908;

public class Child extends Parent {

    public String childData;
    public String data = "Data in child";

    public static String childStaticData = "Child Static Data";

    {
        System.out.println("Child init block");
    }

    static {
        System.out.println("Child static init block");
    }

    public Child() {
//        super();
        System.out.println("Child constructor");
        childData = "Child data from constructor";

        System.out.println("super.data field: " + super.data);
        System.out.println("this.data field: " + this.data);

    }
}
