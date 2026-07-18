package concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * E04 — Custom ThreadPoolExecutor (core, max, queue, rejection policy)
 *
 * Observe CallerRunsPolicy: when queue is full, submitting thread runs the task (backpressure).
 *
 * Run: java concurrency.CustomThreadPoolExecutorDemo
 */
public class CustomThreadPoolExecutorDemo {

    public static void main(String[] args) throws InterruptedException {
        int core = 2;
        int max = 4;
        int queueCapacity = 3;

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                core,
                max,
                30L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(queueCapacity),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        System.out.println("core=" + core + " max=" + max + " queue=" + queueCapacity);
        System.out.println("pool size ~ core+queue+max burst before CallerRuns kicks in");
        System.out.println();

        for (int i = 1; i <= 12; i++) {
            int taskId = i;
            String submitter = Thread.currentThread().getName();
            executor.execute(() -> {
                System.out.println("task-" + taskId + " worker=" + Thread.currentThread().getName()
                        + " (submitted from " + submitter + ")");
                sleepQuiet(500);
            });
            printPoolState(executor, "after submit task-" + i);
        }

        executor.shutdown();
        executor.awaitTermination(60, TimeUnit.SECONDS);
        System.out.println("all tasks done");
    }

    private static void printPoolState(ThreadPoolExecutor ex, String label) {
        System.out.println(label + " → active=" + ex.getActiveCount()
                + " pool=" + ex.getPoolSize()
                + " queue=" + ex.getQueue().size());
    }

    private static void sleepQuiet(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
