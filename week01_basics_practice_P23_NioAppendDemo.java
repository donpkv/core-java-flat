import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * Practice 23 — NIO: APPEND (+ CREATE if missing)
 *
 * StandardOpenOption.APPEND  → write at end, never truncate
 * StandardOpenOption.CREATE  → create file if it does not exist yet
 */
public class P23_NioAppendDemo {

    public static void main(String[] args) throws Exception {
        Path path = Path.of("week01_practice/data/mode_nio_append.txt");
        Files.createDirectories(path.getParent());
        Files.deleteIfExists(path);

        Files.writeString(path, "A\n",
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        Files.writeString(path, "B\n",
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        Files.writeString(path, "C\n",
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        System.out.println("APPEND result:");
        System.out.println(Files.readString(path));
    }
}
