package inheritence;

public class Student extends Person {

	private double gradeAverage;
	private String studentId;

	public Student(String name, String address, String qualification, double gradeAverage, String studentId) {
		super(name, address, qualification);// The first statement in a
		this.gradeAverage = gradeAverage; // subclass constructor must be
		this.studentId = studentId; // a call to super,
									// which calls the constructor of the
									// superclass. If no call to super
									// is made
									// a implicit call to a no argument
									// constructor of the superclass is made.
	}

	public double getGradeAverage() {
		return this.gradeAverage;
	}

	public void setGradeAverage(double gradeAverage) {
		this.gradeAverage = gradeAverage;
	}

	public void printAddress() {
		System.out.println("Address: " + this.address);

	}

	@Override
	public void printPerson() { // Overrides the PrintPerson method from the
								// superclass Person.
		super.printPerson(); // the super prefix ensures that the method in the
								// superclass is called and not this method.
		System.out.println("Grade average: " + this.gradeAverage);
		System.out.println("Student identification: " + this.studentId);
	}

}
