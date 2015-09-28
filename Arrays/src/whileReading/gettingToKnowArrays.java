package whileReading;

import java.util.Arrays;

public class gettingToKnowArrays {

	public static void main(String[] args) {

		int currentSize = 10;
		double[] values = new double[currentSize];
		for (int i = 0; i < currentSize; i++) {
			values[i] = i;
		}
		System.out.println(Arrays.toString(values));

		int position = 4;

		// removing a value from the array

		for (int i = position + 1; i < currentSize; i++) {
			values[i - 1] = values[i];

		}
		currentSize--;

		System.out.println(Arrays.toString(values));

		// adding a value at the end of the array

		// if (currentSize < values.length) {
		// currentSize++;
		// values[currentSize - 1] = 20;
		// }
		// System.out.println(Arrays.toString(values));

		// adding a value at a specific location (we need a companion variable
		// to determine the size of the array, as I've done above as well).

		if (currentSize < values.length) {
			currentSize++;
			for (int i = currentSize - 1; i > position; i--) {
				values[i] = values[i - 1];
			}
			values[position] = 20;
		}
		System.out.println(Arrays.toString(values));

		// swapping elements
		double temp = values[0];
		values[0] = values[currentSize - 1];
		values[currentSize - 1] = temp;

		System.out.println(Arrays.toString(values));

		// for (int i = 0; i < 11; i++) {
		// System.out.println(values[i]);
		// }
		// double sum = 0;for(
		// double element:values)
		//
		// {
		// this.sum = this.sum + this.element;
		// } System.out.println(sum);
		//
		// int position = 4;
		// int currentSize = 10;for(
	}

}
