package exercise4;

public class NameTester {

	public static void main(String[] args) {
		Name name1 = new Name("Per", "Olsen");
		System.out.println("Full name: " + name1.getFullName());
		System.out.println("Initials: " + name1.getInits());
		System.out.println();

		System.out.println("Encrypted Initials: " + name1.getCryptoInits(10));
		System.out.println("Username: " + name1.getUsername());

	}

}
