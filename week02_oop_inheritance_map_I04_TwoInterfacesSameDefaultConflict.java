/**
 * I04 — Two interfaces, SAME default method → MUST override in class.
 *
 * Without override below, this class would not compile:
 *   error: class Duck inherits unrelated defaults for quack() from types A and B
 */
public class I04_TwoInterfacesSameDefaultConflict {

    interface A {
        default void greet() {
            System.out.println("greet from A");
        }
    }

    interface B {
        default void greet() {
            System.out.println("greet from B");
        }
    }

    static class Speaker implements A, B {
        @Override
        public void greet() {
            System.out.println("Speaker resolved greet() — single method for callers");
        }
    }

    public static void main(String[] args) {
        new Speaker().greet();
    }
}
