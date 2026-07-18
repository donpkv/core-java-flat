package concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * CompletableFuture: async programming without raw Thread boilerplate.
 * supplyAsync, thenApply, thenAccept, exceptionally, allOf.
 */
public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture
                .supplyAsync(() -> {
                    sleep(500);
                    return "Hello";
                })
                .thenApply(s -> s + " Java")
                .thenApply(String::toUpperCase);

        System.out.println("Result: " + future.get());

        CompletableFuture<Void> chain = CompletableFuture
                .supplyAsync(() -> 10)
                .thenApply(x -> x * 2)
                .thenAccept(result -> System.out.println("Async result: " + result));

        chain.join();

        CompletableFuture<Object> failing = CompletableFuture
                .supplyAsync(() -> {
                    throw new RuntimeException("Something failed");
                })
                .exceptionally(ex -> "Recovered: " + ex.getMessage());

        System.out.println(failing.get());
    }

    static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
