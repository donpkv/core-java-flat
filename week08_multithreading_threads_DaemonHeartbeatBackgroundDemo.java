package threads;

/**
 * D04 — GOOD use: daemon heartbeat while main does real work
 *
 * Daemon = low-priority background helper (metrics, watchdog, progress ping).
 * Main = user thread = the actual job JVM must wait for.
 */
public class DaemonHeartbeatBackgroundDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread heartbeat = new Thread(() -> {
            int beat = 1;
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("[heartbeat] alive, beat=" + beat++);
                sleep(1000);
            }
            System.out.println("[heartbeat] stopped cleanly");
        }, "heartbeat-daemon");

        heartbeat.setDaemon(true);
        heartbeat.start();

        System.out.println("main: processing batch job...");
        for (int batch = 1; batch <= 5; batch++) {
            System.out.println("main: batch " + batch + "/5 complete");
            sleep(800);
        }

        System.out.println("main: job done — JVM exits, heartbeat daemon stops");
        // Optional polite stop before exit (daemon would be killed anyway):
        heartbeat.interrupt();
        Thread.sleep(100);
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
