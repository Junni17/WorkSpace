package model;

import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {
		Scanner derp = new Scanner(System.in);
		System.out.println("Input integer: ");
		int c = derp.nextInt();
		String adjacent_dublicates = "Adjacent dublicates: ";
		int previous_number = c;

		// hvad sker der her?
		boolean first_input = true;

		while (c != 0) {
			System.out.println("Input integer: ");
			c = derp.nextInt();
			// hvad sker der her med first input?
			if (first_input != true && c == previous_number) {
				adjacent_dublicates += String.valueOf(previous_number);
			}
			previous_number = c;

			// hvad sker der her - igen?
			first_input = false;
		}

		System.out.println(adjacent_dublicates);
		derp.close();
	}

}
