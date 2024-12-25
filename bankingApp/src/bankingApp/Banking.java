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

	public void withDrawAmount(String acc, String pwd, double amount) {
		// TODO Auto-generated method stub
		acc = acc.trim();
		if (m.containsKey(acc)) {
			Account a = m.get(acc);
			if (pwd.equalsIgnoreCase(a.getPassword())) {
				if (a.getBalance() >= amount) {
					a.setBalance(a.getBalance() - amount);
					System.out.println("Amount withdrawn " + amount + " Current Balance: " + a.getBalance());
				} else {
					System.out.println("Insufficient balance to withdraw.");
				}
			} else {
				System.out.println("Wrong password. Kindly enter correct password. Thank you.");
				return;
			}
		} else {
			System.out.println("The Account No doesn't exists. Kindly check and enter your Account No");
		}
	}

	public void checkBalanceAmnt(String s, String a) {
		// TODO Auto-generated method stub
		if (m.containsKey(s)) {
			Account p = m.get(s);
			if (a.equalsIgnoreCase(p.getPassword())) {
				System.out.println("Your current balance is: " + p.getBalance());
			} else {
				System.out.println("Kindly enter correct password to continue. ");
				return;
			}
		} else {
			System.out.println("The Account No doesn't exists. Kindly check and enter your Account No");
		}
	}

	public void deleteAccount(String acc, String pwd) {
		// TODO Auto-generated method stub
		if (m.containsKey(acc)) {
			Account a = m.get(acc);
			if (pwd.equalsIgnoreCase(a.getPassword())) {
				m.remove(acc);
				System.out.println("Your Account is permanently deleted. Thanks for using our service.");
			} else {
				System.out.println("Kindly enter correct password to continue. ");
				return;
			}
		} else {
			System.out.println("The Account No doesn't exists. Kindly check and enter your Account No");
		}
	}

}
