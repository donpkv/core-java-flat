import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Practice 10 — Modern NIO Files API (Java 11+)
 * One-liner read/write for small text files.
 */
public class P10_FilesModernReadWrite {

    public static void main(String[] args) throws IOException {
        Path input = Path.of("week01_practice/data/numbers.txt");
        Path output = Path.of("week01_practice/data/result.txt");

        List<String> lines = Files.readAllLines(input);
        int a = Integer.parseInt(lines.get(0).trim());
        int b = Integer.parseInt(lines.get(1).trim());

        Files.writeString(output, "Sum = " + (a + b));
        System.out.println("Written: " + output.toAbsolutePath());
        System.out.println("Content: " + Files.readString(output));
    }
}
