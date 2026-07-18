import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Practice 07 — Bounded thread pool + backpressure (CallerRunsPolicy)
 *
 * Unbounded LinkedBlockingQueue = tasks pile up in memory during spikes.
 * Bounded queue + CallerRunsPolicy = submitter runs task when full → slows ingress.
 */
public class P07_BoundedThreadPoolBackpressure {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                4,
                60L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        for (int i = 1; i <= 15; i++) {
            int taskId = i;
            executor.submit(() -> {
                System.out.println("Processing " + taskId + " on " + Thread.currentThread().getName());
                sleepQuiet(300);
            });
        }

        executor.shutdown();
        executor.awaitTermination(60, TimeUnit.SECONDS);
    }

    static void sleepQuiet(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
