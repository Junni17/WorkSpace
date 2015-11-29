package exercise1;

public class BankAccount {

	private double balance;
	private int accountID;
	private static int IDgenerator = 0;

	public BankAccount(double balance) {
		this.balance = balance;
		this.accountID = IDgenerator + 1;
		IDgenerator++;
	}

	/**
	 * Adds amount to balance. Requires: amount > 0.
	 */
	public void deposit(double amount) {
		assert amount > 0;
		this.balance += amount;
	}

	/**
	 * Withdraws given amount from the account. Requires: amount <= balance,
	 * amount > 0.
	 */
	public void withdraw(double amount) {
		assert amount <= this.balance && amount > 0;
		this.balance -= amount;
	}

	/**
	 * Returns the balance of the account.
	 */
	public double getBalance() {
		return this.balance;
	}

	public int getID() {
		return this.accountID;
	}

	public static int getIDcount() {
		return IDgenerator;
	}

}
