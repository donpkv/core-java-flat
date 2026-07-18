import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

/**
 * Practice 02 — BufferedReader + StringBuilder read loop
 *
 * Same pattern as reading HttpURLConnection.getInputStream(), but from a local file.
 *
 *   while ((line = reader.readLine()) != null) {
 *       response.append(line);
 *   }
 *
 * readLine() returns null at EOF (like read() returns -1 for chars).
 */
public class P02_BufferedReaderStringBuilderReadLoop {

    public static void main(String[] args) throws IOException {
        Path path = Path.of("week06_api_practice/data/sample_oneline_response.txt");

        String body = readAllAsString(path.toString());
        System.out.println("Length: " + body.length());
        System.out.println("Body: " + body);
    }

    static String readAllAsString(String filePath) throws IOException {
        StringBuilder response = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        }

        return response.toString();
    }
}
