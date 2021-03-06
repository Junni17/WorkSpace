package classDiagrams;

public class BankAccount {

	private int number;
	private int balance;
	private String accountType;

	public BankAccount(String accountType, int balance, int number) {
		this.accountType = accountType;
		this.balance = balance;
		this.number = number;
	}

	public void addFunds(int amount) {
		this.balance += amount;
	}

	public void withdrawFunds(int amount) {
		if ((this.balance - 2000) < amount) {
			System.out.println("You don't have enough money!");
		} else {
			this.balance -= amount;
		}
	}

	public String getAccountType() {
		return this.accountType;
	}

	public int getNumber() {
		return this.number;
	}

	public int getBalance() {
		return this.balance;
	}

}
