import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Practice 05 — BufferedReader edge cases
 * - empty line
 * - spaces only
 * - invalid number format
 */
public class P05_BufferedReaderParseEdgeCases {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int age = readIntWithValidation(reader);
            System.out.println("Accepted age: " + age);
        }
    }

    static int readIntWithValidation(BufferedReader reader) throws IOException {
        while (true) {
            System.out.print("Enter age: ");
            String line = reader.readLine();

            if (line == null) {
                throw new IOException("No input (stream closed).");
            }

            line = line.trim();
            if (line.isEmpty()) {
                System.out.println("Edge case: empty input. Try again.");
                continue;
            }

            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException ex) {
                System.out.println("Edge case: '" + line + "' is not a valid integer.");
            }
        }
    }
}
