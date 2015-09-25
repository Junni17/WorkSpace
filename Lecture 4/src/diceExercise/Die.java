package diceExercise;

public class Die {
	private int faceCount;
	private int faceValue;

	// ikke sikker på, hvad denne her gør
	public Die() {
		this(6);
	}

	public Die(int sides) {
		this.faceCount = sides;
		this.faceValue = 1;
	}

	// ikke sikker på, hvorfor lægger 1 til
	public int roll() {
		this.faceValue = (int) (Math.random() * this.faceCount + 1);
		return this.faceValue;
	}

	public void setFaceValue(int value) {
		if (1 <= value && value <= this.faceCount) {
			this.faceValue = value;
		}
	}

	public int getFaceValue() {
		return this.faceValue;
	}

}