package threads;

/**
 * D05 — BAD pattern: put your whole app in a daemon thread
 *
 * Main exits in 500ms. "Real work" in daemon is cut off — do NOT model your app this way.
 * Use a normal user thread + join() for primary work.
 */
public class DaemonWrongPatternDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread appInDaemon = new Thread(() -> {
            System.out.println("daemon-app: starting important work (needs 5 seconds)...");
            for (int i = 1; i <= 10; i++) {
                System.out.println("daemon-app: step " + i);
                sleep(500);
            }
            System.out.println("daemon-app: ALL DONE (usually never printed)");
        }, "daemon-app");

        appInDaemon.setDaemon(true);
        appInDaemon.start();

        System.out.println("main: exiting in 500ms — daemon work will be abandoned");
        Thread.sleep(500);
        System.out.println("main: goodbye");
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
