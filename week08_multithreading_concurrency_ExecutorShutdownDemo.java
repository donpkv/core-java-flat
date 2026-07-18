package concurrency;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * E05 — Graceful shutdown: shutdown(), shutdownNow(), awaitTermination()
 *
 * Run: java concurrency.ExecutorShutdownDemo
 */
public class ExecutorShutdownDemo {

    public static void main(String[] args) throws InterruptedException {
        demoGracefulShutdown();
        System.out.println();
        demoShutdownNow();
    }

    private static void demoGracefulShutdown() throws InterruptedException {
        System.out.println("=== shutdown() — wait for queued tasks ===");
        ExecutorService pool = Executors.newFixedThreadPool(2);

        for (int i = 1; i <= 4; i++) {
            int id = i;
            pool.submit(() -> {
                System.out.println("task-" + id + " start");
                sleepQuiet(300);
                System.out.println("task-" + id + " end");
            });
        }

        pool.shutdown(); // no new tasks; existing queue still runs
        System.out.println("shutdown called — isShutdown=" + pool.isShutdown());

        boolean finished = pool.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("awaitTermination finished=" + finished + " isTerminated=" + pool.isTerminated());
    }

    private static void demoShutdownNow() throws InterruptedException {
        System.out.println("=== shutdownNow() — interrupt workers, return pending list ===");
        ExecutorService pool = Executors.newFixedThreadPool(1);

        pool.submit(() -> {
            System.out.println("long task start");
            sleepQuiet(5000);
            System.out.println("long task end (often skipped)");
        });

        sleepQuiet(200);
        List<Runnable> pending = pool.shutdownNow().stream().toList();
        System.out.println("shutdownNow pending tasks in queue: " + pending.size());
        pool.awaitTermination(2, TimeUnit.SECONDS);
        System.out.println("isTerminated=" + pool.isTerminated());
    }

    private static void sleepQuiet(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " interrupted");
            Thread.currentThread().interrupt();
        }
    }
}
