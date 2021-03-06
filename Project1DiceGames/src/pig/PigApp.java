package pig;

import java.util.Scanner;

public class PigApp {
	
	public static void main(String[] args)
	{
		
	Scanner sc = new Scanner(System.in);
	System.out.println("Please set max score! 0 for default.");
	
	PigGame game;
	int maxScore = sc.nextInt();
	
	if (maxScore == 0){
		game = new PigGame();
	}else{
		game = new PigGame(maxScore);
	}
	
	System.out.format("You set the max score to: %d%n", game.getmaxScore());
	System.out.println("Have fun playing pigs!");
	System.out.println("The game has begun!");
	
	game.play();
	
	System.out.println("Thank you for playing Pigs!");
	
	sc.close();
	
	}

}
