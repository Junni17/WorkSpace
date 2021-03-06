package inheritence;

public class Teacher extends Person {

	private int classes;
	private int salary;

	public Teacher(String name, String address, String qualification, int classes, int salary) {
		super(name, address, qualification);
		this.classes = classes;
		this.salary = salary;

	}

	public int getClasses() {
		return this.classes;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void haveBaby(Person baby, String address, String name, String qualification) {
		baby = new Person(address, name, qualification);
	}

	@Override
	public void printPerson() {
		super.printPerson();
		System.out.println("The teacher teaches: " + this.classes + " classes.");
		System.out.println("The teacher's salary: " + this.salary);
	}

}
