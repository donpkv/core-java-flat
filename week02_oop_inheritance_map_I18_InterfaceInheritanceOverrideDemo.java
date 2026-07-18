/**
 * I18 — Q: abstract / default / static / private in interface — inherited? overridden?
 *
 * abstract  → must implement (override)
 * default   → inherited; optional override
 * static    → NOT inherited; call InterfaceName.m()
 * private   → NOT inherited; not overridable
 */
public class I18_InterfaceInheritanceOverrideDemo {

    interface Service {
        void run();  // abstract

        default void runWithLog() {
            System.out.println("default runWithLog start");
            run();
        }

        static void info() {
            System.out.println("static info from Service");
        }

        private static void helper() {
            System.out.println("private static helper");
        }

        default void demoPrivateHelper() {
            helper();
        }
    }

    static class MyService implements Service {
        @Override
        public void run() {
            System.out.println("MyService.run()");
        }

        @Override
        public void runWithLog() {
            System.out.println("MyService OVERRIDDEN runWithLog");
            run();
        }
    }

    public static void main(String[] args) {
        MyService s = new MyService();
        s.run();
        s.runWithLog();        // overridden version
        s.demoPrivateHelper(); // uses private helper inside interface

        Service.info();        // static on interface
    }
}
