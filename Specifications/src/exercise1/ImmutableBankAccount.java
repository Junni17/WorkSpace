package exercise1;

public class ImmutableBankAccount {

	private final double BALANCE;

	public ImmutableBankAccount(double balance) {
		this.BALANCE = balance;
	}

	/**
	 * Adds amount to balance. Requires: amount > 0.
	 */
	public ImmutableBankAccount deposit(double amount) {
		assert amount > 0;
		ImmutableBankAccount a1 = new ImmutableBankAccount(this.BALANCE + amount);
		return a1;
	}

	/**
	 * Withdraws given amount from the account. Requires: amount <= balance,
	 * amount > 0.
	 */
	public ImmutableBankAccount withdraw(double amount) {
		assert amount <= this.BALANCE && amount > 0;
		ImmutableBankAccount a1 = new ImmutableBankAccount(this.BALANCE - amount);
		return a1;
	}

	/**
	 * Returns the balance of the account.
	 */
	public double getBalance() {
		return this.BALANCE;
	}
}
