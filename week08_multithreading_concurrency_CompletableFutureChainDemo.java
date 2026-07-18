package concurrency;

import java.util.concurrent.CompletableFuture;

/**
 * C01 — CompletableFuture chain: thenApply vs thenCompose
 *
 * thenApply  — map result (sync transform on same pipeline thread by default)
 * thenCompose — flatMap (chain another async CompletableFuture)
 *
 * Run: java concurrency.CompletableFutureChainDemo
 */
public class CompletableFutureChainDemo {

    public static void main(String[] args) {
        CompletableFuture<String> withApply = CompletableFuture
                .supplyAsync(() -> fetchUserId())
                .thenApply(id -> "user-" + id)
                .thenApply(name -> name.toUpperCase());

        System.out.println("thenApply chain: " + withApply.join());

        CompletableFuture<String> withCompose = CompletableFuture
                .supplyAsync(() -> fetchUserId())
                .thenCompose(id -> fetchProfileAsync(id)); // async next step

        System.out.println("thenCompose chain: " + withCompose.join());
    }

    private static int fetchUserId() {
        sleepQuiet(200);
        return 42;
    }

    private static CompletableFuture<String> fetchProfileAsync(int userId) {
        return CompletableFuture.supplyAsync(() -> {
            sleepQuiet(200);
            return "profile-for-" + userId;
        });
    }

    private static void sleepQuiet(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
