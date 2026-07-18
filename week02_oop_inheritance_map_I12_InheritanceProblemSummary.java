/**
 * I12 — Prints inheritance problem decision table (study summary).
 */
public class I12_InheritanceProblemSummary {

    public static void main(String[] args) {
        System.out.println("""
                ===== INHERITANCE PROBLEMS — WHAT HAPPENS ON CALL =====

                1) extends ClassA, ClassB          → COMPILE ERROR
                2) implements I1,I2 same abstract  → one method in class; child.call() uses it
                3) implements I1,I2 same default   → MUST override; child.call() uses override
                4) override + A.super.m()          → explicit default from interface A only
                5) class method vs interface default → class wins unless child overrides
                6) static same name in parent/child  → HIDING (reference type decides)
                7) field same name in parent/child   → HIDING (reference type decides)
                8) instance override                 → RUNTIME type (polymorphism)
                9) abstract middle class             → can leave abstract methods for leaf class

                Read: inheritance_map/INHERITANCE_SCENARIOS.txt
                Run: I03 (abstract clash) I04-I06 (default clash) I08-I09 (hiding)
                """);
    }
}
