package exercise1;

public class Dog {

	private int number;
	private String name;

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

}
