package exercise_1;

public class P5_1c {
	public static void main(String[] args) {
		int a = 0;
		double sum = 0;
		while (a <= 20) {
			sum = Math.pow(2, a);
			System.out.println("2^" + a + " is: " + sum);
			a++;
		}
	}

}
