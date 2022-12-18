package practice.completablefuture;

import java.util.concurrent.CompletableFuture;

public class First {

    public static int compute(){
        System.out.println("compute "+ Thread.currentThread());
        return 2;
    }
    public static CompletableFuture<Integer> create(){
        return CompletableFuture.supplyAsync(()->compute());
    }
    public static void printIt(int value){
        System.out.println(value);
        System.out.println("print "+Thread.currentThread());
    }
    public static void main(String[] args) {
        System.out.println("main "+ Thread.currentThread());
        create().thenAccept(data -> printIt(data));
    }
}
