import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Practice 04 — BufferedReader from keyboard
 * Everything read as String → parse manually.
 */
public class P04_BufferedReaderKeyboardDemo {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter name: ");
            String name = reader.readLine();

            System.out.print("Enter age: ");
            int age = Integer.parseInt(reader.readLine().trim());

            System.out.println("Hello " + name.trim() + ", age " + age);
        }
    }
}
