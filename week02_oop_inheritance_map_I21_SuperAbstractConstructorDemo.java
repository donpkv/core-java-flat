/**
 * I21 — Q: super() with abstract parent — constructor chain (CoreJava_7 style)
 *
 * super() always runs for extends (normal or abstract class).
 * implements interface → NO super() to interface.
 */
public class I21_SuperAbstractConstructorDemo {

    abstract static class AbstractClass {
        AbstractClass() {
            System.out.println("AbstractClass constructor");
        }
        abstract void abstractFun();
        void nonAbstractFun() {
            System.out.println("nonAbstractFun from AbstractClass");
        }
    }

    static class ImplementationClass1 extends AbstractClass {
        ImplementationClass1() {
            super(); // explicit — same as compiler-inserted super()
            System.out.println("ImplementationClass1 constructor");
        }
        @Override
        void abstractFun() {
            System.out.println("impl1 abstractFun");
        }
    }

    static class ImplementationClass2 extends AbstractClass {
        ImplementationClass2() {
            // implicit super() inserted here
            System.out.println("ImplementationClass2 constructor");
        }
        @Override
        void abstractFun() {
            System.out.println("impl2 abstractFun");
        }
    }

    static class Interaction {
        void interact(AbstractClass obj) {
            obj.abstractFun();   // runtime polymorphism — impl version
            obj.nonAbstractFun();
        }
    }

    public static void main(String[] args) {
        AbstractClass a = new ImplementationClass1();
        AbstractClass b = new ImplementationClass2();

        Interaction inter = new Interaction();
        inter.interact(a);
        inter.interact(b);
    }
}
