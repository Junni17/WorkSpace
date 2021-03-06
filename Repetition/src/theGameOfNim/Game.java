package theGameOfNim;

import java.util.Random;
import java.util.Scanner;

public class Game {

	Random RANDOM = new Random();
	private int initial_size_of_pile;
	private int first_turn;
	private int hard_mode;
	private boolean play;

	public Game() {
		this.initial_size_of_pile = this.RANDOM.nextInt(100 - 10) + 10;
		this.first_turn = this.RANDOM.nextInt(2);
		this.hard_mode = this.RANDOM.nextInt(2);
	}

	public void play() {

		Scanner scanner = new Scanner(System.in);

		System.out.println(this.initial_size_of_pile + " marbles have been added to the game!");
		if (this.hard_mode == 0) {
			System.out.println("Difficulity has been set to stupid!");
		} else {
			System.out.println("Difficulity has been set to smart!");
		}
		System.out.println("=======================================");
		System.out.println();

		if (this.first_turn == 0) {
			System.out.println("The user starts!");
			this.play = true;
		} else {
			System.out.println("The computer starts!");
			this.play = false;
		}

		System.out.println();

		while (this.initial_size_of_pile > 1) {

			// User's turn

			while (this.play == true && this.initial_size_of_pile > 1) {
				System.out.println("There currently are " + this.initial_size_of_pile
						+ " marbles. How many do you want to take? (Max: " + (this.initial_size_of_pile / 2) + ")");
				int input = scanner.nextInt();
				while (input > (this.initial_size_of_pile / 2) || input < 1) {
					System.out.println("You can't take more than " + (this.initial_size_of_pile / 2)
							+ " marbles or less than one.");
					input = scanner.nextInt();
				}
				System.out
						.println("You took " + input + " marble(s)! " + (this.initial_size_of_pile - input) + " left!");
				this.initial_size_of_pile -= input;
				if (this.initial_size_of_pile == 1) {
					System.out.println("The user has won!");
					this.play = false;
					break;
				} else {
					System.out.println("It's now the computer's turn!");
					System.out.println("=============================");
					this.play = false;
				}
			}

			// Computer's turn

			while (this.play == false && this.initial_size_of_pile > 1) {

				// hard mode

				if (this.hard_mode == 1) {

					int computer_input;

					if ((this.initial_size_of_pile - 63) <= (this.initial_size_of_pile / 2)
							&& (this.initial_size_of_pile - 63) > 0) {
						computer_input = (this.initial_size_of_pile - 63);
						this.initial_size_of_pile -= computer_input;
					} else if ((this.initial_size_of_pile - 31) <= (this.initial_size_of_pile / 2)
							&& (this.initial_size_of_pile - 31) > 0) {
						computer_input = (this.initial_size_of_pile - 31);
						this.initial_size_of_pile -= computer_input;
					} else if ((this.initial_size_of_pile - 15) <= (this.initial_size_of_pile / 2)
							&& (this.initial_size_of_pile - 15) > 0) {
						computer_input = (this.initial_size_of_pile - 15);
						this.initial_size_of_pile -= computer_input;
					} else if ((this.initial_size_of_pile - 7) <= (this.initial_size_of_pile / 2)
							&& (this.initial_size_of_pile - 7) > 0) {
						computer_input = (this.initial_size_of_pile - 7);
						this.initial_size_of_pile -= computer_input;
					} else if ((this.initial_size_of_pile - 3) <= (this.initial_size_of_pile / 2)
							&& (this.initial_size_of_pile - 3) > 0) {
						computer_input = (this.initial_size_of_pile - 3);
						this.initial_size_of_pile -= computer_input;
					} else {
						computer_input = (int) ((Math.random() * (this.initial_size_of_pile / 2)) + 1);
						this.initial_size_of_pile -= computer_input;
					}

					System.out.println("The computer took " + computer_input + " marble(s). "
							+ this.initial_size_of_pile + " left!");

					if (this.initial_size_of_pile == 1) {
						System.out.println("The computer has won!");
						this.play = true;
						break;

					} else {

						System.out.println("It's now the player's turn!");
						System.out.println("=============================");

						this.play = true;
					}

					// easy mode

				} else {

					int computer_input = (int) ((Math.random() * (this.initial_size_of_pile / 2)) + 1);
					this.initial_size_of_pile -= computer_input;

					System.out.println("The computer took " + computer_input + " marble(s). "
							+ this.initial_size_of_pile + " left!");

					if (this.initial_size_of_pile == 1) {
						System.out.println("The computer has won!");
						this.play = true;
						break;

					} else {

						System.out.println("It's now the player's turn!");
						System.out.println("=============================");

						this.play = true;
					}
				}
			}

		}
		scanner.close();
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.play();
	}

}
