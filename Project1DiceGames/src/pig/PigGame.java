package pig;

import java.util.Scanner;

public class PigGame {

	private int maxScore;

	public PigGame() {
		this(100);
	}

	public PigGame(int maxScore) {
		this.maxScore = maxScore;
	}

	public int getmaxScore() {
		return this.maxScore;
	}

	public void play() {

		Scanner sc = new Scanner(System.in);
		String str = "";
		PigPlayer p1 = new PigPlayer();
		PigPlayer p2 = new PigPlayer();

		while (p1.getPlay() == true || p2.getPlay() == true) {

			while (p1.getPlay() == true) {
				p1.throwDie();
				System.out.format("%nYou rolled: %d%n", p1.getTempPoint());
				if (p1.getPoint() + p1.getSum() < this.maxScore) {
					if (p1.getTempPoint() == 1) {
						p1.setPlay(false);
						p2.setPlay(true);
						p1.setPoint(0);
						System.out
								.format("Player 1 your turn has ended, you lost your points.%nYour score is now %d%n================================%n"
										+ "Player 2 you're up!%n", p1.getSum());
					} else {
						System.out.format("Player 1 your current point is: %d%nYour current score is: %d%n"
								+ "Do you want to throw again? {Y/N}%n", p1.getPoint(), p1.getSum());
						str = sc.nextLine();
						if (str.equalsIgnoreCase("n")) {
							p1.setPlay(false);
							p2.setPlay(true);
							p1.setSum(p1.getSum() + p1.getPoint());
							p1.setPoint(0);
							System.out.format("Player 1 your current score is: %d%n================================%n"
									+ "Player 2 you're up!%n", p1.getSum());
						}
					}
				} else {
					System.out.format("Player 1 has won!%n");
					p1.setPlay(false);
					p2.setPlay(false);
				}

			}

			while (p2.getPlay() == true) {
				p2.throwDie();
				System.out.format("%nYou rolled: %d%n", p2.getTempPoint());
				if (p2.getPoint() + p2.getSum() < this.maxScore) {
					if (p2.getTempPoint() == 1) {
						p2.setPlay(false);
						p1.setPlay(true);
						p2.setPoint(0);
						System.out
								.format("Player 2 your turn has ended, you lost your points.%nYour score is now %d%n================================%n"
										+ "Player 1 you're up!%n", p2.getSum());
					} else {
						System.out.format("Player 2 your current point is: %d%nYour current score is: %d%n"
								+ "Do you want to throw again? {Y/N}%n", p2.getPoint(), p2.getSum());
						str = sc.nextLine();
						if (str.equalsIgnoreCase("n")) {
							p2.setPlay(false);
							p1.setPlay(true);
							p2.setSum(p2.getSum() + p2.getPoint());
							p2.setPoint(0);
							System.out.format(
									"Player 2 your current score is: %d%n================================%nPlayer 1 you're up!%n",
									p2.getSum());

						}
					}
				} else {
					System.out.format("Player 2 has won!%n");
					p2.setPlay(false);
				}
			}
		}
		sc.close();
	}
}
