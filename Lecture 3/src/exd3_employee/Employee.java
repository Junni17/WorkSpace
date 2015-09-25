package exd3_employee;

/**
 * This class models an employee.
 */
public class Employee {
	// The name of the employee.
	private String name1;
	private String name2;
	// Whether the employee is a trainee or not.
	private boolean trainee;
	// Age of employee
	private int age;

	/**
	 * Creates an employee as a trainee with the given name.
	 */
	public Employee(String name1, String name2, int age) {
		this.name1 = name1;
		this.name2 = name2;
		this.trainee = true;
		this.age = age;
	}

	/**
	 * Sets the name of the employee.
	 */
	public void setName1(String name1) {
		this.name1 = name1;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return this.age;
	}

	/**
	 * Returns the name of the employee.
	 */
	public String getName1() {
		return this.name1;
	}

	public String getName2() {
		return this.name2;
	}

	/**
	 * Sets the trainee state of the employee.
	 */
	public void setTrainee(boolean trainee) {
		this.trainee = trainee;
	}

	/**
	 * Returns the trainee state of the employee.
	 */
	public boolean isTrainee() {
		return this.trainee;
	}

	/**
	 * Returns a description of the employee (for test purposes).
	 */
	@Override
	public String toString() {
		return this.name1 + " (trainee: " + this.trainee + ")";
	}

	public int hasBirthday() {
		return this.age = this.age + 1;
	}

	/**
	 * Prints a description of the employee.
	 */
	public void printEmployee() {
		System.out.println("*******************");
		System.out.println("First Name: " + this.name1);
		System.out.println("Last Name: " + this.name2);
		System.out.println("Trainee: " + this.trainee);
		System.out.println("Age: " + this.age);
		System.out.println("*******************");
		System.out.println();
	}
}
