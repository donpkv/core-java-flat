import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Practice 15 — UNSAFE: each thread opens its own BufferedWriter on same file
 *
 * BufferedWriter is NOT thread-safe. Output may be garbled / lines mixed.
 * Run multiple times — file content is unpredictable.
 *
 * Output: week01_practice/data/thread_unsafe_log.txt
 */
public class P15_UnsafeMultiThreadWriterDemo {

    private static final Path LOG = Path.of("week01_practice/data/thread_unsafe_log.txt");

    public static void main(String[] args) throws Exception {
        Files.deleteIfExists(LOG);

        Thread t1 = new Thread(() -> writeLines("A", 5), "writer-A");
        Thread t2 = new Thread(() -> writeLines("B", 5), "writer-B");
        Thread t3 = new Thread(() -> writeLines("C", 5), "writer-C");

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();

        System.out.println("Wrote (unsafely): " + LOG.toAbsolutePath());
        System.out.println("Open file — lines may be broken/mixed. Do NOT use this pattern.");
    }

    static void writeLines(String prefix, int count) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG.toFile(), true))) {
            for (int i = 1; i <= count; i++) {
                writer.write(prefix + "-line-" + i);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
