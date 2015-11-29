package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Excursion {
	private String name;
	private int price;
	private LocalDate date;
	private ArrayList<Companion> companions = new ArrayList<>();

	public Excursion(String name, LocalDate date, int price) {
		this.name = name;
		this.price = price;
		this.date = date;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDate() {
		return this.date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		String temp = this.name + ", price:" + this.price + " " + this.date;
		return temp;
	}

	// -----------------------------------------------------------------------------

	public ArrayList<Companion> getCompanions() {
		return new ArrayList<Companion>(this.companions);
	}

	/**
	 * Adds the companion.
	 */
	public void addCompanion(Companion companion) {
		assert companion != null;
		this.companions.add(companion);
	}

	/**
	 * Removes the companion.
	 */
	public void removeCompanion(Companion companion) {
		this.companions.remove(companion);
	}

	// -----------------------------------------------------------------------------

	/**
	 * Returns the count of companions in this excursion.
	 */
	public int companionCount() {
		return this.companions.size();
	}
}
