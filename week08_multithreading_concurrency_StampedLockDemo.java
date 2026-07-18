package concurrency;

import java.util.concurrent.locks.StampedLock;

/**
 * L03 — StampedLock: optimistic read (Java 8+)
 *
 * Good for read-heavy maps when reads vastly outnumber writes.
 *
 * Run: java concurrency.StampedLockDemo
 */
public class StampedLockDemo {

    private double x;
    private double y;
    private final StampedLock lock = new StampedLock();

    void write(double newX, double newY) {
        long stamp = lock.writeLock();
        try {
            x = newX;
            y = newY;
        } finally {
            lock.unlockWrite(stamp);
        }
    }

    double[] read() {
        long stamp = lock.tryOptimisticRead();
        double curX = x;
        double curY = y;

        if (!lock.validate(stamp)) {
            stamp = lock.readLock();
            try {
                curX = x;
                curY = y;
            } finally {
                lock.unlockRead(stamp);
            }
        }
        return new double[]{curX, curY};
    }

    public static void main(String[] args) throws InterruptedException {
        StampedLockDemo point = new StampedLockDemo();
        point.write(1.0, 2.0);

        Thread reader = new Thread(() -> {
            double[] coords = point.read();
            System.out.println("read optimistic: x=" + coords[0] + " y=" + coords[1]);
        }, "reader");

        Thread writer = new Thread(() -> point.write(9.0, 9.0), "writer");

        reader.start();
        writer.start();
        reader.join();
        writer.join();

        double[] after = point.read();
        System.out.println("after write: x=" + after[0] + " y=" + after[1]);
    }
}
