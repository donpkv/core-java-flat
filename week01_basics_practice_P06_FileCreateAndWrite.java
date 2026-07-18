import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Practice 06 — Create file and write lines
 * Creates: week01_practice/data/output.txt
 */
public class P06_FileCreateAndWrite {

    public static void main(String[] args) throws IOException {
        Path path = Path.of("week01_practice/data/output.txt");

        // ensure parent folder exists
        Files.createDirectories(path.getParent());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile()))) {
            writer.write("Line 1: Hello");
            writer.newLine();
            writer.write("Line 2: Java IO");
            writer.newLine();
            writer.write("Line 3: Practice");
            writer.newLine();
        }

        System.out.println("File written: " + path.toAbsolutePath());
    }
}
