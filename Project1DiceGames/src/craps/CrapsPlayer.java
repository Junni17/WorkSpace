package craps;

public class CrapsPlayer
{
    // die to be rolled
    private Die die1;
    // die to be rolled
    private Die die2;
    // point set at first throw
    private int point;
    // whether last throw was a win
    private boolean won;
    // whether last throw was a loss
    private boolean lost;

    /**
     * Creates a new player.
     */
    public CrapsPlayer()
    {
        die1 = new Die();
        die2 = new Die();
        this.point = 0;
        this.won = false;
        this.lost = false;
    }

    
    public int getPoint()
    {
    	return this.point;
    }
    
    public int getSum()
    {
    	return die1.getfaceValue() + die2.getfaceValue();
    }
    
    public boolean getWon()
    {
    	return this.won;
    }
    
    public boolean getLost()
    {
    	return this.lost;
    }
    
    
    /**
     * Returns true, if the player has won.
     */
    public boolean hasWon(boolean won)
    {
        return this.won = won;
    }

    /**
     * Returns true, if the player has lost.
     */
    public boolean hasLost(boolean lost)
    {
        return this.lost = lost;
    }

    /**
     * Throws the dice - first throw.
     */
    public void firstThrow()
    {
        die1.roll();
        die2.roll();
        point = die1.getfaceValue() + die2.getfaceValue();
    }

    /**
     * Throws the dice - second and following throws.
     */
    public void nextThrow()
    {
        	die1.roll();
        	die2.roll();
    }
    
    

    /**
     * Returns a description of the result of the last throw.
     */
    public String diceResult()
    {
        return "(" + die1.getfaceValue() + ", " + die2.getfaceValue() + ") The sum of the roll: " + this.getSum();
    }
}
