package exercise3;

import java.util.ArrayList;

public class Person {

	private String name;
	private String cpr;
	private String phone;
	private ArrayList<Dog> dogs = new ArrayList<>();

	public Person(String name, String cpr, String phone) {
		this.name = name;
		this.cpr = cpr;
		this.phone = phone;
	}

	public String getCpr() {
		return this.cpr;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Name: " + this.name + ", CPR: " + this.cpr + ", phone: " + this.phone;
	}

	public ArrayList<Dog> getDogs() {
		return this.dogs;
	}

	public void addDog(Dog dog) {
		this.dogs.add(dog);
	}

	public void removeDog(Dog dog) {
		this.dogs.remove(dog);
	}

}
