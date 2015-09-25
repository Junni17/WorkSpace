package exercise_4;

import java.util.Scanner;

public class P4_1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Input integer: ");
		int a = in.nextInt();
		if (a < 0) {
			System.out.println("Integer is negative");
		} else if (a == 0) {
			System.out.println("Interger is zero");
		} else if (a > 0) {
			System.out.println("Interger is positive");
		}
		in.close();
		
	}

}
