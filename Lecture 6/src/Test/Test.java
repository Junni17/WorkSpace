package Test;

import java.util.Scanner;

public class Test {

	// loops

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Numbers: ");
		double cumulative_sum = 0;
		String output_cumulative_sum = "";
		while (input.hasNextDouble()) {
			double input_number = input.nextDouble();
			cumulative_sum += input_number;
			output_cumulative_sum += String.format("%s ", String.valueOf(cumulative_sum));
		}
		input.close();
		System.out.println(output_cumulative_sum);
	}
}

// double derp = 148.7;
//
// System.out.println(derp % 10);
//
// // // calculate sum of 1+2+3+ ...... +100
// // int i = 0;
// // int sum = 0;
// // while (i <= 100) {
// // sum = sum + i;
// // i++;
// // }
// // System.out.println("Sum is: " + sum);
// // System.out.println("End of program");
// }
