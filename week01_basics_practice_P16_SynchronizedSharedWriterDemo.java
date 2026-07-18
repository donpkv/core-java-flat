import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Practice 16 — SAFE (simple): one shared BufferedWriter + synchronized block
 *
 * All threads use the same writer; each write is inside synchronized(lock).
 * Output: week01_practice/data/thread_safe_sync_log.txt (15 clean lines)
 */
public class P16_SynchronizedSharedWriterDemo {

    private static final Path LOG = Path.of("week01_practice/data/thread_safe_sync_log.txt");
    private static final Object FILE_LOCK = new Object();
    private static BufferedWriter sharedWriter;

    public static void main(String[] args) throws Exception {
        Files.deleteIfExists(LOG);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG.toFile(), true))) {
            sharedWriter = writer;

            Thread t1 = new Thread(() -> writeLines("A", 5), "writer-A");
            Thread t2 = new Thread(() -> writeLines("B", 5), "writer-B");
            Thread t3 = new Thread(() -> writeLines("C", 5), "writer-C");

            t1.start();
            t2.start();
            t3.start();
            t1.join();
            t2.join();
            t3.join();
        }

        System.out.println("Wrote (synchronized): " + LOG.toAbsolutePath());
        System.out.println("Expect exactly 15 lines, no broken text.");
    }

    static void writeLines(String prefix, int count) {
        for (int i = 1; i <= count; i++) {
            synchronized (FILE_LOCK) {
                try {
                    sharedWriter.write(prefix + "-line-" + i);
                    sharedWriter.newLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
