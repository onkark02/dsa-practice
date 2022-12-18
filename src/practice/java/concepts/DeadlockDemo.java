package practice.java.concepts;

public class DeadlockDemo {
    public static void main(String[] args) {
        MyRunnable1 myRunnable1 = new MyRunnable1();
        Thread th = new Thread(myRunnable1);
        th.start();
        myRunnable1.callm1();
    }
}

class MyRunnable1 implements Runnable{
    private A a;
    private B b;

    public MyRunnable1(){
        a = new A();
        b = new B();
    }

    public void callm1(){
        a.m1(b);
    }

    @Override
    public void run() {
        b.m1(a);
    }
}

class A {
    public  synchronized void m1(B b){
        System.out.println(Thread.currentThread().getName() + " - m1");
        try{
            Thread.sleep(1000);
        }catch (InterruptedException ex){

        }

        System.out.println(Thread.currentThread().getName() + " waiting for last() of B");
        b.last();
    }

    public synchronized void last(){
        System.out.println(Thread.currentThread().getName() + " inside last method of A");
    }
}

class B {
    public synchronized void m1(A a){
        System.out.println(Thread.currentThread().getName() + " - m1");
        try{
            Thread.sleep(1000);
        }catch (InterruptedException ex){

        }
        System.out.println(Thread.currentThread().getName() + " waiting for last() of A");
        a.last();
    }
    public synchronized void last(){
        System.out.println(Thread.currentThread().getName() + " inside last method of B");
    }
}