package de.telran.lesson20230915;

public class A {

    private String s;

    private int i;

    private boolean b;

    // one field - s - included
//    @Override
//    public boolean equals(Object another){
//        if (another instanceof A) {
//            A anotherA = (A) another;
//            return s.equals(anotherA.s);
//        }
//        return false;
//    }
//
//    @Override
//    public int hashCode(){
//        return s.hashCode();
//    }

    // all fields included
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        A a = (A) o;

        if (i != a.i) return false;
        if (b != a.b) return false;
        return s.equals(a.s);
    }

    @Override
    public int hashCode() {
        int result = s.hashCode();
        result = 31 * result + i;
        result = 31 * result + (b ? 1 : 0);
        return result;
    }

}
