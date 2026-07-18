package threads;

/**
 * D03 — Daemon does NOT keep JVM alive
 *
 * Daemon plans 20 steps (10s) but main exits instantly.
 * You will see only a few daemon lines — then program ends.
 */
public class DaemonDoesNotKeepJvmAliveDemo {

    public static void main(String[] args) {
        Thread daemonWorker = new Thread(() -> {
            for (int i = 1; i <= 20; i++) {
                System.out.println("daemon-worker step " + i);
                sleep(500);
            }
            System.out.println("daemon-worker FINISHED (you rarely see this)");
        }, "daemon-worker");

        daemonWorker.setDaemon(true);
        daemonWorker.start();

        System.out.println("main: done — JVM exits even though daemon wanted 20 more steps");
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
