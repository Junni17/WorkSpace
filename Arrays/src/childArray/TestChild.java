package childArray;

import java.util.Arrays;

public class TestChild {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Child b1 = new Child("Emma");
		Child b2 = new Child("Oliver");

		System.out.println(b1.getName());
		b1.setWeight(1, 1);
		b1.setWeight(2, 2);
		b1.setWeight(3, 3);
		b1.setWeight(4, 4);
		b1.setWeight(5, 5);
		b1.setWeight(6, 6);
		b1.setWeight(7, 7);
		b1.setWeight(8, 8);
		b1.setWeight(10, 9);
		b1.setWeight(11, 10);
		b1.setWeight(20, 11);

		System.out.println(Arrays.toString(b1.getWeights()));
		System.out.println(b1.maxYearlyWeighGain());
		System.out.println(b1.getWeight(5));

	}

}
