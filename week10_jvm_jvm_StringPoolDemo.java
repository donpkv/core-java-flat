package jvm;

/**
 * String Constant Pool (Java 7+ pool in Heap, not PermGen):
 *
 * String literals and interned strings are pooled.
 * == compares references; equals() compares content.
 */
public class StringPoolDemo {

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");
        String s4 = s3.intern();

        System.out.println("s1 == s2 (pool): " + (s1 == s2));
        System.out.println("s1 == s3 (new object): " + (s1 == s3));
        System.out.println("s1 == s4 (intern): " + (s1 == s4));
        System.out.println("s1.equals(s3): " + s1.equals(s3));

        System.out.println("\nInterview tip: never use == for String content comparison");
    }
}
