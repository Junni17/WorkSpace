package ex2student;

import java.util.ArrayList;

public class Ex2 {
	/**
	 * Tests all the methods.
	 */
	public static void main(String[] args) {
		ArrayList<Integer> ints = new ArrayList<Integer>();
		ints.add(12);
		ints.add(0);
		ints.add(45);
		ints.add(7);
		ints.add(-16);
		ints.add(0);
		ints.add(23);
		ints.add(-10);
		System.out.println("ints: " + ints);
		System.out.println();

		// Test of sum() method: correct sum is 61.
		int total = Ex2.sum(ints);
		System.out.println("Sum: " + total);

		// Test of minimum() method: correct minimum is -16.
		System.out.println("Minimum: " + Ex2.minimum(ints));

		// Test of maximum() method: correct maximum is 45.
		System.out.println("Maximum: " + Ex2.maximum(ints));

		// Test of average() method: correct average is 7.625.
		System.out.println("Average: " + Ex2.average(ints));

		// Test of zeroes() method: correct number of zeroes is 2.
		System.out.println("Zeroes: " + Ex2.zeroes(ints));

		// Test of evens() method: correct result is [12, 0, -16, 0, -10].
		System.out.println("Evens: " + Ex2.evens(ints));
	}

	/**
	 * Returns the sum of all numbers in the list. Returns 0, if the list is
	 * empty.
	 */
	public static int sum(ArrayList<Integer> list) {
		int total = 0;
		for (int number : list) {
			total = total + number;
		}
		return total;
	}

	/**
	 * Returns the minimum of all numbers in the list. Requires: The list is not
	 * empty.
	 */
	public static int minimum(ArrayList<Integer> list) {
		int min = 0;
		if (list.isEmpty() != true) {
			min = list.get(0);
			for (int number : list) {
				if (number < min) {
					min = number;
				}
			}
		}
		return min;
	}

	/**
	 * Returns the maximum number in the list.
	 */
	public static int maximum(ArrayList<Integer> list) {
		int max = 0;
		if (list.isEmpty() != true) {
			max = list.get(0);

			for (int number : list) {
				if (number > max) {
					max = number;
				}
			}
		}
		return max;
	}

	/**
	 * Returns the average of the numbers in the list.
	 */
	public static double average(ArrayList<Integer> list) {
		double total = 0;
		double size = 0;
		if (list.isEmpty() != true) {
			for (int number : list) {
				total = total + number;
				size++;
			}
		}
		return total / size;
	}

	/**
	 * Returns the zeroes in the list.
	 */
	public static int zeroes(ArrayList<Integer> list) {
		int zeroes = 0;
		if (list.isEmpty() != true) {
			for (int number : list) {
				if (number == 0) {
					zeroes++;
				}
			}
		}
		return zeroes;
	}

	/**
	 * Returns the even numbers in the list.
	 */
	public static ArrayList<Integer> evens(ArrayList<Integer> list) {
		ArrayList<Integer> evens = new ArrayList<Integer>();
		if (list.isEmpty() != true) {
			for (int number : list) {
				if (number % 2 == 0) {
					evens.add(number);
				}
			}
		}
		return evens;
	}

}
