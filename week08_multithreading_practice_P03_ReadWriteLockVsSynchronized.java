import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Practice 03 — Fix read-heavy bottleneck
 *
 * synchronized on get+put blocks all readers when one writer exists.
 * ReentrantReadWriteLock: many readers in parallel, writers exclusive.
 */
public class P03_ReadWriteLockVsSynchronized {

    private final Map<String, String> cache = new HashMap<>();
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    public synchronized String getSlow(String key) {
        return cache.get(key);
    }

    public synchronized void putSlow(String key, String value) {
        cache.put(key, value);
    }

    public String getFast(String key) {
        rwLock.readLock().lock();
        try {
            return cache.get(key);
        } finally {
            rwLock.readLock().unlock();
        }
    }

    public void putFast(String key, String value) {
        rwLock.writeLock().lock();
        try {
            cache.put(key, value);
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        P03_ReadWriteLockVsSynchronized demo = new P03_ReadWriteLockVsSynchronized();
        demo.putFast("user:1", "Alice");

        Runnable reader = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " read: " + demo.getFast("user:1"));
            }
        };

        Thread r1 = new Thread(reader, "reader-1");
        Thread r2 = new Thread(reader, "reader-2");
        r1.start();
        r2.start();
        r1.join();
        r2.join();
    }
}
