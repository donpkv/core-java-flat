/**
 * I17 — Q: Parent ref to child — how to access CHILD field (20)?
 * A: Cast + getter if private. Parent ref alone gives parent field (10).
 */
public class I17_ParentRefAccessChildFieldDemo {

    abstract static class AbstractClass {
        protected int hiddenVar = 10;
    }

    static class ImplementationClass1 extends AbstractClass {
        private int hiddenVar = 20;

        public int getChildHiddenVar() {
            return hiddenVar;
        }

        void printInsideChild() {
            System.out.println("inside child hiddenVar=" + hiddenVar);       // 20
            System.out.println("inside child super.hiddenVar=" + super.hiddenVar); // 10
        }
    }

    public static void main(String[] args) {
        AbstractClass p = new ImplementationClass1();

        System.out.println("Parent ref p.hiddenVar = " + p.hiddenVar);  // 10

        ImplementationClass1 c = (ImplementationClass1) p;
        System.out.println("Cast + getter = " + c.getChildHiddenVar()); // 20

        c.printInsideChild();
    }
}
