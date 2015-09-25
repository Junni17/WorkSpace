package exercise_3;

import java.util.Scanner;

public class P5_1d {

	// eksempel på hvordan et for loop kan køres igennem for samme opgave:

	// @SuppressWarnings("resource")
	// public static void main(String[] args) {
	// Scanner n = new Scanner(System.in);
	// System.out.println("Input integer a: ");
	// int a = n.nextInt();
	// System.out.println("Input integer b: ");
	// int b = n.nextInt();
	// int sum = 0;
	// for (int i = Math.min(a, b); i <= Math.max(a, b); i++) {
	// if (i % 2 != 0) {
	// sum = sum + i;
	// }
	// }
	// System.out.println("Sum of odd numbers between the two inputs: " + sum);
	// }

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Input integer a: ");
		int a = in.nextInt();
		System.out.print("Input integer b: ");
		int b = in.nextInt();
		int sum = 0;

		// i er det mindste indtastede integer

		int i = Math.min(a, b);

		// så længe i er mindre eller = den største indtastede integer

		while (i <= Math.max(a, b)) {
			if (i % 2 != 0) {
				sum = sum + i;
			}
			i++;
		}
		System.out.println("Sum of off numbers between the two inputs: " + sum);
	}

}
