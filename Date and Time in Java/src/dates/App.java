package dates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class App
{
    public static void main(String[] args)
    {
        LocalDate d1 = LocalDate.of(2014, 6, 3);
        System.out.println(d1);
        LocalDate d2 = LocalDate.of(2015, Month.AUGUST, 1);
        System.out.println(d2);
        System.out.println();

        Period p1 = d1.until(d2);
        System.out.printf("From %s to %s: %d years, %d months, %d days\n", d1, d2, p1.getYears(),
                p1.getMonths(), p1.getDays());
        System.out.println();

        System.out.printf("From %s to %s: %d months\n", d1, d2, ChronoUnit.MONTHS.between(d1, d2));
        System.out.printf("From %s to %s: %d days\n", d1, d2, ChronoUnit.DAYS.between(d1, d2));
        System.out.println();

        LocalDateTime dt1 = LocalDateTime.of(2014, 7, 25, 0, 0, 10);
        System.out.println(dt1);
        LocalDateTime dt2 = dt1.plusHours(1).plusMinutes(1).plusSeconds(1);
        System.out.println(dt2);
        System.out.println();

        Long seconds = dt1.until(dt2, ChronoUnit.SECONDS);
        System.out.printf("From %1$tF at %1$tT to %2$tF at %2$tT: %3$d seconds\n", dt1, dt2,
                seconds);
    }
}
