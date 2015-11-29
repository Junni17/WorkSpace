package exercise2;

public class Person {

	private String name;
	private String cpr;
	private String phone;

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

}
