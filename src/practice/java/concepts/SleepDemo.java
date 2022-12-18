package practice.java.concepts;

public class SleepDemo {
    public static void main(String[] args) {
        Mythred mt = new Mythred();

        mt.start();
        mt.interrupt();
        System.out.println("Main end");
    }

}

class Mythred extends Thread{
    @Override
    public void run() {
        try {
            for (int i = 0; i < 5000; i++) {
                System.out.println("Lazy thread");
            }
            Thread.sleep(1000);
            System.out.println("Completed sleeping");
//            UUID.randomUUID();
        }catch (InterruptedException ex){
            System.out.println("Interrupted");
        }
    }
}
