package bankingApp;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Banking {

	String accountNo;
	String password;
	Scanner sc = new Scanner(System.in);
	Map<String, Account> m = new HashMap<>();
	Random random = new Random();

	private String generateAccountNo() {

		do {
			accountNo = String.valueOf(1000000000L + Math.abs(random.nextLong(9000000000L)));
		} while (m.containsKey(accountNo));

		return accountNo;
	}

	public void createAccount(String Name, double initialDeposit) {
		accountNo = generateAccountNo();
		password = generatePassword();
		Account a = new Account(accountNo, Name, initialDeposit, password);
		m.put(accountNo, a);
		System.out.println("Account Created Succesfully");
		System.out.println("Kindly find your Account No " + accountNo.trim());
		System.out.println("Kindly save your Account No for future use");
	}

	private String generatePassword() {
		// TODO Auto-generated method stub
		System.out.println("Kindly enter your Password");
		String pass = sc.next();
		return pass;
	}

	public void depositAmount(String accountNo, double amnt) {
		accountNo = accountNo.trim();
		if (m.containsKey(accountNo)) {
			Account q = m.get(accountNo);
			q.setBalance(q.getBalance() + amnt);
			System.out.println("Kindly find your new Balance : " + q.getBalance());
		} else {
			System.out.println("Account not found");
		}
	}

	public void Displayallaccounts() {
		// TODO Auto-generated method stub
		System.out.println("Accounts: " + m.keySet());
	}

}
