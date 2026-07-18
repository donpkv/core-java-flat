/**
 * I16 — Q: Same field name in abstract parent and child — which is used?
 * A: FIELD HIDING — reference type decides (NOT polymorphism).
 */
public class I16_FieldHidingAbstractParentDemo {

    abstract static class AbstractClass {
        int hiddenVar = 10;
    }

    static class ImplementationClass1 extends AbstractClass {
        int hiddenVar = 20;
    }

    public static void main(String[] args) {
        ImplementationClass1 c = new ImplementationClass1();
        AbstractClass p = new ImplementationClass1();

        System.out.println("Child ref hiddenVar  = " + c.hiddenVar);  // 20
        System.out.println("Parent ref hiddenVar = " + p.hiddenVar);  // 10
        System.out.println("Same object, two fields, two values.");
    }
}
