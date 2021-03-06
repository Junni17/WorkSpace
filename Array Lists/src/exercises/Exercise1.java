package exercises;

import java.util.ArrayList;

public class Exercise1 {

	public static void main(String[] args) {

		ArrayList<String> names = new ArrayList<String>();
		names.add("Hans");
		names.add("Viggo");
		names.add("Jens");
		names.add("Bente");
		names.add("Bent");

		System.out.println("The size of the list: " + names.size());

		names.add(2, "Jane");

		System.out.println(names);

		names.remove(1);

		names.add(0, "Pia");
		names.add("Ib");

		System.out.println();
		System.out.println(names);
		System.out.println("The size of the list 2: " + names.size());

		names.set(2, "Hansi");
		System.out.println();
		System.out.println("The size of the list 3: " + names.size());
		System.out.println(names);
		System.out.println();

		for (int i = 0; i < names.size(); i++) {
			int length = names.get(i).length();
			System.out.println("Length of word " + i + ": " + length);
		}
		System.out.println();
		for (String element : names) {
			System.out.println((element.length()));
		}

	}

}
