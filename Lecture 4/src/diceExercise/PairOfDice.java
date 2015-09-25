package diceExercise;

public class PairOfDice {

	// fields
	private int value;
	private int value2;
	private int rollnumber;
	private int sixes;
	private int samefaces;

	// begge terninger har 12 sider
	Die die1 = new Die(12);
	Die die2 = new Die(12);

	public void rollbothdice() {
		this.value = this.die1.roll();
		this.value2 = this.die2.roll();
		this.rollnumber++;
		if (this.value == 6) {
			this.sixes++;
		}
		if (this.value2 == 6) {
			this.sixes++;
		}
		if (this.value == this.value2) {
			this.samefaces++;
		}
	}

	@Override
	public String toString() {
		String values = "(" + this.value + "," + this.value2 + ")";
		return values;
	}

	public int sumofdice() {
		int values = this.value + this.value2;
		return values;
	}

	public int getsixes() {
		return this.sixes;
	}

	public int getsamefaces() {
		return this.samefaces;
	}

	public int getrollnumber() {
		return this.rollnumber;
	}
}