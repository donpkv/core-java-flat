/**
 * I14 — Q: Variables/methods in interface — what is allowed?
 * A: Fields = public static final constants only.
 *    Methods = abstract | default | static | private (Java 9+)
 */
public class I14_InterfaceMembersDemo {

    interface Config {
        int MAX = 100;                    // public static final (constant)
        String APP = "CoreJava";          // constant

        void save();                      // public abstract

        default void saveWithLog() {
            System.out.println("default saveWithLog");
            save();
        }

        static void printMax() {
            System.out.println("static MAX=" + MAX);
        }
    }

    static class AppConfig implements Config {
        @Override
        public void save() {
            System.out.println("save to DB");
        }
    }

    public static void main(String[] args) {
        System.out.println("Constant: Config.MAX=" + Config.MAX);

        AppConfig app = new AppConfig();
        app.save();
        app.saveWithLog();   // inherited default

        Config.printMax();   // static — interface name
        // app.printMax();   // COMPILE ERROR — static not inherited as instance method
    }
}
