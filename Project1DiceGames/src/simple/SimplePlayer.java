package simple;

public class SimplePlayer
{
    // die to throw
    private Die die1;
    // number of throws
    private int throwCount;
    // total points collected
    private int totalPoints;

    /**
     * Creates a new SimplePlayer.
     */
    public SimplePlayer()
    {
     this.die1 = new Die();
     this.throwCount = 0;
     this.totalPoints = 0;
    }

   public int getthrowCount()
   {
	   return this.throwCount;
   }
   
   public int gettotalPoints()
   {
	   return this.totalPoints;
   }

    /**
     * Throws the die.
     */
    public void throwDie()
    {
        this.die1.roll();
        this.throwCount++;
        this.totalPoints += this.die1.getfaceValue();
    }

    /**
     * Returns a description of the result of the last throw.
     */
    public String throwResult()
    {
        return "The die showed: " + this.die1.getfaceValue();
    }
}
