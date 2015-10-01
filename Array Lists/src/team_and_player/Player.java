package team_and_player;

public class Player {

	private String name;
	private int age;
	private int score;

	public Player(int age, String name) {
		this.name = name;
		this.age = age;
		this.score = 0;
	}

	public int getAge() {
		return this.age;
	}

	public String getName() {
		return this.name;
	}

	public int getScore() {
		return this.score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void addScore(int score) {
		this.score += score;
	}

}
