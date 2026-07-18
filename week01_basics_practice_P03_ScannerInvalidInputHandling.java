import java.util.Scanner;

/**
 * Practice 03 — Scanner edge case: invalid input
 * User types "abc" when int expected → handle without crash.
 */
public class P03_ScannerInvalidInputHandling {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int age = readPositiveInt(sc, "Enter your age: ");
            System.out.println("Valid age entered: " + age);
        }
    }

    static int readPositiveInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (!sc.hasNextInt()) {
                System.out.println("Invalid! Please enter a whole number.");
                sc.next(); // discard bad token e.g. "abc"
                continue;
            }
            int value = sc.nextInt();
            if (value <= 0) {
                System.out.println("Edge case: age must be > 0. Try again.");
                continue;
            }
            return value;
        }
    }
}
