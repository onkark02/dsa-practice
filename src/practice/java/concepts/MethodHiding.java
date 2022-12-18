package practice.java.concepts;

public class MethodHiding {
    public static void main(String[] args) {
        Child ch = new Child();
        ch.print();
        Parent p = (Parent) ch;
        p.print();
    }

}

class Parent{
    public static void print(){
        System.out.println("Parent print statement");
    }
}

class Child extends Parent{
    public static void print(){
        System.out.println("Child print statement");
    }
}

class HideVariable {

    private String message = "this is instance variable";

    HideVariable() {
        String message = "constructor local variable";
        System.out.println(message);
    }

    public void printLocalVariable() {
        String message = "method local variable";
        System.out.println(message);
    }

    public void printInstanceVariable() {
        String message = "method local variable";
        System.out.println(this.message);
    }
}


