import java.util.Scanner;

/**
 * Practice 01 — Scanner basics
 * Task: read 2 ints from keyboard and print sum.
 * Run: P01_ScannerSumTwoNumbers
 */
public class P01_ScannerSumTwoNumbers {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter first number: ");
            int a = sc.nextInt();

            System.out.print("Enter second number: ");
            int b = sc.nextInt();

            System.out.println("Sum = " + (a + b));
        }
    }
}
