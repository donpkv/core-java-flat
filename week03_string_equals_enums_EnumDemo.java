package enums;

/**
 * Core enum concepts:
 * - constants, fields, constructor, methods
 * - using enum in switch (Java 21 switch works with enums)
 */
enum Day {
    MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4),
    FRIDAY(5), SATURDAY(6), SUNDAY(7);

    private final int order;

    Day(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }

    public boolean isWeekend() {
        return this == SATURDAY || this == SUNDAY;
    }
}

public class EnumDemo {

    public static void main(String[] args) {
        Day today = Day.FRIDAY;

        System.out.println("Today: " + today);
        System.out.println("Order: " + today.getOrder());
        System.out.println("Weekend? " + today.isWeekend());

        System.out.println("\nAll days:");
        for (Day day : Day.values()) {
            System.out.println(day + " -> order " + day.getOrder());
        }

        System.out.println("\nSwitch on enum:");
        System.out.println(describeDay(Day.SUNDAY));
    }

    static String describeDay(Day day) {
        return switch (day) {
            case SATURDAY, SUNDAY -> "Holiday";
            case FRIDAY -> "Almost weekend";
            default -> "Working day";
        };
    }
}
