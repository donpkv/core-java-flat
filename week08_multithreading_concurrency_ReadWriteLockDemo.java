package concurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * L02 — ReentrantReadWriteLock: parallel reads, exclusive writes
 *
 * Run: java concurrency.ReadWriteLockDemo
 */
public class ReadWriteLockDemo {

    private final Map<String, String> cache = new HashMap<>();
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    public String read(String key) {
        rwLock.readLock().lock();
        try {
            sleepQuiet(100);
            return cache.get(key);
        } finally {
            rwLock.readLock().unlock();
        }
    }

    public void write(String key, String value) {
        rwLock.writeLock().lock();
        try {
            sleepQuiet(200);
            cache.put(key, value);
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReadWriteLockDemo demo = new ReadWriteLockDemo();
        demo.write("user", "piyush");

        Thread[] readers = new Thread[4];
        for (int i = 0; i < readers.length; i++) {
            readers[i] = new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " read=" + demo.read("user"));
            }, "reader-" + i);
        }

        Thread writer = new Thread(() -> demo.write("user", "updated"), "writer");

        for (Thread r : readers) {
            r.start();
        }
        writer.start();

        for (Thread r : readers) {
            r.join();
        }
        writer.join();
        System.out.println("final: " + demo.read("user"));
    }

    private static void sleepQuiet(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
