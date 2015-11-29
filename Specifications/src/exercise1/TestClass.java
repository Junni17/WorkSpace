package exercise1;

public class TestClass {

	public static void main(String[] args) {

		// BankAccount account1 = new BankAccount(2000);
		// BankAccount account2 = new BankAccount(3500);
		// BankAccount account3 = new BankAccount(7200);
		// BankAccount account4 = new BankAccount(375);
		//
		// System.out.println(BankAccount.getIDcount());
		// System.out.println(account3.getID());

		ImmutableBankAccount account1 = new ImmutableBankAccount(2500);
		ImmutableBankAccount account2 = new ImmutableBankAccount(400);

		ImmutableBankAccount account3 = account1.deposit(300);
		System.out.println(account3.getBalance());

		ImmutableBankAccount account4 = account2.withdraw(375);
		System.out.println(account4.getBalance());
	}

}
