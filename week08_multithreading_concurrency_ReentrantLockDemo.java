package concurrency;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock vs synchronized:
 * - explicit lock/unlock (use try/finally)
 * - can use tryLock, fair ordering, Condition variables
 */
public class ReentrantLockDemo {

    private static final ReentrantLock lock = new ReentrantLock(true); // fair lock
    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                increment();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Counter (expected 2000): " + counter);
    }

    static void increment() {
        lock.lock();
        try {
            counter++;
        } finally {
            lock.unlock();
        }
    }
}
