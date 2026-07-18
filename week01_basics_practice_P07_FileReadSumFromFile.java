import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Practice 07 — Read numbers from file and print sum
 * Reads: week01_practice/data/numbers.txt (contains 10 and 20)
 */
public class P07_FileReadSumFromFile {

    public static void main(String[] args) throws IOException {
        Path path = Path.of("week01_practice/data/numbers.txt");

        if (!Files.exists(path)) {
            System.out.println("Edge case: file not found -> " + path.toAbsolutePath());
            return;
        }

        int sum = 0;
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue; // skip blank lines
                }
                sum += Integer.parseInt(line);
                count++;
            }
        }

        System.out.println("Numbers read: " + count);
        System.out.println("Sum = " + sum);
    }
}
