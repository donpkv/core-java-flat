/**
 * I10 — super.method() calls immediate parent version.
 */
public class I10_SuperCallChainDemo {

    static class Grand {
        void greet() {
            System.out.println("Grand greet");
        }
    }

    static class Parent extends Grand {
        @Override
        void greet() {
            System.out.println("Parent greet (before super)");
            super.greet();
            System.out.println("Parent greet (after super)");
        }
    }

    static class Child extends Parent {
        @Override
        void greet() {
            System.out.println("Child greet (before super)");
            super.greet(); // calls Parent.greet, which calls Grand.greet
            System.out.println("Child greet (after super)");
        }
    }

    public static void main(String[] args) {
        new Child().greet();
    }
}
