package exercise1;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {

		ArrayList<String> actors = new ArrayList<>();
		actors.add("Bryan Cranston");
		actors.add("Some random dude");
		actors.add("Another random dude");

		Series BreakingBad = new Series("Breaking Bad", actors);
		BreakingBad.createEpisode(1, 30, "Morgan Freeman");
		BreakingBad.createEpisode(2, 32, "Jonah Hill");
		BreakingBad.createEpisode(3, 35, "Morgan Freeman");
		BreakingBad.createEpisode(4, 45, "Jonas Andersen");

		System.out.println("The total length: " + BreakingBad.getTotalLength() + " minutes.");
		System.out.println();
		System.out.println("Guest actors:");
		System.out.println(BreakingBad.getGuestActors());

	}

}
