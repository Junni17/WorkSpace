package model;

import java.util.ArrayList;

public class Hotel {
	private String name;
	private int priceSingle;
	private int priceDouble;

	// link to Extra class (--> 0..*)
	private ArrayList<Extra> extras = new ArrayList<>();

	// link to Enrollment class (--> 0..*)
	private ArrayList<Enrollment> enrollments = new ArrayList<>();

	public Hotel(String name, int priceSingle, int priceDouble) {
		this.name = name;
		this.priceSingle = priceSingle;
		this.priceDouble = priceDouble;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPriceSingle() {
		return this.priceSingle;
	}

	public void setPriceSingle(int priceSingle) {
		this.priceSingle = priceSingle;
	}

	public int getPriceDouble() {
		return this.priceDouble;
	}

	public void setPriceDouble(int priceDouble) {
		this.priceDouble = priceDouble;
	}

	@Override
	public String toString() {
		return this.name + " " + this.priceSingle + " - " + this.priceDouble;
	}

	// -----------------------------------------------------------------------------

	/**
	 * Returns a list of this hotel's extras.
	 */
	public ArrayList<Extra> getExtras() {
		return new ArrayList<Extra>(this.extras);
	}

	/**
	 * Adds the extra.
	 */
	public void addExtras(Extra extra) {
		assert extra != null;
		this.extras.add(extra);
	}

	/**
	 * Removes the extra.
	 */
	public void removeExtra(Extra extra) {
		this.extras.remove(extra);
	}

	public Extra createExtra(String name, int price) {
		Extra extra = new Extra(name, price, this);
		this.extras.add(extra);
		return extra;
	}

	// -----------------------------------------------------------------------------

	/**
	 * Returns a list of this enrollments.
	 */
	public ArrayList<Enrollment> getEnrollments() {
		return new ArrayList<Enrollment>(this.enrollments);
	}

	/**
	 * Adds the enrollment.
	 */
	public void addEnrollments(Enrollment enrollment) {
		assert enrollment != null;
		this.enrollments.add(enrollment);
	}

	/**
	 * Removes the enrollment.
	 */
	public void removeEnrollment(Enrollment enrollment) {
		this.enrollments.remove(enrollment);
	}
}
