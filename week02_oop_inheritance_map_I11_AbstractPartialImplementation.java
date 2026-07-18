/**
 * I11 — Abstract middle class: need not implement all abstract methods.
 * Concrete leaf class MUST implement what remains.
 */
public class I11_AbstractPartialImplementation {

    abstract static class Shape {
        abstract double area();
        void label() {
            System.out.println("I am a shape");
        }
    }

    abstract static class Polygon extends Shape {
        int sides;

        Polygon(int sides) {
            this.sides = sides;
        }

        // area() still abstract — OK because Polygon is abstract
    }

    static class Square extends Polygon {
        double side;

        Square(double side) {
            super(4);
            this.side = side;
        }

        @Override
        double area() {
            return side * side;
        }
    }

    public static void main(String[] args) {
        Square s = new Square(5);
        s.label();
        System.out.println("Square area=" + s.area() + ", sides=" + s.sides);
    }
}
