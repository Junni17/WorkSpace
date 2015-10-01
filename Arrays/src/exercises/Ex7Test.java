package exercises;

import java.util.Arrays;

public class Ex7Test {

	public static void main(String[] args) {

		int[] values = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		
		System.out.println(Arrays.toString(values));
		Ex7Test.shift(values);
		System.out.println("Has doublets: " + Ex7Test.doublets(values));
		System.out.println("Array shift: " + Arrays.toString(Ex7Test.shift(values)));
		System.out.println("Are the elements sorted ascending? " + Ex7Test.ascending(values));
		System.out.println("First and last int switched: " + Arrays.toString(Ex7Test.switching(values)));
		System.out.println("The next highest element: " + Ex7Test.next_highest(values));
		System.out.println("All evens replaced with 0: " + Arrays.toString(Ex7Test.even_numbers(values)));

	}
	
	//switches the first and last element
	public static int[] switching(int[] list) {
		int last_element = list[list.length - 1];
		int temp = list[0];

		list[0] = last_element;
		list[list.length - 1] = temp;

		return list;
	}
	
	//sets all even numbers to zero
	public static int[] even_numbers(int[] list) {
		for (int i = 0; i < list.length; i++) {
			if (list[i] % 2 == 0) {
				list[i] = 0;
			}
		}
		return list;
	}
	
	//return the next highest value
	public static int next_highest(int[] list) {
		int highest = list[0];
		int next_highest = list[0];
		for (int i = 0; i < list.length; i++) {
			if (list[i] > highest) {
				highest = list[i];
			}
		}
		for (int i = 0; i < list.length; i++) {
			if (list[i] < highest && list[i] > next_highest) {
				next_highest = list[i];
			}
		}

		return next_highest;
	}
	
	// checks to see if the digits in the array are sorted ascending
	public static boolean ascending(int[] list){
		boolean ascending = true;
		for (int i = 1; i < list.length; i++){
			if (list[i] <= list[i - 1]){
				ascending = false;
			}
		}
		return ascending;
	}
	
	// shifts all elements to the right, making the last digit the first ...
	public static int[] shift(int[] list){
		int max = list[list.length - 1];
		for(int i = list.length - 1; i > 0; i--){	
			list[i] = list[i - 1];
		}
		list[0] = max;
		return list;
	}
	
	// checks whether the array has doublets, returns true or false
	public static boolean doublets(int[] list){
		int start = 0;
		boolean doublets = false;
		while (start < list.length){
			int counter = 0;
			for (int i = 0; i < list.length; i++){
				if (list[start] == list[i]){
					counter++;
					if(counter > 1){
						doublets = true;
					}
				}
			}
		start++;
		}
		return doublets;
		
	}
}
