/**
 * I02 — Diamond problem: class cannot extend two classes.
 *
 * Same idea as DeadDiamondDesign.java in core_java_programs/
 */
public class I02_DiamondProblemDemo {

    static class Animal {
        void speed() { System.out.println("Animal speed"); }
    }

    static class Tiger extends Animal {
        void tigerHunt() { System.out.println("Tiger"); }
    }

    static class Lion extends Animal {
        void lionRoar() { System.out.println("Lion"); }
    }

    // COMPILE ERROR if uncommented:
    // static class Liger extends Tiger, Lion { }

    static class Liger extends Tiger {
        @Override
        void speed() {
            System.out.println("Liger speed (extends Tiger only)");
        }
    }

    public static void main(String[] args) {
        new Liger().speed();
        System.out.println("Fix diamond: extend ONE class; share behavior via interfaces.");
    }
}
