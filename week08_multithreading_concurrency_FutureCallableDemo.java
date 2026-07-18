package concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * E01 — Future + Callable basics
 *
 * submit(Callable) returns Future<T>. get() blocks until result is ready.
 * Run: java concurrency.FutureCallableDemo
 */
public class FutureCallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService pool = Executors.newFixedThreadPool(2);

        Callable<Integer> slowSum = () -> {
            System.out.println("worker " + Thread.currentThread().getName() + " computing...");
            sleep(1000);
            return 40 + 2;
        };

        Future<Integer> future = pool.submit(slowSum);
        System.out.println("main: submitted — can do other work while worker runs");
        sleep(200);
        System.out.println("main: isDone? " + future.isDone());

        int result = future.get(); // blocks until ready
        System.out.println("main: result = " + result);

        Future<Integer> slowAgain = pool.submit(() -> {
            sleep(5000);
            return 99;
        });
        try {
            System.out.println("with timeout: " + slowAgain.get(500, TimeUnit.MILLISECONDS));
        } catch (TimeoutException ex) {
            System.out.println("TimeoutException — task still running, cancel? " + slowAgain.cancel(true));
        }

        pool.shutdown();
        pool.awaitTermination(5, TimeUnit.SECONDS);
    }

    private static void sleep(long ms) throws InterruptedException {
        Thread.sleep(ms);
    }
}
