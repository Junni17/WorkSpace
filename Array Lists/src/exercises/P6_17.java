package exercises;

import java.util.ArrayList;
import java.util.Scanner;

public class P6_17 {

	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	
	double max_value = 1000;
	double asterisks_count = (40/max_value);
	ArrayList<String> inputs = new ArrayList<String>();
	
	System.out.println("Min value: 0 - Max value: 1000");
	System.out.println("Inputs: ");
	double input = scanner.nextDouble();
	while (input > 0 && input <= max_value){
		System.out.println("Input caption: ");
		String s1 = scanner.next() + " ";
		int temp = (int) (asterisks_count * input);
		for (int i = 1; i <= temp; i++){
			s1 += String.valueOf('*');
			}
		inputs.add(s1);
		System.out.println("Input value: ");
		input = scanner.nextDouble();
	}
	
	for (String element : inputs){
		System.out.println(element);
	}
	scanner.close();

	}

}

