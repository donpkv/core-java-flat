/**
 * Practice 02 — Intentional deadlock (for thread dump practice)
 *
 * PRODUCTION TRIAGE (do NOT leave this running in prod):
 *   jcmd <PID> Thread.print > threads_1.txt
 *   sleep 5
 *   jcmd <PID> Thread.print > threads_2.txt
 *
 * Look at bottom of dump for: "Found one Java-level deadlock"
 * Or use fastThread.io / VisualVM on the dump file.
 *
 * Run this class, note PID from jps, capture dumps while it hangs.
 */
public class P02_DeadlockDemoForThreadDump {

    private static final Object lockA = new Object();
    private static final Object lockB = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (lockA) {
                sleepQuiet(100);
                synchronized (lockB) {
                    System.out.println("T1 got both locks");
                }
            }
        }, "worker-t1");

        Thread t2 = new Thread(() -> {
            synchronized (lockB) {
                sleepQuiet(100);
                synchronized (lockA) {
                    System.out.println("T2 got both locks");
                }
            }
        }, "worker-t2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    static void sleepQuiet(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
