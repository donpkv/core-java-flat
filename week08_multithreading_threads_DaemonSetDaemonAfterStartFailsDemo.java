package threads;

/**
 * D06 — setDaemon(true) must be called BEFORE start()
 *
 * Run: java threads.DaemonSetDaemonAfterStartFailsDemo
 */
public class DaemonSetDaemonAfterStartFailsDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> sleep(2000), "worker");

        t.start();
        System.out.println("thread started — now trying setDaemon(true)...");

        try {
            t.setDaemon(true);
            System.out.println("unexpected: setDaemon succeeded");
        } catch (IllegalThreadStateException ex) {
            System.out.println("expected: IllegalThreadStateException — cannot change daemon status after start");
        }

        t.join();
        System.out.println("main: worker finished (user thread kept JVM alive until join returned)");
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
