package concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * E06 — ScheduledExecutorService
 *
 * schedule — run once after delay
 * scheduleAtFixedRate — fixed interval (wall clock)
 *
 * Run: java concurrency.ScheduledExecutorServiceDemo
 */
public class ScheduledExecutorServiceDemo {

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        scheduler.schedule(() ->
                System.out.println("one-shot after 1s: " + Thread.currentThread().getName()),
                1, TimeUnit.SECONDS);

        scheduler.scheduleAtFixedRate(() ->
                System.out.println("fixed-rate tick " + System.nanoTime()),
                0, 500, TimeUnit.MILLISECONDS);

        Thread.sleep(2500);
        scheduler.shutdown();
        scheduler.awaitTermination(2, TimeUnit.SECONDS);
        System.out.println("scheduler stopped");
    }
}
