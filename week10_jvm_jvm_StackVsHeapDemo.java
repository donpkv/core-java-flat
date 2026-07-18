package jvm;

/**
 * Stack vs Heap:
 *
 * STACK (per thread):
 *   - local primitive variables (int, double, boolean)
 *   - reference variables (the reference itself, not the object)
 *   - method call frames
 *
 * HEAP (shared):
 *   - actual objects and arrays live here
 *   - referenced by stack/local variables
 */
public class StackVsHeapDemo {

    public static void main(String[] args) {
        int age = 25;                 // primitive → stack
        String name = "Piyush";       // reference on stack, String object on heap
        Person person = new Person(1, "Amy"); // reference stack, object heap

        System.out.println("Primitive on stack: age=" + age);
        System.out.println("String ref on stack, object on heap: " + name);
        System.out.println("Person object on heap: " + person);

        demonstrateMethodStack();
    }

    static void demonstrateMethodStack() {
        int local = 10; // new stack frame created for this method
        System.out.println("Method local variable lives in this frame's stack: " + local);
    }
}

class Person {
    int id;
    String name;

    Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{id=" + id + ", name='" + name + "'}";
    }
}
