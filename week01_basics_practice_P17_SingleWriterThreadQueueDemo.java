import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Practice 17 — SAFE (production style): many producers, ONE writer thread
 *
 * Producer threads put lines in BlockingQueue.
 * Single background thread owns the only BufferedWriter.
 *
 * Output: week01_practice/data/thread_queue_log.txt
 */
public class P17_SingleWriterThreadQueueDemo {

    private static final Path LOG = Path.of("week01_practice/data/thread_queue_log.txt");
    private static final BlockingQueue<String> queue = new ArrayBlockingQueue<>(100);
    private static final String POISON = "__STOP__";

    public static void main(String[] args) throws Exception {
        Files.deleteIfExists(LOG);

        Thread writerThread = new Thread(P17_SingleWriterThreadQueueDemo::drainQueueToFile, "file-writer");
        writerThread.start();

        Thread t1 = new Thread(() -> produce("A", 5), "producer-A");
        Thread t2 = new Thread(() -> produce("B", 5), "producer-B");
        Thread t3 = new Thread(() -> produce("C", 5), "producer-C");

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();

        queue.put(POISON);
        writerThread.join();

        System.out.println("Wrote (queue + single writer): " + LOG.toAbsolutePath());
        System.out.println("Best pattern for multi-thread logging to one file.");
    }

    static void produce(String prefix, int count) {
        try {
            for (int i = 1; i <= count; i++) {
                queue.put(prefix + "-line-" + i);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    static void drainQueueToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG.toFile(), true))) {
            while (true) {
                String line = queue.poll(2, TimeUnit.SECONDS);
                if (line == null) {
                    continue;
                }
                if (POISON.equals(line)) {
                    break;
                }
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException | InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
