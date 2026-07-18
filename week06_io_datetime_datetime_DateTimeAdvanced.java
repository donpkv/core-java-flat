package datetime;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * Extended java.time usage — you used LocalDate in car rental LLD.
 */
public class DateTimeAdvanced {

    public static void main(String[] args) {
        LocalDate start = LocalDate.of(2025, 12, 5);
        LocalDate end = LocalDate.of(2025, 12, 7);

        long days = ChronoUnit.DAYS.between(start, end) + 1;
        System.out.println("Rental days (inclusive): " + days);

        Period period = Period.between(start, end);
        System.out.println("Period: " + period.getDays() + " days gap");

        LocalDate nextWeek = start.plusWeeks(1);
        System.out.println("Plus 1 week: " + nextWeek);

        System.out.println("isBefore: " + start.isBefore(end));
        System.out.println("Overlap check: " + overlaps(
                LocalDate.of(2025, 12, 1), LocalDate.of(2025, 12, 6),
                LocalDate.of(2025, 12, 5), LocalDate.of(2025, 12, 7)
        ));
    }

    static boolean overlaps(LocalDate aFrom, LocalDate aTo, LocalDate bFrom, LocalDate bTo) {
        return !(aTo.isBefore(bFrom) || aFrom.isAfter(bTo));
    }
}
