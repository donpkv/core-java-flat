/**
 * Practice 09 — Lock contention: many threads BLOCKED on one monitor
 *
 * Simulate production symptom: latency spike, CPU not 100%, many BLOCKED threads.
 *
 * Capture dumps while running:
 *   jcmd <PID> Thread.print
 *
 * In dump, search for:
 *   State: BLOCKED (on object monitor)
 *   stack trace pointing to increment() synchronized block below
 */
public class P09_LockContentionBlockedThreadsDemo {

    private static final Object HOT_LOCK = new Object();
    private static int sharedCounter = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread[] workers = new Thread[20];
        for (int i = 0; i < workers.length; i++) {
            workers[i] = new Thread(P09_LockContentionBlockedThreadsDemo::increment, "worker-" + i);
            workers[i].start();
        }
        for (Thread w : workers) {
            w.join();
        }
        System.out.println("Final counter: " + sharedCounter);
    }

    static void increment() {
        for (int i = 0; i < 1000; i++) {
            synchronized (HOT_LOCK) {
                sharedCounter++;
                // tiny work inside lock = bottleneck
            }
        }
    }
}
