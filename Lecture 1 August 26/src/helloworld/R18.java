package helloworld;

public class R18 {

	// double = decimaltal, int = hele tal

	public static void main(String[] args) {
		double i = 1000;
		double x = i * 5 / 100;
		double z = i + x;
		double y = z + (z * x / i);

		System.out.println("Balance after the 1st year - " + z + "$");
		System.out.println("Balance after the 2nd year - " + y + "$");
		System.out.println("Balance after the 3rd year - " + ((y * x / i) + y) + "$");
		System.out.println("Balance after the 4th year - " + ((((y * x / i) + y) * (x / i)) + ((y * x / i) + y)) + "$");
	}
}