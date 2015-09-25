package exd3_employee;

public class EmployeeApp {
	public static void main(String[] args) {
		Employee e1 = new Employee("Hans", "Jensen", 51);
		e1.printEmployee();

		e1.setName1("Viggo");
		e1.hasBirthday();
		e1.setTrainee(false);
		e1.setAge(78);
		e1.setName2("Bitch Slap Joe");
		e1.printEmployee();
	}

}
