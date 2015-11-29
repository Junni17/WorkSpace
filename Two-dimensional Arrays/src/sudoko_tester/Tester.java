package sudoko_tester;

import java.util.Arrays;

public class Tester {

	static int[][] soduko = { { 9, 6, 3, 1, 7, 4, 2, 5, 8 }, { 1, 7, 8, 3, 2, 5, 6, 4, 9 },
			{ 2, 5, 4, 6, 8, 9, 7, 3, 1 }, { 8, 2, 1, 4, 3, 7, 5, 9, 6 }, { 4, 9, 6, 8, 5, 2, 3, 1, 7 },
			{ 7, 3, 5, 9, 6, 1, 8, 2, 4 }, { 5, 8, 9, 7, 1, 3, 4, 6, 2 }, { 3, 1, 7, 2, 4, 6, 9, 8, 5 },
			{ 6, 4, 2, 5, 9, 8, 1, 7, 3 } };

	static boolean correct = true;

	public static void main(String[] args) {

		Tester.testAllCol();
		Tester.testAllRows();
		Tester.testAllSquares();

		if (correct == true) {
			System.out.println("The sudoko is correct!");
		}
	}

	// checking one square
	public static boolean testSquare(int col, int row) {
		String s = "";
		boolean correct = true;
		for (int i = col; i < col + 3; i++) {
			for (int j = row; j < row + 3; j++) {

				if (s.contains(Integer.toString(soduko[i][j]))) {
					correct = false;
				}
				s += soduko[i][j];
			}
		}
		return correct;
	}

	// checking all squares
	public static void testAllSquares() {
		boolean incorrect = false;
		String errors = "Square errors: ";
		for (int i = 0; i < 9; i = i + 3) {
			for (int j = 0; j < 9; j = j + 3) {
				if (Tester.testSquare(i, j) == false) {
					errors += "(" + i + "," + j + ")" + " ";
					incorrect = true;
					correct = false;
				}
			}
		}
		if (incorrect == true) {
			System.out.println(errors);
		}

	}

	// checking one row
	public static boolean testRow(int row) {
		int[] temp = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] temp2 = new int[9];
		for (int i = 0; i < 9; i++) {
			temp2[i] = soduko[i][row];
		}
		Arrays.sort(temp2);
		return Arrays.equals(temp, temp2);

	}

	// checking all rows
	public static void testAllRows() {
		boolean incorrect = false;
		String errors = "Row errors: ";
		for (int row = 0; row < 9; row++) {
			if (Tester.testRow(row) == false) {
				errors += "" + row + " ";
				incorrect = true;
				correct = false;
			}
		}
		if (incorrect == true) {
			System.out.println(errors);
		}
	}

	// checking one column
	public static boolean testCol(int col) {
		int[] temp = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] temp2 = new int[9];
		for (int i = 0; i < 9; i++) {
			temp2[i] = soduko[col][i];
		}
		Arrays.sort(temp2);
		return Arrays.equals(temp, temp2);

	}

	// checking all columns
	public static void testAllCol() {
		boolean incorrect = false;
		String errors = "Column errors: ";
		for (int col = 0; col < 9; col++) {
			if (Tester.testCol(col) == false) {
				errors += "" + col + " ";
				incorrect = true;
				correct = false;
			}
		}
		if (incorrect == true) {
			System.out.println(errors);
		}
	}

}
