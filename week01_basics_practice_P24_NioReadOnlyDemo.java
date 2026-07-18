import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * Practice 24 — NIO: READ only
 *
 * StandardOpenOption.READ → open for reading only
 * No WRITE / APPEND / TRUNCATE options → cannot write via this open
 *
 * Reads: week01_practice/data/numbers.txt
 */
public class P24_NioReadOnlyDemo {

    public static void main(String[] args) throws Exception {
        Path path = Path.of("week01_practice/data/numbers.txt");

        try (BufferedReader reader = Files.newBufferedReader(path, StandardOpenOption.READ)) {
            System.out.println("READ-only open — first line: " + reader.readLine());
        }

        System.out.println("""
                
                READ-only means:
                  - Safe read, no accidental truncate
                  - To write, open separately with WRITE options (P19/P21)
                  - Files.isReadable(path) / isWritable(path) check permissions
                """);
    }
}
