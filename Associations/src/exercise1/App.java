package exercise1;

public class App {

	public static void main(String[] args) {

		Dog d1 = new Dog(20, "Norma");
		Dog d2 = new Dog(21, "Fanny");

		Person p1 = new Person("Jonas", "040693", "28189622");

		p1.addDog(d1);
		p1.addDog(d2);

		System.out.println(p1.toString());

	}

}
