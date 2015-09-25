package exercise_2;

public class Child {
	private int age;
	private boolean male;

	public Child(int age, boolean male) {
		this.age = age;
		this.male = male;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isMale() {
		return this.male;
	}

	public void setMale(boolean male) {
		this.male = male;
	}

	public String institution() {
		String institution = "";
		if (this.age == 0) {
			institution = "At home";
		} else if (this.age > 0 && this.age < 3) {
			institution = "Child care";
		} else if (this.age > 2 && this.age < 6) {
			institution = "Kindergarten";
		} else if (this.age > 5 && this.age < 17) {
			institution = "School";
		} else if (this.age >= 17) {
			institution = "Outside school";
		}
		return institution;
	}

	public String gender() {
		String gender = "";
		if (this.male == true) {
			gender = "Boy";
		} else if (this.male == false) {
			gender = "Girl";
		}
		return gender;
	}

	public String team() {
		String team = "";
		if (this.male == true && this.age < 8) {
			team = "Small boys";
		} else if (this.male == true && this.age >= 8) {
			team = "Cool boys";
		} else if (this.male == false && this.age < 8) {
			team = "Small girls";
		} else if (this.male == false && this.age >= 8) {
			team = "Tweens";
		}
		return team;
	}

}
