package ex2ex3ex4student;

public class PersonTester {

	public static void main(String[] args) {

		Person p1 = new Person("Andersen", "Jonas", 4, 6, 1993);
		p1.calcAge(1994, 6, 4);
		System.out.println(p1.leapYear(2100));
		System.out.println(p1.calcWeekday("Boo", 1992));
	}

}
