import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Practice 18 — Threads + same file: read phase then write phase under ONE lock
 *
 * Two worker threads each increment every number in shared_counter.txt by 1.
 * Lock ensures: no reader open while writer open; no concurrent read/write.
 *
 * File: week01_practice/data/shared_counter.txt  (starts as: 1, 2, 3)
 */
public class P18_LockedReadWriteSameFileDemo {

    private static final Path FILE = Path.of("week01_practice/data/shared_counter.txt");
    private static final Object FILE_LOCK = new Object();

    public static void main(String[] args) throws Exception {
        resetFile();

        Thread t1 = new Thread(() -> readIncrementWrite(), "worker-1");
        Thread t2 = new Thread(() -> readIncrementWrite(), "worker-2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Final file content:");
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE.toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("  " + line);
            }
        }
        System.out.println("Each worker read→increment→write under lock (ran twice total).");
    }

    static void resetFile() throws IOException {
        try (BufferedWriter w = new BufferedWriter(new FileWriter(FILE.toFile()))) {
            w.write("1");
            w.newLine();
            w.write("2");
            w.newLine();
            w.write("3");
            w.newLine();
        }
    }

    static void readIncrementWrite() {
        synchronized (FILE_LOCK) {
            List<Integer> values = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(FILE.toFile()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    line = line.trim();
                    if (!line.isEmpty()) {
                        values.add(Integer.parseInt(line) + 1);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE.toFile()))) {
                for (int v : values) {
                    writer.write(String.valueOf(v));
                    writer.newLine();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
