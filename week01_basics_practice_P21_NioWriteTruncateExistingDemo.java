import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * Practice 21 — NIO: CREATE + WRITE + TRUNCATE_EXISTING (overwrite)
 *
 * StandardOpenOption controls behavior (more control than FileWriter).
 *
 * TRUNCATE_EXISTING → empty file if it already exists, then write
 * CREATE            → create file if missing
 */
public class P21_NioWriteTruncateExistingDemo {

    public static void main(String[] args) throws IOException {
        Path path = Path.of("week01_practice/data/mode_nio_truncate.txt");
        Files.createDirectories(path.getParent());

        Files.writeString(path, "OLD-DATA\n", StandardOpenOption.CREATE, StandardOpenOption.WRITE);

        Files.writeString(path, "NEW-DATA-ONLY\n",
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE,
                StandardOpenOption.TRUNCATE_EXISTING);

        System.out.println("After TRUNCATE_EXISTING write:");
        System.out.println(Files.readString(path));
    }
}
