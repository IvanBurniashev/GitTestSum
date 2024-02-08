package de.telran.lesson20230908;

public class Parent {

    public String parentData = "Parent data";
    public String data = "Data from parent";

    public static String staticParentData = "Static Parent Data";

    {
        System.out.println("Parent init block");
        parentData = "Parent init block data";

    }

    static {
        System.out.println("Parent static init block");
        staticParentData = "Data from parent static init";
    }

    public Parent() {
        System.out.println("Parent constructor");
        this.parentData = "Parent data from constructor";
    }

    public String getParentData() {
        return parentData;
    }

    public void setParentData(String parentData) {
        this.parentData = parentData;
    }
}
