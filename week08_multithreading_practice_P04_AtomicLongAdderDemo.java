import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

/**
 * Practice 04 — Lock-free counters (CAS atomics)
 *
 * synchronized increment = threads BLOCK on monitor.
 * AtomicInteger = CAS retry, good for low contention.
 * LongAdder = stripes across cells, best for HIGH contention (many threads).
 */
public class P04_AtomicLongAdderDemo {

    private int syncCounter = 0;
    private final AtomicInteger atomicCounter = new AtomicInteger(0);
    private final LongAdder longAdder = new LongAdder();

    synchronized void incrementSync() {
        syncCounter++;
    }

    void incrementAtomic() {
        atomicCounter.incrementAndGet();
    }

    void incrementLongAdder() {
        longAdder.increment();
    }

    public static void main(String[] args) throws InterruptedException {
        P04_AtomicLongAdderDemo demo = new P04_AtomicLongAdderDemo();
        int threads = 10;
        int loops = 10_000;

        runParallel(threads, loops, demo::incrementSync);
        runParallel(threads, loops, demo::incrementAtomic);
        runParallel(threads, loops, demo::incrementLongAdder);

        System.out.println("syncCounter   (expect 100000): " + demo.syncCounter);
        System.out.println("atomicCounter (expect 100000): " + demo.atomicCounter.get());
        System.out.println("longAdder     (expect 100000): " + demo.longAdder.sum());
    }

    static void runParallel(int threads, int loops, Runnable task) throws InterruptedException {
        Thread[] arr = new Thread[threads];
        for (int i = 0; i < threads; i++) {
            arr[i] = new Thread(() -> {
                for (int j = 0; j < loops; j++) {
                    task.run();
                }
            });
            arr[i].start();
        }
        for (Thread t : arr) {
            t.join();
        }
    }
}
