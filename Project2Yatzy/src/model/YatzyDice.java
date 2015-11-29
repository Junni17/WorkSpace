package model;

import java.util.ArrayList;
import java.util.Random;

public class YatzyDice {
	// Face values of the 5 dice.
	// 1 <= values[i] <= 6.
	private int[] values = new int[5];

	// Number of times the 5 dice have been thrown.
	// 0 <= throwCount <= 3.
	private int throwCount = 0;

	// Random number generator.
	private Random random = new Random();

	public YatzyDice() {

	}

	/**
	 * Returns the 5 face values of the dice.
	 */
	public int[] getValues() {
		int[] temp = this.values;
		return temp;
	}

	/**
	 * Sets the 5 face values of the dice.<br/>
	 * Req: values contains 5 face values in [1..6].<br/>
	 * Note: This method is only meant to be used for test,<br/>
	 * and therefore has package visibility.
	 */
	void setValues(int[] values) {
		this.values = values;
	}

	/**
	 * Returns the number of times the 5 dice has been thrown.
	 */
	public int getThrowCount() {
		return this.throwCount;
	}

	/**
	 * Resets the throw count.
	 */
	public void resetThrowCount() {
		this.throwCount = 0;
	}

	/**
	 * Rolls the 5 dice. Only rolls dice that are not hold.<br/>
	 * Req: holds contain 5 boolean values.
	 */
	public void throwDice(boolean[] holds) {

		for (int i = 0; i < 5; i++) {
			if (!holds[i]) {
				this.values[i] = this.random.nextInt(6) + 1;
			} else {
				this.values[i] = this.values[i];
			}
		}

		this.throwCount++;
	}

	// -------------------------------------------------------------------------

	/**
	 * Returns all results possible with the current face values.<br/>
	 * The order of the results is the same as on the score board.<br/>
	 * Note: This is an optional method. Comment this method out,<br/>
	 * if you don't want use it.
	 */
	public int[] getResults() {
		int[] results = new int[15];
		for (int i = 0; i <= 5; i++) {
			results[i] = this.sameValuePoints(i + 1);
		}
		results[6] = this.onePairPoints();
		results[7] = this.twoPairPoints();
		results[8] = this.threeSamePoints();
		results[9] = this.fourSamePoints();
		results[10] = this.fullHousePoints();
		results[11] = this.smallStraightPoints();
		results[12] = this.largeStraightPoints();
		results[13] = this.chancePoints();
		results[14] = this.yatzyPoints();

		return results;
	}

	// -------------------------------------------------------------------------

	// Returns an int[7] containing the frequency of face values.
	// Frequency at index v is the number of dice with the face value v, 1 <= v
	// <= 6.
	// Index 0 is not used.
	private int[] calcCounts() {
		int[] results = new int[7];
		int[] temp = this.getValues();
		int number = 1;
		int counter = 0;
		while (number < 7) {
			for (int i = 0; i < 5; i++) {
				if (temp[i] == number) {
					counter++;
				}
			}
			results[number] = counter;
			number++;
			counter = 0;
		}
		return results;
	}

	/**
	 * Returns same-value points for the given face value.<br/>
	 * Returns 0, if no dice has the given face value.<br/>
	 * Requires: 1 <= value <= 6;
	 */
	public int sameValuePoints(int value) {
		int result = 0;
		int[] temp = this.getValues();
		for (int i = 0; i < 5; i++) {
			if (temp[i] == value) {
				result += value;
			}
		}
		return result;
	}

	/**
	 * Returns points for one pair (for the face value giving highest points).
	 * <br/>
	 * Returns 0, if there aren't 2 dice with the same face value.
	 */
	public int onePairPoints() {
		int[] results = this.calcCounts();
		int points = 0;
		for (int i = 1; i < 7; i++) {
			if (results[i] > 1) {
				if (i * 2 > points) {
					points = i * 2;
				}
			}

		}
		return points;
	}

	/**
	 * Returns points for two pairs<br/>
	 * (for the 2 face values giving highest points).<br/>
	 * Returns 0, if there aren't 2 dice with one face value<br/>
	 * and 2 dice with a different face value.
	 */
	public int twoPairPoints() {
		int[] results = this.calcCounts();
		ArrayList<Integer> pairs = new ArrayList<>();
		int points1 = 0;
		int points2 = 0;
		int faceValue = 6;

		for (int i = 1; i < 7; i++) {
			if (results[i] > 1) {
				pairs.add(i);
			}
		}

		if (pairs.size() > 1) {

			while (faceValue > 0) {
				if (points1 == 0 && points2 == 0) {
					if (pairs.contains(faceValue)) {
						points1 += faceValue * 2;

					}
				} else if (points1 != 0 && points2 == 0) {
					if (pairs.contains(faceValue)) {
						points2 += faceValue * 2;
						break;
					}
				}

				faceValue--;
			}
		}
		return points1 + points2;
	}

	/**
	 * Returns points for 3 of a kind.<br/>
	 * Returns 0, if there aren't 3 dice with the same face value.
	 */
	public int threeSamePoints() {
		int[] results = this.calcCounts();
		int points = 0;
		for (int i = 1; i < 7; i++) {
			if (results[i] > 2) {
				if (i * 3 > points) {
					points = i * 3;
				}
			}

		}
		return points;
	}

	/**
	 * Returns points for 4 of a kind.<br/>
	 * Returns 0, if there aren't 4 dice with the same face value.
	 */
	public int fourSamePoints() {
		int[] results = this.calcCounts();
		int points = 0;
		for (int i = 1; i < 7; i++) {
			if (results[i] > 3) {
				if (i * 4 > points) {
					points = i * 4;
				}
			}

		}
		return points;
	}

	/**
	 * Returns points for full house.<br/>
	 * Returns 0, if there aren't 3 dice with one face value<br/>
	 * and 2 dice a different face value.
	 */
	public int fullHousePoints() {
		int[] results = this.calcCounts();

		int points1 = 0;
		int points2 = 0;

		for (int i = 0; i < 7; i++) {
			if (results[i] == 3) {
				points1 = i * 3;
			} else if (results[i] == 2) {
				points2 = i * 2;
			}

		}

		if (points1 == 0 || points2 == 0) {
			return 0;
		} else {
			return points1 + points2;
		}
	}

	/**
	 * Returns points for small straight.<br/>
	 * Returns 0, if the dice are not showing 1,2,3,4,5.
	 */
	public int smallStraightPoints() {
		int[] results = this.calcCounts();
		int counter = 0;

		for (int i = 1; i < 6; i++) {
			if (results[i] == 1) {
				counter++;
			}
		}

		if (counter == 5) {
			return 15;
		} else {
			return 0;
		}
	}

	/**
	 * Returns points for large straight.<br/>
	 * Returns 0, if the dice is not showing 2,3,4,5,6.
	 */
	public int largeStraightPoints() {

		int[] results = this.calcCounts();
		int counter = 0;

		for (int i = 2; i < 7; i++) {
			if (results[i] == 1) {
				counter++;
			}
		}

		if (counter == 5) {
			return 20;
		} else {
			return 0;
		}
	}

	/**
	 * Returns points for chance.
	 */
	public int chancePoints() {
		int[] temp = this.getValues();
		int points = 0;

		for (int i = 0; i < temp.length; i++) {
			points += temp[i];
		}

		return points;
	}

	/**
	 * Returns points for yatzy.<br/>
	 * Returns 0, if there aren't 5 dice with the same face value.
	 */
	public int yatzyPoints() {
		int[] results = this.calcCounts();
		int points = 0;
		for (int i = 1; i < 7; i++) {
			if (results[i] > 4) {
				points = 50;
			}

		}
		return points;
	}

}