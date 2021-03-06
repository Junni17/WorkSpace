package studentArray;

public class Student {
	private String name;
	private int[] grades;// containing the student's grades
	private int gradeCount;// the current number of grades

	private static final int MAX_GRADE_COUNT = 10;// maximum number of grades

	public Student(String name) {
		this.name = name;
		this.grades = new int[Student.MAX_GRADE_COUNT];
		this.gradeCount = 0;
	}

	public String getName() {
		return this.name;
	}

	public int[] getGrades() {
		return this.grades;
	}

	public int getGradeCount() {
		return this.gradeCount;
	}

	public void addGrade(int grade) {
		if (this.gradeCount < MAX_GRADE_COUNT) {
			this.gradeCount++;
			this.grades[this.gradeCount - 1] = grade;
		}
	}

	public double getAverage() {
		int sum = 0;
		for (int i = 0; i < MAX_GRADE_COUNT; i++) {
			sum += this.grades[i];
		}
		return sum / this.gradeCount;
	}

	public int maxGrade() {
		int maxGrade = this.grades[0];
		for (int i = 1; i < MAX_GRADE_COUNT; i++) {
			if (maxGrade < this.grades[i]) {
				maxGrade = this.grades[i];
			}
		}
		return maxGrade;
	}

	public int minGrade() {
		int minGrade = this.grades[0];
		for (int i = 1; i < this.gradeCount; i++) {
			if (minGrade > this.grades[i]) {
				minGrade = this.grades[i];
			}
		}
		return minGrade;
	}

	public int[] getCurrentGrades() {
		int[] currentGrades = new int[this.gradeCount];
		for (int i = 0; i < this.gradeCount; i++) {
			currentGrades[i] = this.grades[i];
		}
		return currentGrades;
	}
}
