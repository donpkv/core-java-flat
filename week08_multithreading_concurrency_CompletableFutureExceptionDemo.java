package concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * C04 — CompletableFuture errors: exceptionally, handle, whenComplete
 *
 * Run: java concurrency.CompletableFutureExceptionDemo
 */
public class CompletableFutureExceptionDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> withExceptionally = CompletableFuture
                .<String>supplyAsync(() -> {
                    throw new RuntimeException("payment failed");
                })
                .exceptionally(ex -> "fallback: " + ex.getMessage());
        System.out.println("exceptionally: " + withExceptionally.get());

        CompletableFuture<String> handled = CompletableFuture
                .<String>supplyAsync(() -> {
                    throw new RuntimeException("db down");
                })
                .handle((result, ex) -> ex != null ? "handled-" + ex.getMessage() : result);
        System.out.println("handle: " + handled.get());

        CompletableFuture<Void> logged = CompletableFuture
                .supplyAsync(() -> 100)
                .whenComplete((value, ex) ->
                        System.out.println("whenComplete value=" + value + " error=" + ex))
                .thenAccept(v -> System.out.println("thenAccept still runs: " + v));
        logged.join();
    }
}
