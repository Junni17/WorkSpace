package multiplicityTable;

public class MultiplicationTable {

	public static void main(String[] args) {

		final int rows_max = 10;

		for (int n = 1; n <= rows_max; n++) {
			System.out.printf("%5d", n);

			for (int p = 2; p <= rows_max; p++) {
				System.out.printf("%5d", n * p);
			}

			System.out.println();
		}

	}

}
