package practice.java.concepts;

public class ThreadJoinDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread myThread = new Thread(new MyRunnable());
        myThread.start();
        myThread.join(5000);
//        myThread.join();
        for (int i = 0; i < 10; i++) {
            System.out.println("Main thread"); myThread.join();
            myThread.interrupt();
        }
    }
}

class MyRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Child thread");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}