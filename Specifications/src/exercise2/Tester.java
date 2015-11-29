package exercise2;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Tester {

	public static void main(String[] args) {

		Rental r1 = new Rental(1, 20, 250, LocalDate.of(2016, 8, 3));
		Rental r2 = new Rental(1, 25, 300, LocalDate.of(2015, 11, 1));

		// first rental
		System.out.println("First rental:");
		System.out.println("The date before the start date: " + r1.getStartDate().minusDays(1));
		System.out.println("End date: " + r1.getEndDate());
		System.out.println("Total price: " + r1.getTotalPrice());
		System.out.println();

		// second rental
		System.out.println("Second rental:");
		System.out.println("The date before the start date: " + r2.getStartDate().minusDays(1));
		System.out.println("End date: " + r2.getEndDate());
		System.out.println("Total price: " + r2.getTotalPrice());
		System.out.println();

		Period p1 = r2.getStartDate().until(r1.getEndDate());
		System.out.printf(
				"Number of years, months and days between the end day of one rental,\nand the start day of the other rental.\nFrom %s to %s: %d years, %d months, %d days\n",
				r2.getStartDate(), r1.getEndDate(), p1.getYears(), p1.getMonths(), p1.getDays());

		System.out.printf("Days between the two dates: %d days",
				ChronoUnit.DAYS.between(r2.getStartDate(), r1.getEndDate()));

	}

}
