package concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * L01 — ReentrantLock: tryLock and tryLock(timeout)
 *
 * Run: java concurrency.ReentrantLockTryLockDemo
 */
public class ReentrantLockTryLockDemo {

    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread holder = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("holder: acquired lock, sleeping 2s");
                sleepQuiet(2000);
            } finally {
                lock.unlock();
                System.out.println("holder: released lock");
            }
        }, "holder");

        Thread tryOnce = new Thread(() -> {
            System.out.println("tryOnce: tryLock() → " + lock.tryLock());
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }, "tryOnce");

        Thread tryWait = new Thread(() -> {
            try {
                boolean got = lock.tryLock(1500, TimeUnit.MILLISECONDS);
                System.out.println("tryWait: tryLock(1500ms) → " + got);
                if (got) {
                    lock.unlock();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "tryWait");

        holder.start();
        sleepQuiet(100);
        tryOnce.start();
        tryWait.start();

        holder.join();
        tryOnce.join();
        tryWait.join();
    }

    private static void sleepQuiet(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
