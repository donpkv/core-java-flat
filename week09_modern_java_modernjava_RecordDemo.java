package modernjava;

import java.time.LocalDateTime;

/**
 * Java 16+ record: immutable data carrier.
 * Auto-generates constructor, getters, equals, hashCode, toString.
 * Use for DTOs, value objects (Ticket, Point, etc.)
 */
record StudentRecord(int id, String name, double gpa) {

    // compact constructor — validation
    public StudentRecord {
        if (gpa < 0 || gpa > 10) {
            throw new IllegalArgumentException("Invalid GPA");
        }
    }

    public String honorStatus() {
        return gpa >= 8.5 ? "Honors" : "Regular";
    }
}

public class RecordDemo {
    public static void main(String[] args) {
        StudentRecord s1 = new StudentRecord(1, "Piyush", 9.2);
        StudentRecord s2 = new StudentRecord(1, "Piyush", 9.2);

        System.out.println(s1);
        System.out.println("name(): " + s1.name());
        System.out.println("honorStatus: " + s1.honorStatus());
        System.out.println("equals s2? " + s1.equals(s2));
    }
}
