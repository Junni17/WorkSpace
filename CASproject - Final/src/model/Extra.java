package model;

public class Extra {
	private String name;
	private int price;

	public Extra(String name, int price, Hotel hotel) {
		this.name = name;
		this.price = price;
		hotel.addExtras(this);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return this.name + " - " + this.price;
	}
}