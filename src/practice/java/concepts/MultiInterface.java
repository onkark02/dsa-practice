package practice.java.concepts;

public class MultiInterface implements Test1,Test2{
    public static void main(String[] args) {
        MultiInterface multiInterface = new MultiInterface();
        multiInterface.printMessage("hello");
    }

    @Override
    public void printMessage(String str) {
        Test1.super.printMessage(str);
    }
}

interface Test1 {
    default void printMessage(String str){
        System.out.println("test1: "+str);
    }
}


interface Test2 {
    default void printMessage(String str){
        System.out.println("test2: "+str);
    }
}
