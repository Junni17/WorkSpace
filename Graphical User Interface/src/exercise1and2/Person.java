package exercise1and2;

public class Person {
	private String name;
	private String title;
	private boolean senior;

	public Person(String name, String title, boolean senior) {
		this.name = name;
		this.title = title;
		this.senior = senior;
	}

	public String getName() {
		return this.name;
	}

	public String getTitle() {
		return this.title;
	}

	public boolean getSenior() {
		return this.senior;
	}

	@Override
	public String toString() {
		String s = this.title + " " + this.name;
		if (this.senior) {
			s = s + " (senior)";
		}
		return s;
	}
}
