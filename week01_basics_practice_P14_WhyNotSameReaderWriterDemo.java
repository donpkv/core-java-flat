import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Practice 14 — Why NOT Reader + Writer on same file simultaneously
 *
 * If you open FileWriter first on same path, it TRUNCATES file to empty.
 * Then BufferedReader reads nothing.
 *
 * This demo uses a temp copy so we don't destroy real data.
 */
public class P14_WhyNotSameReaderWriterDemo {

    public static void main(String[] args) throws IOException {
        Path original = Path.of("week01_practice/data/numbers.txt");
        Path temp = Path.of("week01_practice/data/temp_trap.txt");
        Files.copy(original, temp, java.nio.file.StandardCopyOption.REPLACE_EXISTING);

        System.out.println("=== WRONG pattern (writer opens first → truncates) ===");
        demonstrateWrongPattern(temp);

        Files.copy(original, temp, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
        System.out.println("\n=== RIGHT pattern (read all, close, then write) ===");
        demonstrateRightPattern(temp);

        Files.deleteIfExists(temp);
    }

    static void demonstrateWrongPattern(Path path) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile()));
             BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {

            // Writer already truncated file — reader sees empty or partial data
            String line = reader.readLine();
            System.out.println("Read after writer open: " + (line == null ? "(null/empty)" : line));
        }
    }

    static void demonstrateRightPattern(Path path) throws IOException {
        String firstLine;

        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
            firstLine = reader.readLine();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile()))) {
            writer.write("Sum=30");
            writer.newLine();
        }

        System.out.println("Read before write: " + firstLine);
        System.out.println("File safely overwritten after reader closed");
    }
}
