package practice.random;

public abstract class AbstractTest {
    abstract void method1();

    void method2(){
        System.out.println("Inside method 2");
        method1();
    }
}
