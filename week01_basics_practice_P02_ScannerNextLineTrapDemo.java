import java.util.Scanner;

/**
 * Practice 02 — nextInt() + nextLine() trap
 *
 * Try WRONG way first (uncomment wrongDemo), then run correctDemo.
 * Edge case: leftover newline makes name empty.
 */
public class                                                                              P02_ScannerNextLineTrapDemo {

    public static void main(String[] args) {
        System.out.println("=== CORRECT demo ===");
        correctDemo();

        // Uncomment to see the bug:
        // System.out.println("\n=== WRONG demo ===");
        // wrongDemo();
    }

    static void wrongDemo() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter age: ");
            int age = sc.nextInt(); // leaves '\n' in buffer

            System.out.print("Enter name: ");
            String name = sc.nextLine(); // reads empty line!

            System.out.println("Age=" + age + ", Name='" + name + "'");
        }
    }

    static void correctDemo() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter age: ");
            int age = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.println("Age=" + age + ", Name='" + name + "'");
        }
    }
}
