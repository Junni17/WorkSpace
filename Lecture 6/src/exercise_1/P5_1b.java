package exercise_1;

public class P5_1b {
	public static void main(String[] args) {
		double a = 1;
		double sum = 0;
		while (a <= 100) {
			sum = sum + Math.pow(a, 2);
			a++;
		}
		System.out.println("Sum of all squares: " + sum);
	}

}
