package exercises;

import java.util.Arrays;

public class Ex7Test {

	public static void main(String[] args) {

		int[] values = { 1, 2, 99, 98, 98, 11, 7, 8, 9, 10 };

		System.out.println(Arrays.toString(values));
		System.out.println("First and last int switched: " + Arrays.toString(Ex7Test.switching(values)));
		System.out.println("The next highest element: " + Ex7Test.next_highest(values));
		System.out.println("All evens replaced with 0: " + Arrays.toString(Ex7Test.even_numbers(values)));

	}

	public static int[] switching(int[] list) {
		int last_element = list[list.length - 1];
		int temp = list[0];

		list[0] = last_element;
		list[list.length - 1] = temp;

		return list;
	}

	public static int[] even_numbers(int[] list) {
		for (int i = 0; i < list.length; i++) {
			if (list[i] % 2 == 0) {
				list[i] = 0;
			}
		}
		return list;
	}

	public static int next_highest(int[] list) {
		int highest = list[0];
		int next_highest = list[0];
		for (int i = 0; i < list.length; i++) {
			if (list[i] > highest) {
				highest = list[i];
			}
		}
		for (int i = 0; i < list.length; i++) {
			if (list[i] < highest && list[i] > next_highest) {
				next_highest = list[i];
			}
		}

		return next_highest;
	}

}
