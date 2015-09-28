package bookExercises;

import java.util.Arrays;

public class Exercise1 {

	// Create a class with a main() method. Add code to the main() method to
	// fill 8 arrays with the
	// following values:
	// a. 0 0 0 0 0 0 0 0 0 0
	// b. 2 44 -23 99 8 -5 7 10 20 30
	// c. 0 1 2 3 4 5 6 7 8 9
	// d. 2 4 6 8 10 12 14 16 18 20
	// e. 1 4 9 16 25 36 49 64 81 100
	// f. 0 1 0 1 0 1 0 1 0 1
	// g. 0 1 2 3 4 0 1 2 3 4
	// h. 0 3 4 7 8 11 12 15 16 19
	// Use a for loop in c) - h) to fill the array. (To print an array, use
	// Arrays.toString()).

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		// a. 0 0 0 0 0 0 0 0 0 0
		int[] arrayA = new int[10];

		// b. 2 44 -23 99 8 -5 7 10 20 30
		int[] arrayB = { 2, 44, -23, 99, 8, -5, 7, 10, 20, 30 };

		// c. 0 1 2 3 4 5 6 7 8 9
		int[] arrayC = new int[10];
		for (int i = 0; i < 10; i++) {
			arrayC[i] = i;

		}
		// System.out.println(Arrays.toString(arrayC));

		// d. 2 4 6 8 10 12 14 16 18 20
		int[] arrayD = new int[10];
		for (int i = 0; i < 10; i++) {
			arrayD[i] = i * 2 + 2;

		}
		// System.out.println(Arrays.toString(arrayD));

		// e. 1 4 9 16 25 36 49 64 81 100
		int[] arrayE = new int[10];
		for (int i = 0; i < 10; i++) {
			arrayE[i] = (int) Math.pow(i + 1, 2);
		}
		// System.out.println(Arrays.toString(arrayE));

		// f. 0 1 0 1 0 1 0 1 0 1
		int[] arrayF = new int[10];
		for (int i = 0; i < 10; i++) {
			if (i % 2 != 0) {
				arrayF[i] = 1;
			} else {
				arrayF[i] = 0;
			}
		}
		// System.out.println(Arrays.toString(arrayF));

		// g. 0 1 2 3 4 0 1 2 3 4
		int[] arrayG = new int[10];
		for (int i = 0; i < 10; i++) {
			if (i <= 4) {
				arrayG[i] = i;
			} else {
				arrayG[i] = i - 5;
			}
		}
		// System.out.println(Arrays.toString(arrayG));

		// h. 0 3 4 7 8 11 12 15 16 19
		int value = 0;
		int[] arrayH = new int[10];
		for (int i = 0; i < 10; i++) {
			if (i % 2 != 0) {
				value += 2;
			}
			arrayH[i] = value + i;

		}
		System.out.println(Arrays.toString(arrayH));
	}

}
