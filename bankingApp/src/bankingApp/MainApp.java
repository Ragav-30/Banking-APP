package bankingApp;

import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Banking b = new Banking();
		while (true) {
			displayMenu();
			int Choice = sc.nextInt();

			switch (Choice) {
			case 1:
				createAccount(sc, b);
				break;

			case 2:
				depositAmount(sc, b);
				break;

			case 3:
				// withdrawAmount(sc, b);
				break;

			case 4:
//				checkBalance(sc, b);
				break;

			case 5:
				// deleteAccount(sc, b);
				break;

			case 6:
				System.out.println("Thank you for using RR Banking. Goodbye!");
				sc.close();
				return;

			default:
				System.out.println("Invalid option. Please try again.");
			}
		}

	}

	private static void depositAmount(Scanner sc, Banking b) {
		// TODO Auto-generated method stub
		System.out.print("Enter Account No: ");
		String accountNo = sc.next().trim();

		System.out.print("Enter amount to be deposited: ");
		double amount = sc.nextDouble();
		while (amount <= 0) {
			System.out.println("Amount must be greater than 0. Please enter a valid amount.");
			amount = sc.nextDouble();
		}

		b.depositAmount(accountNo, amount);
	}

	private static void createAccount(Scanner sc, Banking b) {
		// TODO Auto-generated method stub
		System.out.print("Kindly enter your name: ");
		String name = sc.next();

		System.out.print("Kindly enter your initial deposit amount: ");
		double initialDeposit = sc.nextDouble();
		while (initialDeposit <= 0) {
			System.out.println("Amount must be greater than 0. Please enter a valid amount.");
			initialDeposit = sc.nextDouble();
		}

		b.createAccount(name, initialDeposit);
		b.Displayallaccounts();

	}

	private static void displayMenu() {
		System.out.println("Welcome to RR Banking");
		System.out.println("1. Create Account");
		System.out.println("2. Deposit Amount");
		System.out.println("3. Withdraw Amount");
		System.out.println("4. Check Balance");
		System.out.println("5. Delete Account");
		System.out.println("6. Exit");
		System.out.print("Kindly enter the option you want to continue: ");
	}

}
