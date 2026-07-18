package concurrency;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch: one or more threads wait until counter reaches zero.
 * Example: main waits for all worker threads to finish startup.
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        int workers = 3;
        CountDownLatch latch = new CountDownLatch(workers);

        for (int i = 1; i <= workers; i++) {
            int id = i;
            new Thread(() -> {
                System.out.println("Worker " + id + " starting...");
                sleep(500 * id);
                System.out.println("Worker " + id + " ready");
                latch.countDown();
            }).start();
        }

        System.out.println("Main waiting for all workers...");
        latch.await();
        System.out.println("All workers ready — proceed!");
    }

    static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
