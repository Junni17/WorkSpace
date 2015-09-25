package model;

import java.util.Scanner;

public class Test3 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner derp = new Scanner(System.in);
		System.out.println("Input integer: ");
		int c = derp.nextInt();
		String cumulative_sum = "Cumulative sum: ";
		String inputs = "Inputs: ";
		int sum = c;

		cumulative_sum += String.valueOf(c) + " ";
		inputs += String.valueOf(c) + " ";

		while (c != 0) {
			System.out.println("Input integer: ");
			c = derp.nextInt();
			if (c != 0) {
				sum += c;
				cumulative_sum += String.valueOf(sum) + " ";
				inputs += String.valueOf(c) + " ";
			}
		}

		System.out.println(inputs);
		System.out.println(cumulative_sum);
		derp.close();
	}

}
