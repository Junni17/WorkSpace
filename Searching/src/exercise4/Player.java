package exercise4;

import java.util.ArrayList;

public class Player {

	private String name;
	private int height;
	private int weight;
	private int scoredGoals;

	public Player(String name, int height, int weight, int scoredGoals) {
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.scoredGoals = scoredGoals;
	}

	public String getName() {
		return this.name;
	}

	public int getHeight() {
		return this.height;
	}

	public int getWeight() {
		return this.weight;
	}

	public int getScoredGoals() {
		return this.scoredGoals;
	}

	public Player findPlayerLinear(ArrayList<Player> players, int score) {
		Player player = null;
		boolean found = false;
		int i = 0;
		while (!found && i < players.size()) {
			if (players.get(i).getScoredGoals() == score) {
				player = players.get(i);
				found = true;
			}
			i++;
		}
		return player;
	}

	public Player findPlayerBinary(ArrayList<Player> players, int score) {
		Player player = null;
		boolean found = false;
		int right = players.size() - 1;
		int left = 0;
		while (!found && left <= right) {
			int middle = (left + right) / 2;
			if (players.get(middle).getScoredGoals() == score) {
				player = players.get(middle);
				found = true;
			} else if (score > players.get(middle).getScoredGoals()) {
				left = middle + 1;
			} else if (score < players.get(middle).getScoredGoals()) {
				right = middle - 1;
			}
		}
		return player;
	}

	public String findPlayerName(ArrayList<Player> players) {
		String playerNames = "";
		int i = 0;
		while (i < players.size()) {
			if (players.get(i).getHeight() < 170 && players.get(i).getScoredGoals() > 50) {
				playerNames += players.get(i).getName() + " ";
			}
			i++;
		}
		return playerNames;

	}

	@Override
	public String toString() {
		return this.name + " , " + this.height + " cm, " + this.weight + " kg, " + this.scoredGoals + " goals scored";
	}

}
