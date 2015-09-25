package exercise_1;

public class P5_1a {
	public static void main(String[] args) {
		int a = 2;
		int sum = 0;
		while (a <= 100) {
			sum = sum + a;
			a++;
		}
		System.out.println("Sum of all even nummbers: " + sum);
	}

}
