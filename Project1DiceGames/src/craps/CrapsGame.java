package craps;

public class CrapsGame
{
    /**
     * Simulates playing the game of craps.
     */
	
	private int wins = 0;
	private int losses = 0;
	
    public void play()
    {
    	CrapsPlayer p1 = new CrapsPlayer();
    	
    	//first throw ------------------------------------ 
        	
        	p1.firstThrow();
        	System.out.println(p1.diceResult());
            
        	if (p1.getSum() == 7 || p1.getSum() == 11){
            	this.gameWon();
            	this.wins ++;
            
            }else if (p1.getSum() == 2 || p1.getSum() == 3 || p1.getSum() == 12){
            	this.gameLost();
            	this.losses ++;
            
            }else {
            	
            	System.out.println("Point is: " + p1.getPoint());
            	
            	//second throw --------------------------------
            	
            	while (!p1.getWon() && !p1.getLost()){ 
            		
            		p1.nextThrow();
            		
                	System.out.println(p1.diceResult());
            
            		if (p1.getSum() == p1.getPoint()){
            			this.gameWon();
            			p1.hasWon(true);
            			this.wins++;
            		}else if (p1.getSum() == 7){
            			this.gameLost();
            			p1.hasLost(true);
            			this.losses++;
            		}
            	}
            }
        }
    
    
        	
    
    

    /**
     * Prints a 'You have won' message.
     */
    public void gameWon()
    {
        System.out.format("You have won!%n");
    }

    /**
     * Prints a 'You have lost' message.
     */
    public void gameLost()
    {
        System.out.format("You have lost!%n");
    }

    /**
     * Prints the rules of craps.
     */
    public void printRules()
    {
        System.out.format("%nIn the game a player throws 2 dice. The first throw is called 'the come out roll'.%n"
        		+ "The player wins, if the sum of the dice is 7 or 11. The player loses, %n"
        		+ "if the sum is 2, 3 or 12. If the sum is something else (that is, 4, 5, %n"
        		+ "6, 8, 9 or 10) the sum is set as the player's 'point'. The player will %n"
        		+ "now continue throwing the dice until he has lost or won. A sum equal his%n"
        		+ "'point' is a win, and a sum equal 7 is a loss.%n");
    }
    
    public int getLoss(){
    	return this.losses;
    }
    
    public int getWins(){
    	return this.wins;
    }
}
