import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Practice 19 — FileWriter TRUNCATE (default overwrite)
 *
 * FileWriter(path)           → if file exists, content cleared, write from start
 * FileWriter(path, false)    → same as above
 *
 * Creates/overwrites: week01_practice/data/mode_truncate.txt
 */
public class P19_FileWriterTruncateDemo {

    public static void main(String[] args) throws IOException {
        Path path = Path.of("week01_practice/data/mode_truncate.txt");
        Files.createDirectories(path.getParent());

        try (BufferedWriter w1 = new BufferedWriter(new FileWriter(path.toFile()))) {
            w1.write("FIRST-RUN-CONTENT");
            w1.newLine();
        }
        System.out.println("After 1st write: " + Files.readString(path));

        // Second open — TRUNCATES (default), old content gone
        try (BufferedWriter w2 = new BufferedWriter(new FileWriter(path.toFile(), false))) {
            w2.write("SECOND-RUN-ONLY");
            w2.newLine();
        }
        System.out.println("After 2nd write (truncate): " + Files.readString(path));
        System.out.println("FIRST-RUN-CONTENT is gone — file overwritten from start.");
    }
}
