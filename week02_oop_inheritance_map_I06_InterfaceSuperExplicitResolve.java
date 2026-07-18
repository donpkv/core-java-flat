/**
 * I06 — Resolve default clash using InterfaceName.super.method()
 *
 * Same pattern as InterfaceAmbiguity.java (week02 reference).
 */
public class I06_InterfaceSuperExplicitResolve {

    interface A {
        default void log() { System.out.println("log A"); }
    }

    interface B {
        default void log() { System.out.println("log B"); }
    }

    interface C {
        default void log() { System.out.println("log C"); }
    }

    static class App implements A, B, C {
        @Override
        public void log() {
            System.out.println("--- App.log() delegating to each interface default ---");
            A.super.log();
            B.super.log();
            C.super.log();
            System.out.println("--- done ---");
        }
    }

    public static void main(String[] args) {
        new App().log();
        System.out.println("Outside caller: new App().log() runs App's override only.");
    }
}
