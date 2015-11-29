package exercise3;

public class App {

	public static void main(String[] args) {

		Dog d1 = new Dog(20, "Norma");
		Dog d2 = new Dog(21, "Fanny");
		Dog d3 = new Dog(22, "Mille");
		Dog d4 = new Dog(23, "Ozzi");

		Person p1 = new Person("Jonas", "040693", "28189622");
		Person p2 = new Person("Bella", "130693", "00000000");
		Person p3 = new Person("Lise", "021263", "12345678");

		p1.addDog(d1);
		p1.addDog(d2);
		d1.setPerson(p1);
		d2.setPerson(p1);

		p2.addDog(d3);
		d3.setPerson(p2);

		p3.addDog(d4);
		d4.setPerson(p3);

		// Dog 1 and 2, person 1:

		System.out.println(p1.toString() + "\nDogs: " + p1.getDogs());
		System.out.println();
		System.out.println(d1.toString() + "\nOwner:\n" + d1.getPerson());
		System.out.println();
		System.out.println(d2.toString() + "\nOwner:\n" + d2.getPerson());
		System.out.println();

		// Dog 3, person 2

		System.out.println(p2.toString() + "\nDogs: " + p2.getDogs());
		System.out.println();
		System.out.println(d3.toString() + "\nOwner:\n" + d3.getPerson());
		System.out.println();

		// Dog 4, person 3

		System.out.println(p3.toString() + "\nDogs: " + p3.getDogs());
		System.out.println();
		System.out.println(d4.toString() + "\nOwner:\n" + d4.getPerson());
		System.out.println();
	}

}
