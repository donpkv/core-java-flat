package threads;

/**
 * D01 — Daemon basics
 *
 * Run: from core_java_programs/
 *   javac threads/DaemonBasicsDemo.java
 *   java threads.DaemonBasicsDemo
 *
 * Observe: daemon prints ticks while main sleeps, then JVM exits and daemon stops mid-loop.
 */
public class DaemonBasicsDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread daemon = new Thread(() -> {
            int tick = 0;
            while (true) {
                System.out.println("daemon tick " + tick++);
                sleep(500);
            }
        }, "basics-daemon");

        daemon.setDaemon(true); // must be BEFORE start()
        System.out.println("isDaemon? " + daemon.isDaemon());
        daemon.start();

        System.out.println("main: sleeping 2 seconds...");
        Thread.sleep(2000);
        System.out.println("main: done — JVM exits; daemon is killed automatically");
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " interrupted, stopping");
        }
    }
}
