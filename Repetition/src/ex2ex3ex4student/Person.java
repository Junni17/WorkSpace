package ex2ex3ex4student;

public class Person {
	private String firstname;
	private String lastname;
	private int dayOfBirth; // 1..31
	private int monthOfBirth; // 1..12
	private int yearOfBirth; // 1900..2010

	public Person(String lastname, String firstname, int dayOfBirth, int monthOfBirth, int yearOfBirth) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.dayOfBirth = dayOfBirth;
		this.monthOfBirth = monthOfBirth;
		this.yearOfBirth = yearOfBirth;
	}

	public void calcAge(int year, int month, int day) {
		int age = 0;
		if (year > this.yearOfBirth) {
			year = year - this.yearOfBirth;
			age = year - 1;
			if (month == this.monthOfBirth && day >= this.dayOfBirth) {
				age += 1;
			} else if (month == this.monthOfBirth && day < this.dayOfBirth) {
				age = year - 1;
			} else if (month < this.monthOfBirth) {
				age = year - 1;
			}

		} else {
			age = 0;
		}

		if (age >= 0) {
			System.out.println("Your age is: " + age);
		} else {
			System.out.println("You were not born yet");
		}
	}

	public boolean leapYear(int year) {
		if (year % 4 == 0 && year % 400 == 0 || year % 100 != 0) {
			return true;
		} else {
			return false;
		}
	}

	public String calcWeekday(String weekday, int year) {
		if (year < this.yearOfBirth) {
			return "Enter a year bigger than your birth year...";
		} else {
			return weekday + " " + year;
		}
	}

	public String calcWeekday(int weekday, int year) {
		if (year < this.yearOfBirth) {
			return "Enter a year bigger than your birth year...";
		} else {
			return weekday + " " + year;
		}
	}

	public void printPerson() {
		System.out.println(this.firstname + " " + this.lastname + " " + this.yearOfBirth + "-" + this.monthOfBirth + "-"
				+ this.dayOfBirth);
	}
}
