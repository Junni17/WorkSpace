package exercise3;

import java.util.Arrays;

public class Sequence {

	private int[] values;

	public Sequence(int size) {
		this.values = new int[size];
	}

	public int[] getValues() {
		return this.values;
	}

	public void set(int i, int n) {
		this.values[i] = n;
	}

	public boolean equals(Sequence other) {
		boolean equals = true;
		if (other.values.length == this.values.length) {
			for (int i = 0; i < other.values.length; i++) {
				if (other.values[i] != this.values[i]) {
					equals = false;
				}
			}
		} else {
			equals = false;
		}

		return equals;
	}

	public int[] smallest(Sequence a) {
		int[] temp;
		if (a.values.length < this.values.length) {
			temp = a.values;
		} else if (a.values.length > this.values.length) {
			temp = this.values;
		} else {
			temp = this.values;
		}
		return temp;
	}

	public int[] biggest(Sequence a) {
		int[] temp;
		if (a.values.length > this.values.length) {
			temp = a.values;
		} else if (a.values.length < this.values.length) {
			temp = this.values;
		} else {
			temp = a.values;
		}
		return temp;
	}

	// sameValues done in a way I know about

	public boolean sameValues(Sequence a) {
		boolean sameValues1 = false;
		int[] biggest = biggest(a);
		int[] smallest = smallest(a);

		for (int i = 0; i < smallest.length; i++) {
			sameValues1 = false;
			for (int j = 0; j < biggest.length; j++) {
				if (smallest[i] == biggest[j]) {
					sameValues1 = true;
				}
			}
			if (sameValues1 == false) {
				break;
			}
		}

		if (sameValues1 == true) {
			for (int i = 0; i < biggest.length; i++) {
				sameValues1 = false;
				for (int j = 0; j < smallest.length; j++) {
					if (biggest[i] == smallest[j]) {
						sameValues1 = true;
					}
				}
				if (sameValues1 == false) {
					break;
				}
			}
		}

		return sameValues1;
	}

	// sameValues done with HashSet

	// public boolean sameValues(Sequence a) {
	// Integer[] temp = new Integer[a.values.length];
	// for (int i = 0; i < a.values.length; i++) {
	// temp[i] = a.values[i];
	// }
	//
	// Integer[] temp1 = new Integer[this.values.length];
	// for (int i = 0; i < this.values.length; i++) {
	// temp1[i] = this.values[i];
	// }
	//
	// HashSet<Integer> set1 = new HashSet<Integer>(Arrays.asList(temp));
	// HashSet<Integer> set2 = new HashSet<Integer>(Arrays.asList(temp1));
	// return set1.equals(set2);
	//
	// }

	public boolean isPermutationOf(Sequence a) {
		int[] biggest = biggest(a);
		int[] smallest = smallest(a);

		Arrays.sort(biggest);
		Arrays.sort(smallest);
		return Arrays.equals(biggest, smallest);
	}

	public void print() {
		System.out.println(Arrays.toString(this.values));
	}
}
