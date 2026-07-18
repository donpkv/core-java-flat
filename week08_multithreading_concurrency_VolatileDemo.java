package concurrency;

/**
 * volatile guarantees visibility across threads (not atomicity for compound ops).
 * Without volatile, reader thread may see stale value forever.
 */
public class VolatileDemo {

    private static volatile boolean running = true;
    private static int nonVolatileCounter = 0;
    private static volatile int volatileCounter = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread reader = new Thread(() -> {
            while (running) {
                // busy wait until running = false
            }
            System.out.println("Reader stopped — saw running = false");
        });

        Thread writer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                nonVolatileCounter++;
                volatileCounter++;
            }
            running = false; // volatile write visible to reader
        });

        reader.start();
        Thread.sleep(100);
        writer.start();
        reader.join();
        writer.join();

        System.out.println("nonVolatileCounter: " + nonVolatileCounter);
        System.out.println("volatileCounter: " + volatileCounter);
    }
}
