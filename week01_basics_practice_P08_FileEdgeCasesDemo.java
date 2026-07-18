import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Practice 08 — File edge cases hands-on
 * 1) missing file
 * 2) empty file
 * 3) file with blank lines
 */
public class P08_FileEdgeCasesDemo {

    public static void main(String[] args) {
        demoMissingFile();
        demoEmptyFile();
        demoBlankLines();
    }

    static void demoMissingFile() {
        Path missing = Path.of("week01_practice/data/no_such_file.txt");
        System.out.println("--- Missing file ---");
        if (!Files.exists(missing)) {
            System.out.println("Handled: file does not exist.");
        }
    }

    static void demoEmptyFile() {
        Path empty = Path.of("week01_practice/data/empty.txt");
        System.out.println("--- Empty file ---");
        try {
            List<String> lines = Files.readAllLines(empty);
            if (lines.isEmpty() || lines.stream().allMatch(String::isBlank)) {
                System.out.println("Handled: file is empty.");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void demoBlankLines() {
        Path names = Path.of("week01_practice/data/names.txt");
        System.out.println("--- File with blank line ---");
        try (BufferedReader br = new BufferedReader(new FileReader(names.toFile()))) {
            String line;
            int lineNo = 0;
            while ((line = br.readLine()) != null) {
                lineNo++;
                if (line.isBlank()) {
                    System.out.println("Line " + lineNo + ": [blank] skipped");
                    continue;
                }
                System.out.println("Line " + lineNo + ": " + line.trim());
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
