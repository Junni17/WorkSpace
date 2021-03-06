package team_and_player;

import java.util.ArrayList;

public class Team {

	private String name;
	private ArrayList<Player> players;

	public Team(String name) {
		this.name = name;
		this.players = new ArrayList<Player>();
	}

	public String getName() {
		return this.name;
	}

	public ArrayList<Player> getPlayers() {
		return this.players;
	}

	public void addPlayer(Player p) {
		this.players.add(p);
	}

	public void printPlayers() {
		for (Player element : this.players) {
			System.out.println(
					"Name: " + element.getName() + " - Age: " + element.getAge() + " - Score: " + element.getScore());
		}
	}

	public double calcAverageAge() {
		double total = 0;
		double count = 0;

		for (Player element : this.players) {
			total += element.getAge();
			count++;
		}

		return total / count;
	}

	public int calcTotalScore() {
		int total = 0;
		for (Player element : this.players) {
			total += element.getScore();
		}
		return total;
	}

	public int calcOldPlayersScore(int ageLimit) {
		int total = 0;
		for (Player element : this.players) {
			if (element.getAge() > ageLimit) {
				total += element.getScore();
			}
		}
		return total;
	}

	public int maxScore() {
		int maxScore = 0;
		for (Player element : this.players) {
			if (element.getScore() > maxScore) {
				maxScore = element.getScore();
			}
		}
		return maxScore;
	}

	public ArrayList<String> bestPlayerNames() {
		ArrayList<String> bestPlayers = new ArrayList<String>();
		int maxScore = 0;
		for (Player element : this.players) {
			if (element.getScore() > maxScore) {
				maxScore = element.getScore();
			}
		}
		for (Player element : this.players) {
			if (element.getScore() == maxScore) {
				bestPlayers.add(element.getName());
			}
		}
		return bestPlayers;
	}

}
