package concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * C03 — CompletableFuture with custom ExecutorService (don't use common pool in production)
 *
 * Run: java concurrency.CompletableFutureCustomExecutorDemo
 */
public class CompletableFutureCustomExecutorDemo {

    public static void main(String[] args) {
        ExecutorService ioPool = Executors.newFixedThreadPool(4, r -> {
            Thread t = new Thread(r);
            t.setName("io-pool-worker");
            return t;
        });

        CompletableFuture<String> onCustomPool = CompletableFuture
                .supplyAsync(() -> {
                    System.out.println("supplyAsync on: " + Thread.currentThread().getName());
                    sleepQuiet(200);
                    return "data";
                }, ioPool)
                .thenApplyAsync(data -> {
                    System.out.println("thenApplyAsync on: " + Thread.currentThread().getName());
                    return data + "-processed";
                }, ioPool);

        System.out.println("result: " + onCustomPool.join());

        ioPool.shutdown();
    }

    private static void sleepQuiet(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
