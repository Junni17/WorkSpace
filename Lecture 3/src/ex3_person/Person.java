package ex3_person;

public class Person {

	private String name;
	private String address;
	private int monthlySalary;

	public Person(String name, String address, int monthlySalary) {
		this.name = name;
		this.address = address;
		this.monthlySalary = monthlySalary;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return this.address;
	}

	public void setMonthlySalary(int monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

	public int getMonthlySalary() {
		return this.monthlySalary;
	}

	public double getYearlySalary() {
		return this.monthlySalary * 12 * 1.025;
	}

	public void printPerson() {
		System.out.println("Name: " + this.name);
		System.out.println("Address: " + this.address);
		System.out.println("Monthly Salary: " + this.monthlySalary);

	}

}
