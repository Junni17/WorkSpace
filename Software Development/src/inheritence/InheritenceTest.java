package inheritence;

public class InheritenceTest {

	public static void main(String[] args) {
		Person person = new Person("Superman", "Metropolis", "Can fly");
		Teacher teacher = new Teacher("Jonas", "Aarhus", "Er nice", 10, 28000);

		Student student = new Student("Batman", "Gothham City", "Has no superpowers", 9.4, "eaaabat");

		person.printPerson();
		student.printPerson();
		teacher.printPerson();
	}

}
