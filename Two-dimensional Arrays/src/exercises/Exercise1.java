package exercises;

public class Exercise1 {

	public static void main(String[] args) {

		int[][] array = { { 0, 4, 3, 9, 6 }, { 1, 3, 5, 2, 2 }, { 3, 3, 1, 0, 1 }, { 0, 0, 9, 7, 1 } };

		Exercise1.print(array);
		System.out.println("Sum of row 3: " + Exercise1.sumRow(array, 3));
		System.out.println("Sum of column 4: " + Exercise1.sumColumn(array, 4));
		System.out.println("Sum of the array: " + Exercise1.sum(array));
	}

	public static void print(int[][] number) {
		for (int i = 0; i < number.length; i++) {
			for (int j = 0; j < number[0].length; j++) {
				System.out.print(number[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int getValueAt(int[][] number, int row, int col) {
		return number[row][col];
	}

	public static void setValue(int[][] number, int row, int col, int value) {
		number[row][col] = value;
	}

	public static int sumRow(int[][] number, int row) {
		int sum = 0;
		for (int i = 0; i < number[0].length; i++) {
			sum += number[row][i];
		}
		return sum;
	}

	public static int sumColumn(int[][] number, int col) {
		int sum = 0;
		for (int i = 0; i < number.length; i++) {
			sum += number[i][col];
		}
		return sum;
	}

	public static int sum(int[][] number) {
		int sum = 0;
		for (int i = 0; i < number.length; i++) {
			for (int j = 0; j < number[0].length; j++) {
				sum += number[i][j];
			}
		}
		return sum;
	}

}
