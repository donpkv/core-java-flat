package threads;

/**
 * D02 — User (non-daemon) thread keeps JVM alive
 *
 * main ends immediately but JVM waits until user-worker finishes all 5 steps (~2.5s).
 * Compare with DaemonDoesNotKeepJvmAliveDemo.
 */
public class DaemonUserThreadKeepsJvmAliveDemo {

    public static void main(String[] args) {
        Thread userWorker = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("user-worker step " + i);
                sleep(500);
            }
            System.out.println("user-worker FINISHED");
        }, "user-worker");

        System.out.println("isDaemon? " + userWorker.isDaemon()); // false by default
        userWorker.start();

        System.out.println("main: line finished — JVM still runs until user-worker ends");
        // no join() — main thread dies but JVM waits for non-daemon user-worker
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
