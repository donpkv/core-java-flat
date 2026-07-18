import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Practice 20 — FileWriter APPEND (second parameter true)
 *
 * FileWriter(path, true)  → writes at END, keeps existing content
 *
 * Compare with P19 (truncate). File: week01_practice/data/mode_append.txt
 */
public class P20_FileWriterAppendDemo {

    public static void main(String[] args) throws IOException {
        Path path = Path.of("week01_practice/data/mode_append.txt");
        Files.createDirectories(path.getParent());

        try (BufferedWriter w1 = new BufferedWriter(new FileWriter(path.toFile(), false))) {
            w1.write("Line-1");
            w1.newLine();
        }

        try (BufferedWriter w2 = new BufferedWriter(new FileWriter(path.toFile(), true))) {
            w2.write("Line-2-appended");
            w2.newLine();
        }

        System.out.println("File content (both lines kept):");
        System.out.println(Files.readString(path));
    }
}
