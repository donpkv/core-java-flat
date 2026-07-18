/**
 * I13 — Q: Must concrete class implement ALL abstract methods?
 * A: YES for concrete class. Abstract subclass may leave some abstract.
 */
public class I13_AbstractMustImplementDemo {

    abstract static class AbstractClass {
        abstract void abstractFun();
        void nonAbstractFun() {
            System.out.println("concrete method in abstract class");
        }
    }

    // COMPILE ERROR if uncommented — missing abstractFun()
    // static class Bad extends AbstractClass { }

    static class Good extends AbstractClass {
        @Override
        void abstractFun() {
            System.out.println("Good implemented abstractFun");
        }
    }

    abstract static class Middle extends AbstractClass {
        // OK — Middle is abstract, abstractFun still pending
    }

    static class Leaf extends Middle {
        @Override
        void abstractFun() {
            System.out.println("Leaf finally implements abstractFun");
        }
    }

    public static void main(String[] args) {
        Good g = new Good();
        g.abstractFun();
        g.nonAbstractFun();

        Leaf l = new Leaf();
        l.abstractFun();
    }
}
