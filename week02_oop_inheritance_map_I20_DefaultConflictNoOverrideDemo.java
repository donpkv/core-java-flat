/**
 * I20 — Q: Two interfaces same default method — child does NOT override?
 * A: COMPILE ERROR on concrete class. Must override (shown in ChildFixed).
 *
 * Uncomment BrokenChild to see compiler error:
 *   inherits unrelated defaults for common() from I1 and I2
 */
public class I20_DefaultConflictNoOverrideDemo {

    interface I1 {
        default void common() { System.out.println("I1"); }
    }

    interface I2 {
        default void common() { System.out.println("I2"); }
    }

    /*
    static class BrokenChild implements I1, I2 {
        // no common() → COMPILE ERROR
    }
    */

    static class ChildFixed implements I1, I2 {
        @Override
        public void common() {
            System.out.println("ChildFixed resolved");
            I1.super.common();
            I2.super.common();
        }
    }

    static class SingleDefault implements I1 {
        // no override needed — only one default source
    }

    public static void main(String[] args) {
        I1 a = new ChildFixed();
        I2 b = new ChildFixed();
        a.common();
        b.common();

        new SingleDefault().common(); // uses I1 default
    }
}
