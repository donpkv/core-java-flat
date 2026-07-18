/**
 * I08 — static method HIDING vs instance method OVERRIDING
 *
 * static: resolved by reference type at compile time (no runtime polymorphism)
 * instance: resolved by object type at runtime (polymorphism)
 */
public class I08_MethodOverridingVsStaticHiding {

    static class Parent {
        static void staticMsg() {
            System.out.println("Parent static");
        }

        void instanceMsg() {
            System.out.println("Parent instance");
        }
    }

    static class Child extends Parent {
        static void staticMsg() {
            System.out.println("Child static"); // HIDES, not overrides
        }

        @Override
        void instanceMsg() {
            System.out.println("Child instance"); // OVERRIDES
        }
    }

    public static void main(String[] args) {
        Parent p = new Child();

        p.staticMsg();    // Parent static — reference type Parent
        p.instanceMsg();  // Child instance — runtime object Child

        Child.staticMsg();
        Parent.staticMsg();
    }
}
