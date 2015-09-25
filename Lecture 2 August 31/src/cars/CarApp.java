package cars;

public class CarApp {

	public static void main(String[] args) {
		Car myCar = new Car("VW UP", "White");
		System.out.println(myCar.getBrand());
		myCar.setRegistrationNumber("AB 11 123");
		System.out.println(myCar.getRegistrationNumber());

		Car myCar2 = new Car("Derp Car ", "Black");
		System.out.print(myCar2.getBrand());
		System.out.println(myCar2.getColor());
		myCar2.setRegistrationNumber("JesusTakeTheWheel");
		myCar2.setKm(50);
		System.out.println(myCar2.getRegistrationNumber());
		System.out.println(myCar2.getKm() + " km");

	}

}
