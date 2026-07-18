package datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
public class DateTime {

    public static void main(String...args)
    {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.of(localDate,localTime);

        System.out.println(localDateTime.toLocalDate());
        System.out.println("parsing date to dd MM yyyy");
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
        String text = date.format(formatter);
        System.out.println(text);
        //code below may not parse to pattern above
        LocalDate parsedDate = LocalDate.parse(text, formatter);
        System.out.println("not parsed to dd MM yyyy");
        System.out.println(parsedDate);


    }
}
