import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

/**
 * Practice 11 — Copy file: Reader on source, Writer on destination
 *
 * SAFE: two different files in one try-with-resources block.
 * Reads:  week01_practice/data/numbers.txt
 * Creates: week01_practice/data/backup.txt
 */
public class P11_CopyFileReaderWriterDemo {

    public static void main(String[] args) throws IOException {
        Path source = Path.of("week01_practice/data/numbers.txt");
        Path dest = Path.of("week01_practice/data/backup.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(source.toFile()));
             BufferedWriter writer = new BufferedWriter(new FileWriter(dest.toFile()))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        }

        System.out.println("Copied " + source + " -> " + dest);
    }
}
