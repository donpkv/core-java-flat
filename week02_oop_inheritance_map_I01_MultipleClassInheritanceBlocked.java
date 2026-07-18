/**
 * I01 — Java allows only ONE class superclass.
 *
 * // class Bad extends ClassA, ClassB { }  // COMPILE ERROR
 *
 * Allowed:
 *   class Good extends ClassA implements Interface1, Interface2 { }
 */
public class I01_MultipleClassInheritanceBlocked {

    static class ClassA {
        void fromA() { System.out.println("ClassA"); }
    }

    static class ClassB {
        void fromB() { System.out.println("ClassB"); }
    }

    // OK: one class + many interfaces
    static class Good extends ClassA implements Runnable {
        public void run() {
            System.out.println("implements Runnable");
        }
    }

    public static void main(String[] args) {
        Good g = new Good();
        g.fromA();
        g.run();
        System.out.println("Rule: extends ONE class, implements MANY interfaces.");
    }
}
