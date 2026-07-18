/**
 * I07 — Class instance method wins over interface default (same signature).
 *
 * If Child overrides, Child wins. If not, class parent method is inherited.
 */
public class I07_ClassVsInterfaceDefaultConflict {

    interface Printable {
        default void print() {
            System.out.println("interface default print");
        }
    }

    static class Base {
        public void print() {
            System.out.println("Base class print");
        }
    }

    static class Derived extends Base implements Printable {
        // no override → Base.print wins over Printable.print
    }

    static class DerivedOverride extends Base implements Printable {
        @Override
        public void print() {
            System.out.println("DerivedOverride print");
        }
    }

    public static void main(String[] args) {
        System.out.println("Derived (no override):");
        new Derived().print(); // Base class print

        System.out.println("DerivedOverride:");
        new DerivedOverride().print(); // child override
    }
}
