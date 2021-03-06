package exercises;

public class Exercise2 {

	public static void main(String[] args) {

		final int STUDENTS = 8;
		final int QUESTIONS = 10;

		char[][] answers = new char[STUDENTS][QUESTIONS];
		char[] correct_answers = new char[QUESTIONS];

		// The array containing the students' answers.
		for (int i = 0; i < STUDENTS; i++) {
			for (int j = 0; j < QUESTIONS; j++) {
				int answer_calc = (int) (Math.random() * 4) + 1;
				if (answer_calc == 1) {
					answers[i][j] = 'A';
				} else if (answer_calc == 2) {
					answers[i][j] = 'B';
				} else if (answer_calc == 3) {
					answers[i][j] = 'C';
				} else if (answer_calc == 4) {
					answers[i][j] = 'D';
				}
			}
		}

		// The array containing the right answers
		for (int i = 0; i < QUESTIONS; i++) {
			int answer_calc = (int) (Math.random() * 4) + 1;
			if (answer_calc == 1) {
				correct_answers[i] = 'A';
			} else if (answer_calc == 2) {
				correct_answers[i] = 'B';
			} else if (answer_calc == 3) {
				correct_answers[i] = 'C';
			} else if (answer_calc == 4) {
				correct_answers[i] = 'D';
			}
		}

		// Printing the students answers array:
		for (int i = 0; i < STUDENTS; i++) {
			System.out.printf("Student " + (i + 1) + ":");
			for (int j = 0; j < QUESTIONS; j++) {
				System.out.printf("%5s", answers[i][j]);
			}
			System.out.println();
			System.out.println("-------------------------------------------------------------");
		}

		System.out.println();

		// Printing the correct answers array:
		System.out.printf("Solution: ");
		for (int i = 0; i < QUESTIONS; i++) {
			System.out.printf("%5s", correct_answers[i]);
		}

		int[] students_correct_answers = new int[STUDENTS];

		// Finding the amount of correct answers for each student
		for (int i = 0; i < STUDENTS; i++) {
			int correct = 0;
			for (int j = 0; j < QUESTIONS; j++) {
				if (answers[i][j] == correct_answers[j]) {
					correct++;
				}
			}
			students_correct_answers[i] = correct;
		}
		System.out.println();

		// Printing the amount of correct answers for each student
		for (int i = 0; i < STUDENTS; i++) {
			System.out.printf("%nStudent " + (i + 1) + " correct answers: %2d ", students_correct_answers[i]);
		}

		int[] questions_correct_answers = new int[QUESTIONS];

		// Finding the number of correct answers for each question
		for (int i = 0; i < QUESTIONS; i++) {
			int correct = 0;
			for (int j = 0; j < STUDENTS; j++) {
				if (answers[j][i] == correct_answers[i]) {
					correct++;
				}
			}
			questions_correct_answers[i] = correct;
		}

		System.out.println();

		// Printing how many times a question has been answered correctly
		for (int i = 0; i < QUESTIONS; i++) {
			System.out.printf("%nQuestion " + (i + 1) + " correct answers: %2d", questions_correct_answers[i]);
		}
	}

}
