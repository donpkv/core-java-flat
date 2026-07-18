package concurrency;

/**
 * synchronized vs ReentrantLock side-by-side concept demo.
 * synchronized: simpler, built-in, automatic release
 * ReentrantLock: more control (tryLock, fair, Conditions)
 */
public class SynchronizedVsLockDemo {

    private static int syncCounter = 0;
    private static final Object monitor = new Object();

    public static void main(String[] args) throws InterruptedException {
        Runnable syncTask = () -> {
            for (int i = 0; i < 1000; i++) {
                synchronized (monitor) {
                    syncCounter++;
                }
            }
        };

        Thread t1 = new Thread(syncTask);
        Thread t2 = new Thread(syncTask);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("synchronized counter (expected 2000): " + syncCounter);
        System.out.println("See ReentrantLockDemo for explicit lock version");
    }
}
