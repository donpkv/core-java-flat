/**
 * I05 — Child reference: which method() runs after resolving conflict?
 *
 * Caller always sees ONE method on the object — the child's override.
 */
public class I05_ChildCallsResolvedMethod {

    interface X {
        default void report() { System.out.println("default X"); }
    }

    interface Y {
        default void report() { System.out.println("default Y"); }
    }

    static class Worker implements X, Y {
        @Override
        public void report() {
            System.out.println("Worker.report() — this is what callers get");
        }
    }

    public static void main(String[] args) {
        Worker w = new Worker();
        w.report();

        X refAsX = w;
        refAsX.report(); // still Worker.report() — runtime dispatch

        Y refAsY = w;
        refAsY.report(); // still Worker.report()
    }
}
