package exercise_4;

import java.util.Scanner;

public class P5_1e {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Input integer: ");
		int a = in.nextInt();
		int sum = 0;
		while (a != 0) {

			// (f.eks) int b = 148 % 10 = 8
			// int b er derfor = 0, derfor lægges b i dette tilfælde ikke til
			// sum

			int b = a % 10;
			if (b % 2 != 0) {
				sum = sum + b;
			}

			// (f.eks - bruger 148 eksemplet) 148 / 10 = 14, da a er en integer
			// næste gang loopet køres igennem er a = 14

			a = a / 10;
		}
		System.out.println("The sum of the integer's odd numbers: " + sum);

	}

}
