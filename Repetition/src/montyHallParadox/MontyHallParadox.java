package montyHallParadox;

import java.util.Random;

public class MontyHallParadox {

	Random RANDOM = new Random();
	private int doors;
	private int change_count;
	private int stay_count;

	public MontyHallParadox() {
		this.doors = 3;
	}

	public void play() {
		int choose = this.RANDOM.nextInt(this.doors) + 1;
		int solution = this.RANDOM.nextInt(this.doors) + 1;

		if (choose != solution) {
			this.change_count++;
		} else {
			this.stay_count++;
		}
	}

	public static void main(String[] args) {

		MontyHallParadox game = new MontyHallParadox();
		for (int i = 0; i < 1000; i++) {
			game.play();
		}

		System.out.println("How many times you need to change door in order to win: " + game.change_count);
		System.out.println("How many times you need to not change door in order to win: " + game.stay_count);

	}

}
