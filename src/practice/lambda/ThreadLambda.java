package practice.lambda;

public class ThreadLambda {


    public static void main(String[] args) {
/*        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside thread: "+ Thread.currentThread());
            }
        });*/

        Thread th = new Thread(() -> System.out.println("Inside thread: "+ Thread.currentThread().getName()));
        System.out.println("In main thread "+Thread.currentThread().getName());
        th.start();

    }
}
