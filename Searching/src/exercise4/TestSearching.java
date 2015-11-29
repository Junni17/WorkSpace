package exercise4;

import java.util.ArrayList;

public class TestSearching {

	public static void main(String[] args) {

		ArrayList<Player> players = new ArrayList<>();
		Player p1 = new Player("Jonas", 180, 64, 36);
		Player p2 = new Player("Kurt", 160, 58, 51);
		Player p3 = new Player("Noob", 200, 100, 62);
		Player p4 = new Player("Henrik", 188, 80, 77);
		Player p5 = new Player("Per", 192, 82, 81);
		Player p6 = new Player("Mads", 182, 76, 84);
		players.add(p1);
		players.add(p2);
		players.add(p3);
		players.add(p4);
		players.add(p5);
		players.add(p6);

		System.out.println(p1.findPlayerLinear(players, 77));
		System.out.println(p1.findPlayerBinary(players, 77));
		System.out.println(p1.findPlayerName(players));

	}

}
