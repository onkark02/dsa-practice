package practice.completablefuture;

import java.util.concurrent.CompletableFuture;

public class Second {
    public static void process(CompletableFuture<Integer> future){
        future.thenApply(data -> data * data)
                .thenApply(data -> data +1)
                .thenAccept(System.out::println)
                .thenAccept((data)->System.out.println("process "+ Thread.currentThread()))
                .thenAccept((data)->System.out.println("process "+ Thread.currentThread()))
                        .thenAccept((data)->System.out.println("process "+ Thread.currentThread()))
                        .thenAccept((data)->System.out.println("process "+ Thread.currentThread()));

    }

    public static void main(String[] args) {
        CompletableFuture<Integer> future = new CompletableFuture<>();
        process(future);
        future.complete(5);
    }
}
