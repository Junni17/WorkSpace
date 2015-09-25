package exercise_4;

import java.util.Scanner;

public class P4_5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input number 1: ");
		double a = scanner.nextDouble();
		System.out.println("Input number 2: ");
		double b = scanner.nextDouble();
		System.out.println("Input number 3: ");
		double c = scanner.nextDouble();
		if (b > a && c > b) {
			System.out.println("Increasing");
		} else if (b < a && c < b) {
			System.out.println("Decreasing");
		} else {
			System.out.println("Neither");
		}
		scanner.close();
	}

}
