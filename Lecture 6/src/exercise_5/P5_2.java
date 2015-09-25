package exercise_5;

import java.util.Scanner;

public class P5_2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Number: ");
		int input = scanner.nextInt();
		int smallest_int = input;
		int largest_int = input;
		int odd_inputs = 0;
		int even_inputs = 0;

		if (input % 2 == 0) {
			even_inputs = even_inputs + 1;
		} else if (input % 2 != 0) {
			odd_inputs = odd_inputs + 1;
		}

		System.out.print("Number: ");

		while (scanner.hasNextInt()) {
			System.out.print("Number: ");
			input = scanner.nextInt();

			if (input % 2 == 0) {
				even_inputs = even_inputs + 1;
			} else if (input % 2 != 0) {
				odd_inputs = odd_inputs + 1;
			}

			if (input < smallest_int) {
				smallest_int = input;
			} else if (input > largest_int) {
				largest_int = input;
			}

		}
		System.out.println("Smallest number: " + smallest_int);
		System.out.println("Largest number: " + largest_int);
		System.out.println("Number of even inputs: " + even_inputs);
		System.out.println("Number of odd inputs: " + odd_inputs);
		scanner.close();
	}
}
