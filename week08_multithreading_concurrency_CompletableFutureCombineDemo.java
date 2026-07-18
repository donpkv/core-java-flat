package concurrency;

import java.util.concurrent.CompletableFuture;

/**
 * C02 — Combine futures: allOf, anyOf, thenCombine
 *
 * Run: java concurrency.CompletableFutureCombineDemo
 */
public class CompletableFutureCombineDemo {

    public static void main(String[] args) {
        CompletableFuture<String> a = CompletableFuture.supplyAsync(() -> delayReturn("A", 300));
        CompletableFuture<String> b = CompletableFuture.supplyAsync(() -> delayReturn("B", 500));
        CompletableFuture<String> c = CompletableFuture.supplyAsync(() -> delayReturn("C", 200));

        CompletableFuture<Void> all = CompletableFuture.allOf(a, b, c);
        all.join();
        System.out.println("allOf done: " + a.join() + "+" + b.join() + "+" + c.join());

        CompletableFuture<Object> any = CompletableFuture.anyOf(
                delayReturnAsync("fast", 100),
                delayReturnAsync("slow", 2000)
        );
        System.out.println("anyOf winner: " + any.join());

        CompletableFuture<String> combined = CompletableFuture
                .supplyAsync(() -> 10)
                .thenCombine(CompletableFuture.supplyAsync(() -> 20), (x, y) -> "sum=" + (x + y));
        System.out.println("thenCombine: " + combined.join());
    }

    private static String delayReturn(String label, long ms) {
        sleepQuiet(ms);
        return label;
    }

    private static CompletableFuture<String> delayReturnAsync(String label, long ms) {
        return CompletableFuture.supplyAsync(() -> delayReturn(label, ms));
    }

    private static void sleepQuiet(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
