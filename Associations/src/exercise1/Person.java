package exercise1;

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
		String temp = "Name: " + this.name + ", CPR: " + this.cpr + ", phone: " + this.phone;
		if (!this.dogs.isEmpty()) {
			temp += "\nDogs:";
			for (int i = 0; i < this.dogs.size(); i++) {
				temp += "\n" + this.dogs.get(i).toString();
			}
		}
		return temp;
	}

	public ArrayList<Dog> getDogs() {
		return new ArrayList<>(this.dogs);
	}

	public void addDog(Dog dog) {
		this.dogs.add(dog);
	}

	public void removeDog(Dog dog) {
		this.dogs.remove(dog);
	}

}
