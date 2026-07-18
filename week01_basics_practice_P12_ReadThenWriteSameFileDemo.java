import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Practice 12 — Same file: READ fully, CLOSE, then WRITE
 *
 * WRONG: open Reader + Writer on same path at once (writer truncates file).
 * RIGHT: read all lines into memory → close reader → open writer → overwrite file.
 *
 * Reads/writes: week01_practice/data/scores.txt (5, 10, 15 → 15, 20, 25 after +10)
 */
public class P12_ReadThenWriteSameFileDemo {

    public static void main(String[] args) throws IOException {
        Path path = Path.of("week01_practice/data/scores.txt");

        List<String> updated = new ArrayList<>();

        // STEP 1 — read (writer NOT open yet)
        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }
                int score = Integer.parseInt(line);
                updated.add(String.valueOf(score + 10));
            }
        }

        // STEP 2 — write (reader already closed)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile()))) {
            for (String line : updated) {
                writer.write(line);
                writer.newLine();
            }
        }

        System.out.println("Updated scores written to " + path.toAbsolutePath());
        System.out.println("New values: " + updated);
    }
}
