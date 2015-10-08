package whileReading;

import java.util.Arrays;

public class SwitchingTheLastHalfWithTheFirst {

	public static void main(String[] args) {

		int[] switching = { 1, 2, 3, 4, 5, 6, 7, 8 };

		int i = 0;
		int j = 4;
		while (i < switching.length / 2) {
			int temp = switching[i];
			switching[i] = switching[j];
			switching[j] = temp;
			i++;
			j++;
		}

		System.out.println(Arrays.toString(switching));

	}

}
