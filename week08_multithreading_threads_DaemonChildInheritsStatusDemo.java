package threads;

/**
 * D07 — Child thread inherits daemon status from parent that created it
 *
 * Case A: daemon parent → daemon child → JVM exits when main ends (child cut off)
 * Case B: user parent → user child → JVM waits for child even if main ended
 *
 * Run: java threads.DaemonChildInheritsStatusDemo
 */
public class DaemonChildInheritsStatusDemo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Case A: daemon parent spawns child ===");
        runDaemonParentCase();

        System.out.println();
        System.out.println("=== Case B: user parent spawns child ===");
        runUserParentCase();
    }

    private static void runDaemonParentCase() throws InterruptedException {
        Thread daemonParent = new Thread(() -> {
            Thread child = new Thread(() -> {
                for (int i = 1; i <= 10; i++) {
                    System.out.println("daemon-child step " + i + " isDaemon=" + Thread.currentThread().isDaemon());
                    sleep(300);
                }
                System.out.println("daemon-child FINISHED (rarely printed)");
            }, "daemon-child");

            System.out.println("daemon-parent creating child, child.isDaemon will be true");
            child.start();
            sleep(100); // parent exits quickly; child is daemon too
        }, "daemon-parent");

        daemonParent.setDaemon(true);
        daemonParent.start();
        Thread.sleep(500);
        System.out.println("main: done after 500ms — daemon parent+child abandoned");
    }

    private static void runUserParentCase() throws InterruptedException {
        Thread userParent = new Thread(() -> {
            Thread child = new Thread(() -> {
                for (int i = 1; i <= 3; i++) {
                    System.out.println("user-child step " + i + " isDaemon=" + Thread.currentThread().isDaemon());
                    sleep(400);
                }
                System.out.println("user-child FINISHED");
            }, "user-child");

            System.out.println("user-parent creating child, child.isDaemon will be false");
            child.start();
            try {
                child.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "user-parent");

        userParent.start();
        userParent.join();
        System.out.println("main: user parent waited for user child — clean shutdown");
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
