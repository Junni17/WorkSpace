package exercise3;

import java.util.Arrays;

public class SequenceTest {

	public static void main(String[] args) {

		Sequence s1 = new Sequence(9);
		s1.set(0, 1);
		s1.set(1, 4);
		s1.set(2, 9);
		s1.set(3, 16);
		s1.set(4, 9);
		s1.set(5, 7);
		s1.set(6, 4);
		s1.set(7, 9);
		s1.set(8, 11);

		Sequence s2 = new Sequence(9);
		s2.set(0, 11);
		s2.set(1, 11);
		s2.set(2, 7);
		s2.set(3, 9);
		s2.set(4, 16);
		s2.set(5, 4);
		s2.set(6, 1);
		s2.set(7, 4);
		s2.set(8, 9);

		System.out.println("Are they the same: " + s1.isPermutationOf(s2));
		System.out.println("Smallest: " + Arrays.toString(s1.smallest(s2)));

		System.out.println("Biggest: " + Arrays.toString(s1.biggest(s2)));
	}

}
