package au_exam;

public class Driver {

	public static void main(String[] args) {

		Tree t1 = new Tree("Pine", 15, true);
		Tree t2 = new Tree("Apple Tree", 10, true);
		Tree t3 = new Tree("Pine", 18, true);
		Tree t4 = new Tree("Ash", 25, true);
		Tree t5 = new Tree("Coast Redwood", 110, true);

		Forrest f1 = new Forrest("My Forrest");
		f1.add(t1);
		f1.add(t2);
		f1.add(t3);
		f1.add(t4);
		f1.add(t5);

		System.out.println(f1.tallestTree("Apple Tree"));
		System.out.println();

		System.out.println(f1.fruitTrees(3));

		System.out.println();

		String fstTree = t1.toString();
		String scndTree = t2.toString();
		String thrdTree = t3.toString();
		String frthTree = t4.toString();
		String fithTree = t5.toString();

		System.out.printf(fstTree + "\n" + scndTree + "\n" + thrdTree + "\n" + frthTree + "\n" + fithTree + "\n");

	}

}
