package craps;

public class Die
{
    // number of faces
    private int faceCount;
    // value of upper face
    private int faceValue;

    /**
     * Creates a die with 6 faces and a random face value.
     */
    public Die()
    {
        this(6);
    }

    /**
     * Creates a die with the given face count and a random face value.
     */
    public Die(int faceCount)
    {
        this.faceCount = faceCount;
        this.faceValue = (int) (Math.random() * this.faceCount + 1);
    }

    public int getfaceCount()
    {
    	return this.faceCount;
    }
    
    public int getfaceValue()
    {
    	return this.faceValue;
    }

    /**
     * Rolls the die, resulting in a new face value.
     */
    public void roll()
    {
        this.faceValue = (int) (Math.random() * this.faceCount + 1);
    }

}