/**
 * Practice 03 — StackOverflowError (stack memory, not heap)
 *
 * Run: java P03_StackOverflowDemo
 * Symptom in prod: StackOverflowError in logs — infinite recursion or too-deep call chain.
 *
 * Thread dump: deep repeating stack frames in same method.
 * Fix: tail recursion refactor, iteration, increase -Xss only as last resort.
 */
public class P03_StackOverflowDemo {

    public static void main(String[] args) {
        try {
            recurse(0);
        } catch (StackOverflowError e) {
            System.out.println("Caught StackOverflowError — stack exhausted, not heap");
        }
    }

    static void recurse(int depth) {
        recurse(depth + 1);
    }
}
