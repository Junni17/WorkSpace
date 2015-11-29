package exercise2;

import java.time.LocalDate;
import java.time.Period;

public class Rental {

	private int number;
	private Period days;
	private LocalDate startDate;
	private double price;

	public Rental(int number, int days, double price, LocalDate startDate) {
		this.number = number;
		this.days = Period.ofDays(days);
		this.price = price;
		this.startDate = startDate;
	}

	public double getPricePrDay() {
		return this.price;
	}

	public void setDays(int days) {
		this.days = Period.ofDays(days);
	}

	public int getDays() {
		return this.days.getDays();
	}

	public LocalDate getStartDate() {
		return this.startDate;
	}

	public LocalDate getEndDate() {
		LocalDate ld = this.startDate.plusDays(this.days.getDays());
		return ld;
	}

	public double getTotalPrice() {
		return this.price * this.days.getDays();
	}

}
