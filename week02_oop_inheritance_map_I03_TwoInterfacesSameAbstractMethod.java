/**
 * I03 — Two interfaces, SAME abstract method → implement ONCE in class.
 *
 * Both Flyable and Movable require move() — one override satisfies both.
 */
public class I03_TwoInterfacesSameAbstractMethod {

    interface Flyable {
        void move();
    }

    interface Movable {
        void move();
    }

    static class Robot implements Flyable, Movable {
        @Override
        public void move() {
            System.out.println("Robot move() — satisfies Flyable AND Movable");
        }
    }

    public static void main(String[] args) {
        Robot r = new Robot();
        r.move();

        Flyable f = r;
        Movable m = r;
        f.move();
        m.move();
        System.out.println("Same single method — all calls hit Robot.move()");
    }
}
