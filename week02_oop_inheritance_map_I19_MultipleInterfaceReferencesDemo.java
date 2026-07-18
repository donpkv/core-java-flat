/**
 * I19 — Q: Child implements I1, I2 — multiple refs, access rules, constant clash
 *
 * I1 ref → only I1 methods. I2 ref → only I2 methods. Same object possible.
 * Same constant name → use I1.MAX / I2.MAX
 */
public class I19_MultipleInterfaceReferencesDemo {

    interface I1 {
        int MAX = 10;
        void a();
        default void common() { System.out.println("I1 common default"); }
    }

    interface I2 {
        int MAX = 20;
        void b();
        default void common() { System.out.println("I2 common default"); }
    }

    static class Child implements I1, I2 {
        @Override public void a() { System.out.println("Child.a()"); }
        @Override public void b() { System.out.println("Child.b()"); }

        @Override
        public void common() {
            System.out.println("Child resolved common()");
        }

        void childOnly() { System.out.println("Child.childOnly()"); }
    }

    public static void main(String[] args) {
        Child same = new Child();
        I1 ref1 = same;
        I2 ref2 = same;

        ref1.a();
        ref2.b();
        ref1.common();  // Child.common()
        ref2.common();  // Child.common()

        // ref1.b();           // COMPILE ERROR — I1 doesn't know b()
        ((I2) ref1).b();       // OK with cast

        System.out.println("I1.MAX=" + I1.MAX + ", I2.MAX=" + I2.MAX);
        // System.out.println(MAX); // ambiguous if both imported

        same.childOnly();
    }
}
