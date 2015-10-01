package exercises;

import java.util.Arrays;

public class ArrayTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		int[] values = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
		int[] value = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
		int[] hasUnevenCheck = { 0, 1, 4, 6 };

		double[] values2 = { 22.5, 11.3, 671.325, 0.999, 91.2 };

		System.out.println("Values + value: " + Arrays.toString(ArrayTest.sumArraysUneven(values, value)));
		System.out.println("Does it contain an uneven number: " + ArrayTest.hasUneven(hasUnevenCheck));

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

	public static int[] sumArrays(int[] a, int[] b) {

		// if they have the same length
		int[] sum = new int[a.length];
		if (a.length == b.length) {

			for (int i = 0; i < a.length; i++) {
				sum[i] = a[i] + b[i];

			}

		}
		return sum;

	}

	public static int[] sumArraysUneven(int[] a, int[] b) {

		int length = Math.max(a.length, b.length);
		int[] sum = new int[length];
		for (int i = 0; i < Math.min(a.length, b.length); i++) {
			sum[i] = a[i] + b[i];
		}
		for (int i = Math.min(a.length, b.length); i < length; i++) {
			if (a.length > b.length) {
				sum[i] = a[i];
			} else if (b.length > a.length) {
				sum[i] = b[i];
			}
		}
		return sum;
	}

	public static boolean hasUneven(int[] t) {
		boolean hasUneven = false;
		for (int i = 0; i < t.length; i++) {
			if (t[i] % 2 != 0) {
				hasUneven = true;
			}
		}
		return hasUneven;
	}

}
