/**
 * I09 — Field HIDING (not overriding)
 *
 * Parent p = new Child(); p.value uses Parent's field, not Child's.
 */
public class I09_FieldHidingNotOverriding {

    static class Parent {
        int value = 10;
        String name = "Parent";
    }

    static class Child extends Parent {
        int value = 20;           // hides Parent.value
        String name = "Child";    // hides Parent.name
    }

    public static void main(String[] args) {
        Child c = new Child();
        System.out.println("Child ref: value=" + c.value + ", name=" + c.name);

        Parent p = new Child();
        System.out.println("Parent ref to Child object: value=" + p.value + ", name=" + p.name);
        System.out.println("Fields use REFERENCE type, not object type.");
    }
}
