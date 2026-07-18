package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * E03 — ExecutorService factory methods
 *
 * newFixedThreadPool(n)   — fixed workers, bounded by n
 * newCachedThreadPool()   — grows on demand, reuses idle threads (risk: too many threads)
 * newSingleThreadExecutor() — one worker, tasks queued FIFO (order preserved)
 *
 * Run: java concurrency.ExecutorServiceFactoriesDemo
 */
public class ExecutorServiceFactoriesDemo {

    public static void main(String[] args) throws InterruptedException {
        demoFixed();
        demoCached();
        demoSingle();
    }

    private static void demoFixed() throws InterruptedException {
        System.out.println("=== FixedThreadPool(2) — max 2 workers ===");
        ExecutorService fixed = Executors.newFixedThreadPool(2);
        submitFiveTasks(fixed, "fixed");
        fixed.shutdown();
        fixed.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println();
    }

    private static void demoCached() throws InterruptedException {
        System.out.println("=== CachedThreadPool — creates threads as needed ===");
        ExecutorService cached = Executors.newCachedThreadPool();
        submitFiveTasks(cached, "cached");
        cached.shutdown();
        cached.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println();
    }

    private static void demoSingle() throws InterruptedException {
        System.out.println("=== SingleThreadExecutor — one worker, strict queue order ===");
        ExecutorService single = Executors.newSingleThreadExecutor();
        submitFiveTasks(single, "single");
        single.shutdown();
        single.awaitTermination(10, TimeUnit.SECONDS);
    }

    private static void submitFiveTasks(ExecutorService pool, String label) {
        for (int i = 1; i <= 5; i++) {
            int taskId = i;
            pool.submit(() -> {
                System.out.println(label + " task-" + taskId + " on " + Thread.currentThread().getName());
                sleepQuiet(400);
            });
        }
    }

    private static void sleepQuiet(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
