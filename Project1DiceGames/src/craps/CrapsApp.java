package craps;

import java.util.Scanner;

public class CrapsApp {
	public static void main(String[] args) {
		CrapsGame game = new CrapsGame();
		System.out.format("Welcome to the game of Craps%n");
		game.printRules();

		Scanner sc = new Scanner(System.in);

		System.out.format("%nAre you ready to play? (Y/N)%n");

		String s1 = sc.nextLine();

		while (!s1.equalsIgnoreCase("n")) {

			game.play();

			System.out.println("Do you want to play again? (Y/N)");
			s1 = sc.nextLine();

		}

		sc.close();

		System.out.format("Thank you for playing craps.%n");
		System.out.format("You had %d wins and %d losses%n", game.getWins(), game.getLoss());
	}
}
