package ex3_person;

public class PersonTester {

	// testing methods, it appears to be working :-D

	public static void main(String[] args) {
		Person p1 = new Person("Moron", "Somewhere", 300);
		p1.printPerson();
		System.out.println("Yearly Salary: " + p1.getYearlySalary());
	}

}
