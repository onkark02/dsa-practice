package practice.java.concepts;

public class ThreadPriorityDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread lp_thread = new Thread(()->{
            System.out.println("LP thread start");
            for (int i = 0; i < 50000; i++) {
                System.out.print("-");
            }
            System.out.println("LP thread end");
        });

        Thread hp_thread = new Thread(()->{
            for (int i = 0; i < 5000; i++) {
                System.out.println("HP thread");
            }
        });

        hp_thread.setPriority(10);

        lp_thread.start();
        Thread.sleep(1);
        hp_thread.start();

        System.out.println("main end");
    }
}
