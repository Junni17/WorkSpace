package exercise2;

public class App {

	public static void main(String[] args) {

		Dog d1 = new Dog(20, "Norma");
		Dog d2 = new Dog(21, "Fanny");

		Person p1 = new Person("Jonas", "040693", "28189622");

		d1.setPerson(p1);
		d2.setPerson(p1);

		System.out.println("Dog 1: \n" + d1.toString() + "\nOwner:\n" + d1.getPerson().toString());
		System.out.println();
		System.out.println("Dog 2: \n" + d2.toString() + "\nOwner:\n" + d2.getPerson().toString());

	}

}
