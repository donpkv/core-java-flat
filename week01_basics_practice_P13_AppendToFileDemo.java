import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

/**
 * Practice 13 — Append to file (do not truncate)
 *
 * FileWriter(path, true)  → append mode, adds at end
 * FileWriter(path)        → overwrites from start (default)
 *
 * Creates/appends: week01_practice/data/app.log
 */
public class P13_AppendToFileDemo {

    public static void main(String[] args) throws IOException {
        Path log = Path.of("week01_practice/data/app.log");

        appendLine(log, "App started");
        appendLine(log, "User logged in");
        appendLine(log, "Request processed");

        System.out.println("Appended 3 lines to " + log.toAbsolutePath());
        System.out.println("Run again — lines accumulate (not overwritten)");
    }

    static void appendLine(Path path, String message) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(path.toFile(), true))) { // true = APPEND
            writer.write(message);
            writer.newLine();
        }
    }
}
