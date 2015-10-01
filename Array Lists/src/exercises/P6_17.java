package exercises;

import java.util.ArrayList;
import java.util.Scanner;

public class P6_17 {

	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	
	double max_value = 1000;
	double asterisks_count = (40/max_value);
	ArrayList<Double> inputs = new ArrayList<Double>();
	
	System.out.println("Min value: 0 - Max value: 1000");
	System.out.println("Inputs: ");
	double input = scanner.nextDouble();
	while (input > 0 && input <= max_value){
	inputs.add(input);
	input = scanner.nextDouble();
	}
	
	for (double element : inputs){
		int temp = (int) (asterisks_count * element);
		String s1 = "";
		for (int i = 1; i <= temp; i++){
		s1 += String.valueOf('*');
		}
		System.out.println(s1);
	}
	scanner.close();

	}

}

