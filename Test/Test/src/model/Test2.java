package model;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		Scanner derp = new Scanner(System.in);
		System.out.println("Input integer: ");
		int c = derp.nextInt();

		int max = c;
		int min = c;

		int odd = 0;
		int even = 0;

		if (c % 2 == 0) {
			even++;
		} else {
			odd++;
		}

		while (c != 0) {
			System.out.println("Input integer: ");
			c = derp.nextInt();

			if (c > max && c != 0) {
				max = c;
			}
			if (c < min && c != 0) {
				min = c;
			}

			if (c % 2 == 0) {
				even++;
			} else {
				odd++;
			}

		}

		System.out.println("Biggest value was: " + max);
		System.out.println("Smallesst value was: " + min);
		System.out.println("Even values: " + even);
		System.out.println("Odd values: " + odd);
		derp.close();

	}

}
