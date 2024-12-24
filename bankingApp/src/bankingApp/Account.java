package bankingApp;

public class Account {
	private String AccountNo;
	private String AccountholderName;
	private double Balance;
	private String Password;

	public Account(String accountNo, String accountholderName, double balance, String password) {
		AccountNo = accountNo;
		AccountholderName = accountholderName;
		Balance = balance;
		Password = password;
	}

	public String getAccountNo() {
		return AccountNo;
	}

	public void setAccountNo(String accountNo) {
		AccountNo = accountNo;
	}

	public void setAccountholderName(String accountholderName) {
		AccountholderName = accountholderName;
	}

	public void setBalance(double balance) {
		Balance = balance;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getAccountholderName() {
		return AccountholderName;
	}

	public double getBalance() {
		return Balance;
	}

	public String getPassword() {
		return Password;
	}

	public String toString() {
		return "Account [AccountNo=" + AccountNo + ", accountHolderName=" + AccountholderName + ", balance=" + Balance
				+ "]";
	}
	/*
	 * public void deposit(double amnt) { if (amnt > 0) { Balance += amnt;
	 * System.out.println("Amount deposited succesfully.Thank you."); } else {
	 * System.out.println("Kindly enter valid amount"); } }
	 */

}
