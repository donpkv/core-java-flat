import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Practice 09 — Scanner reading from FILE (not keyboard)
 * Same Scanner API, different source.
 */
public class P09_ScannerReadFileDemo {

    public static void main(String[] args) {
        File file = new File("week01_practice/data/names.txt");

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (!line.isEmpty()) {
                    System.out.println("Read: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Edge case: " + e.getMessage());
        }
    }
}
