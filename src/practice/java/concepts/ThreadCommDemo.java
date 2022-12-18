package practice.java.concepts;

public class ThreadCommDemo {
    public static void main(String[] args) throws InterruptedException {
        ThreadA threadA = new ThreadA();
        threadA.start();
        //threadA.join();
        Thread.sleep(200);
        synchronized (threadA){
            System.out.println("main waiting for threadA");
            threadA.wait(500);
            System.out.println("main method got notified");
            System.out.println("main - Total value: "+threadA.total);
        }

    }
}

class ThreadA extends Thread{
    int total=0;

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i <= 1000; i++) {
                total += i;
            }
            System.out.println("Completed comp, notifying main");
            this.notify();
/*            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
        System.out.println("Notified main");
    }
}
