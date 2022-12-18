package practice.completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class AllOfExample {
    private Executor executor = Executors.newFixedThreadPool(5);
    private String getGreet(String lang) {
        if (lang.equals("EN")) {
            return "Hello";
        } else if (lang.equals("ES")) {
            return "Hola";
        } else if (lang.equals("SN")) {
            return "Ayubovan";
        } else {
            throw new IllegalArgumentException("Invalid lang param");
        }
    }
    private CompletableFuture<GreetHolder> getGreeting(String lang) {
        return CompletableFuture.supplyAsync( () -> {
            try {
                System.out.println("Task execution started.");
                Thread.sleep(2000);
                System.out.println("Task execution stopped.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return new GreetHolder(getGreet(lang));
        }, executor).exceptionally( ex -> {
            System.out.println("Something went wrong : "+ ex);
            return null;
        });
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        AllOfExample allOfExample = new AllOfExample();
        List<String> langList = Arrays.asList("EN", "ES", "SN", "EX");
        long startTime = System.currentTimeMillis();
        List<CompletableFuture<GreetHolder>> completableFutures =
                langList.stream().map(lang -> allOfExample.getGreeting(lang)).collect(Collectors.toList());
        long endTime = System.currentTimeMillis();
        CompletableFuture<Void> allFutures = CompletableFuture
                .allOf(completableFutures.toArray(new CompletableFuture[completableFutures.size()]));
        CompletableFuture<List<GreetHolder>> allCompletableFuture = allFutures.thenApply(future -> {
            return completableFutures.stream()
                    .map(completableFuture -> completableFuture.join())
                    .collect(Collectors.toList());
        });
        CompletableFuture completableFuture = allCompletableFuture.thenApply(greets -> {
            return greets.stream().filter(Objects::nonNull)
                    .map(GreetHolder::getGreet).collect(Collectors.toList());
        });
        completableFuture.get();

        System.out.println("Time taken: "+ (endTime-startTime));
    }
    private class GreetHolder {

        private String greet;

        public GreetHolder(String greet) {
            this.greet = greet;
        }

        public String getGreet() {
            return greet;
        }

        public void setGreet(String greet) {
            this.greet = greet;
        }
    }
}
