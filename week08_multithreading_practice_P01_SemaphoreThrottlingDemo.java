import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Practice 01 — Thread throttling with Semaphore
 *
 * Production use: limit concurrent DB calls, HTTP calls, or CPU-heavy tasks.
 * Only N threads enter critical section at once; others wait.
 */
public class P01_SemaphoreThrottlingDemo {

    private static final int MAX_CONCURRENT = 3;
    private static final Semaphore throttle = new Semaphore(MAX_CONCURRENT);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(10);

        for (int i = 1; i <= 10; i++) {
            int taskId = i;
            pool.submit(() -> callExternalService(taskId));
        }

        pool.shutdown();
        pool.awaitTermination(30, TimeUnit.SECONDS);
    }

    static void callExternalService(int taskId) {
        try {
            throttle.acquire(); // wait if 3 already running
            System.out.println("Task " + taskId + " START (permits left: " + throttle.availablePermits() + ")");
            Thread.sleep(500); // simulate slow IO
            System.out.println("Task " + taskId + " END");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            throttle.release();
        }
    }
}
