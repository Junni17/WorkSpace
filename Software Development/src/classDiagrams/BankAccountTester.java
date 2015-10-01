package classDiagrams;

public class BankAccountTester {

	public static void main(String[] args) {

		BankAccount mySavings = new BankAccount("Classic", 4500, 1);
		mySavings.addFunds(7000);
		System.out.format("Your current balance: %d%n", mySavings.getBalance());

	}

}
