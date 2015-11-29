package exercise3;

public class Dog {

	private int number;
	private String name;
	private Person person;

	public Dog(int number, String name) {
		this.number = number;
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		// String temp = this.name;
		return this.name;
	}

	public int getNumber() {
		return this.number;
	}

	@Override
	public String toString() {
		return "Name of dog: " + this.name + ", number: " + this.number;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
