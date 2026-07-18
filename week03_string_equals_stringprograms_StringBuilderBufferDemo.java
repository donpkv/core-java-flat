package stringprograms;

/**
 * String is immutable. StringBuilder (not thread-safe) vs StringBuffer (thread-safe).
 * Use StringBuilder in single-threaded code for performance.
 */
public class StringBuilderBufferDemo {

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");

        System.out.println("s1 == s2 (pool): " + (s1 == s2));
        System.out.println("s1 == s3 (new object): " + (s1 == s3));
        System.out.println("s1.equals(s3): " + s1.equals(s3));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sb.append(i).append("-");
        }
        System.out.println("StringBuilder: " + sb);

        StringBuffer buffer = new StringBuffer("thread-safe ");
        buffer.append("append");
        System.out.println("StringBuffer: " + buffer);
    }
}
