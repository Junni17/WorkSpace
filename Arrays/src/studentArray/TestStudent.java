package studentArray;

import java.util.Arrays;

public class TestStudent {
	public static void main(String[] args) {
		Student s1 = new Student("Hanne");
		Student s2 = new Student("Margrethe");

		System.out.println(s1.getName());
		s1.addGrade(10);
		s1.addGrade(30);
		s1.addGrade(20);
		s1.addGrade(5);
		s1.addGrade(90);
		s1.addGrade(1);
		s1.addGrade(54);
		System.out.println("Hanne, Grades: " + Arrays.toString(s1.getGrades()));
		System.out.println("Hanne, Average: " + s1.getAverage());
		System.out.println("Hanne, MaxGrade: " + s1.maxGrade());
		System.out.println("Hanne, MinGrade: " + s1.minGrade());
		System.out.println("Hanne, CurrentGrades: " + Arrays.toString(s1.getCurrentGrades()));
		System.out.println(s2.getName());

	}
}
