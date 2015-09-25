package exercise_2;

public class ChildTester {

	public static void main(String[] args) {
		Child child1 = new Child(15, false);
		child1.setAge(3);
		System.out.println(child1.institution());
		System.out.println(child1.gender());
		System.out.println(child1.team());
	}

}
