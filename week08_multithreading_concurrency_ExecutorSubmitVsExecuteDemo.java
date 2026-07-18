package concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * E02 — execute() vs submit()
 *
 * execute(Runnable) — fire-and-forget, no return value
 * submit(Runnable/Callable) — returns Future (use get() for result or exceptions)
 *
 * Run: java concurrency.ExecutorSubmitVsExecuteDemo
 */
public class ExecutorSubmitVsExecuteDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(2);

        pool.execute(() -> System.out.println("execute: " + Thread.currentThread().getName()));

        Future<?> voidFuture = pool.submit(() ->
                System.out.println("submit Runnable: " + Thread.currentThread().getName()));
        voidFuture.get(); // wait for Runnable to finish

        Future<Integer> intFuture = pool.submit(() -> {
            sleepQuiet(300);
            return 7 * 6;
        });
        System.out.println("submit Callable result: " + intFuture.get());

        Future<Integer> failing = pool.submit(() -> {
            throw new IllegalStateException("task failed");
        });
        try {
            failing.get();
        } catch (ExecutionException ex) {
            System.out.println("ExecutionException wraps: " + ex.getCause().getMessage());
        }

        pool.shutdown();
    }

    private static void sleepQuiet(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
