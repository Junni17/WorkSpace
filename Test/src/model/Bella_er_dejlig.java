package model;

public class Bella_er_dejlig {

	public static void main(String[] args) {

		String a = "Bella er sød";
		String b = "Bella er dejlig";
		String c = "Bella er min kæreste <3";
		String d = "Bella er smuk";
		String e = "Bella er klog";
		String f = "Bella er fantastisk";

		boolean jeg_er_glad_for_Bella = true;

		int random = 6;
		int derp;

		while (jeg_er_glad_for_Bella = true) {
			derp = (int) (Math.random() * random + 1);
			if (derp == 1) {
				System.out.println(a);
			} else if (derp == 2) {
				System.out.println(b);
			} else if (derp == 3) {
				System.out.println(c);
			} else if (derp == 4) {
				System.out.println(d);
			} else if (derp == 5) {
				System.out.println(e);
			} else if (derp == 6) {
				System.out.println(f);
			}
		}
	}
}
