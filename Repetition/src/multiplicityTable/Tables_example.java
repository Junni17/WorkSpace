package multiplicityTable;

public class Tables_example {
	public int wah = 12;

	public static void main(String[] args) {

		final int rows_Max = 4;
		final int x_Max = 10;

		for (int n = 1; n <= rows_Max; n++) {
			System.out.printf("%10d", n);
		}
		System.out.println();

		for (int n = 1; n <= rows_Max; n++) {
			System.out.printf("%10s", "x");
		}
		System.out.println();
		System.out.println();

		for (double x = 1; x <= x_Max; x++) {

			for (int n = 1; n <= rows_Max; n++) {
				System.out.printf("%10.0f", Math.pow(x, n));
			}
			System.out.println();

		}

	}

}
