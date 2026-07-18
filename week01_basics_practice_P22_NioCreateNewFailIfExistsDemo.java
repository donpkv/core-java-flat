import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * Practice 22 — NIO: CREATE_NEW (fail if file already exists)
 *
 * CREATE_NEW → create only when file does NOT exist
 *              throws FileAlreadyExistsException if file is there
 *
 * Use case: guarantee a brand-new file, never overwrite by accident
 */
public class P22_NioCreateNewFailIfExistsDemo {

    public static void main(String[] args) throws Exception {
        Path path = Path.of("week01_practice/data/mode_create_new.txt");
        Files.createDirectories(path.getParent());
        Files.deleteIfExists(path);

        Files.writeString(path, "first-create-ok\n", StandardOpenOption.CREATE_NEW);
        System.out.println("1st CREATE_NEW: success");

        try {
            Files.writeString(path, "should-not-write\n", StandardOpenOption.CREATE_NEW);
            System.out.println("2nd CREATE_NEW: unexpected success");
        } catch (FileAlreadyExistsException ex) {
            System.out.println("2nd CREATE_NEW: FileAlreadyExistsException (expected)");
        }

        System.out.println("File still contains: " + Files.readString(path));
    }
}
