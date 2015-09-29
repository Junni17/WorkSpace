package Exercises;

import java.util.Arrays;

public class ArrayTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		int[] values = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
		int[] value = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };

		double[] values2 = { 22.5, 11.3, 671.325, 0.999, 91.2 };

		System.out.println("Values + value: " + Arrays.toString(ArrayTest.sumArrays(values, value)));

		// System.out.println("Values: " + Arrays.toString(values));
		// System.out.println("Values2: " + Arrays.toString(values2));
		//
		// System.out.println("Sum of values: " + ArrayTest.sum(values));
		// System.out.println("Sum of values2: " + ArrayTest.sum(values2));
	}

	public static int sum(int[] t) {
		int total = 0;
		for (int amount : t) {
			total = total + amount;
		}
		return total;
	}

	public static double sum(double[] t) {
		double total = 0;
		for (double amount : t) {
			total = total + amount;
		}
		return total;
	}

	@SuppressWarnings("unused")
	public static int[] sumArrays(int[] a, int[] b) {

		// if they have the same length
		if (a.length == b.length) {
			int[] sum = new int[a.length];
			for (int i = 0; i < a.length; i++) {
				sum[i] = a[i] + b[i];

			}
			return sum;

			// if they have different lengths ???
		} else if (a.length > b.length || b.length > a.length) {
			int length = Math.max(b.length, a.length);

			int[] sum = new int[length];
			for (int i = 0; i < length; i++) {

			}
		}
		return null;

	}

}
