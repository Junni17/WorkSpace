package exercise5;

public class SequenceTest {

	public static void main(String[] args) {

		Sequence s1 = new Sequence();

		int i = 1;
		while (i < 30) {
			s1.add(i);
			i += 2 * i;
		}

		Sequence s2 = new Sequence();
		s2.add(10);
		s2.add(3);
		s2.add(4);
		s2.add(16);
		s2.add(6);

		System.out.println("s1: " + s1.toString());
		System.out.println("s2: " + s2.toString());

		Sequence derp = s1.append(s2);
		System.out.println("s1 and s2 appended: " + derp.toString());
		Sequence merged = s1.merge(s2);
		System.out.println("s1 and s2 merged: " + merged.toString());

	}

}
