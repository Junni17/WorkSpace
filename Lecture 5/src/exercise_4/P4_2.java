package exercise_4;

import java.util.Scanner;

public class P4_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input number: ");
		double a = scanner.nextDouble();
		if (a == 0) {
			System.out.println("Zero");
		} else if (a > 0 && a < 1) {
			System.out.println("Small");
		} else if (a >= 1 && a <= 1000000) {
			System.out.println("Positive");
		} else if (a > 1000000) {
			System.out.println("Large");
		} else if (a < 0) {
			System.out.println("Negative");
		}
		scanner.close();
	}

}
