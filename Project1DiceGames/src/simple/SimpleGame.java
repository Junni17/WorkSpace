package simple;

import java.util.Scanner;

public class SimpleGame
{
    /**
     * Simulates playing one game of Simple.
     */
    public void play()
    {
        Scanner scanner = new Scanner(System.in);
        SimplePlayer player = new SimplePlayer();
        String s1 = "n";
        boolean play = true;

        while(play == true) {
        	player.throwDie();
        	System.out.format(player.throwResult() + "%nDo you wish to play again? (Y/n)%n");
        	String str = scanner.nextLine();
        	if (str.equalsIgnoreCase(s1)){
        		play = false;
        		System.out.format(
        				"The total amount of points: %d%nThe total times rolled: %d%nThe average of points: %.2f%n",
        				player.gettotalPoints(), player.getthrowCount(),
        				(double) player.gettotalPoints() / player.getthrowCount());
        	}       	
        }
        
        scanner.close();
    }

    /**
     * Prints the rules of Simple.
     */
    public void printRules()
    {
        System.out.println("=================================================");
        System.out.println("Rules of Simple:");
        System.out.println("The player throws the die as long as he/she wants.");
        System.out.println("=================================================");
    }

}
