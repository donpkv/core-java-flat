import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * Practice 25 — NIO: WRITE without CREATE (fail if file missing)
 *
 * Only StandardOpenOption.WRITE → file MUST already exist
 * If missing → NoSuchFileException (or FileNotFoundException on older code paths)
 *
 * Opposite of P06/P21 where CREATE creates missing file.
 */
public class P25_NioWriteFailIfMissingDemo {

    public static void main(String[] args) throws Exception {
        Path existing = Path.of("week01_practice/data/mode_must_exist.txt");
        Path missing = Path.of("week01_practice/data/does_not_exist_yet.txt");
        Files.createDirectories(existing.getParent());
        Files.writeString(existing, "seed\n"); // ensure file exists
        Files.deleteIfExists(missing);

        Files.writeString(existing, "updated\n", StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
        System.out.println("WRITE to existing mode_must_exist.txt: OK → " + Files.readString(existing).trim());

        try {
            Files.writeString(missing, "data\n", StandardOpenOption.WRITE);
            System.out.println("WRITE to missing file: unexpected success");
        } catch (NoSuchFileException ex) {
            System.out.println("WRITE without CREATE on missing file: NoSuchFileException (expected)");
        }

        System.out.println("""
                
                Cheat sheet:
                  CREATE + WRITE              → create if missing, overwrite if exists
                  CREATE + WRITE + TRUNCATE   → same, explicitly empty first (P21)
                  CREATE_NEW                  → new file only, fail if exists (P22)
                  CREATE + APPEND             → add at end, create if missing (P23)
                  READ                        → read only (P24)
                  WRITE only                  → must exist (P25)
                  FileWriter(path)            → truncate/overwrite (P19)
                  FileWriter(path, true)      → append (P20)
                """);
    }
}
