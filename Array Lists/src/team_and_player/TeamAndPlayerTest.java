package team_and_player;

public class TeamAndPlayerTest {

	public static void main(String[] args) {

		Team team = new Team("Swag");
		Player p1 = new Player(22, "Jonas");
		p1.addScore(100);
		Player p2 = new Player(17, "Hansi");
		p2.addScore(79);
		Player p3 = new Player(31, "Andoras");
		p3.addScore(2);
		Player p4 = new Player(25, "Ben");
		p4.addScore(88);
		Player p5 = new Player(32, "John Snow");
		p5.addScore(100);

		team.addPlayer(p1);
		team.addPlayer(p2);
		team.addPlayer(p3);
		team.addPlayer(p4);
		team.addPlayer(p5);

		team.printPlayers();
		System.out.println();
		System.out.println("Average age on the team: " + team.calcAverageAge());
		System.out.println("Total score of the team: " + team.calcTotalScore());
		System.out.println("Players older than 30 score: " + team.calcOldPlayersScore(30));
		System.out.println("Highest score obtainted: " + team.maxScore());
		System.out.println("Players with the highest score obtained: " + team.bestPlayerNames());
	}

}
