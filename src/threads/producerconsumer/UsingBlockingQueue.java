package threads.producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class UsingBlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Item> queue = new ArrayBlockingQueue<>(10);

        final Runnable producer = () -> {
            while (true) {
                queue.add(new Item());
            }
        };

        new Thread(producer).start();
        new Thread(producer).start();

        final Runnable consumer = () -> {
          while(true){
              try {
                  Item i = queue.take();
                  i.process();
              } catch (InterruptedException exception) {
                  exception.printStackTrace();
              }

          }
        };

        new Thread(consumer).start();
        new Thread(consumer).start();

        Thread.sleep(5000);
    }
}
