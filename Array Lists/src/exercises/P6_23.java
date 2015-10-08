package exercises;

import java.util.ArrayList;

public class P6_23 {

	public static void main(String[] args) {

		ArrayList<Integer> die_tosses = new ArrayList<Integer>();
		String s1 = "";

		for (int i = 0; i < 20; i++) {
			int die_roll = (int) (Math.random() * 6) + 1;
			die_tosses.add(die_roll);
		}

		boolean inRun = false;
		int i = 0;

		while (i < die_tosses.size()) {
			if (inRun == true) {
				if (die_tosses.get(i) != die_tosses.get(i - 1)) {
					s1 += ")";
					inRun = false;
				}
			}
			if (inRun == false) {
				if (i == die_tosses.size() - 1) {

				} else if (die_tosses.get(i) == die_tosses.get(i + 1)) {
					s1 += "(";
					inRun = true;
				}
			}

			s1 += " " + die_tosses.get(i) + " ";
			i++;

		}
		if (inRun == true) {
			s1 += ")";
		}
		System.out.println(s1);

	}
}
