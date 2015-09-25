package pig;

public class PigPlayer 
{
	private Die die1;
	private int point;
	private int temp_point;
	private int sum;
	private boolean play;
	
	public PigPlayer()
	{
		die1 = new Die();
		point = 0;
		temp_point = 0;
		sum = 0;
		play = true;
	}
	
	public int getTempPoint()
	{
		return temp_point;
	}
	
	public int getPoint()
	{
		return point;
	}
	
	public void setPoint(int point)
	{
		this.point = point;
	}
	
	public int getSum()
	{
		return sum;
	}
	
	public void setSum(int sum)
	{
		this.sum = sum;
	}
	
	
	public boolean getPlay() 
	{
		return play;
	}


	public void setPlay(boolean play)
	{
		this.play = play;
	}


	public void throwDie()
	{
		die1.roll();
		temp_point = die1.getfaceValue();
		point += die1.getfaceValue();
		
	}

}
