
import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

/**
 * a class that models an ATM
 * bank account is already logged into on the ATM
 * bank account has an account holder, a bank name,
 * an account number, and a current balance on the account
 * bank account can view account information,
 * deposit, and withdraw money to or from the account 
 * @author Andres Ruiz
 */
public class ATM {
	
	/**
	 * name of account holder
	 */
	private String accountHolder;
	
	/**
	 * name of bank
	 */
	private String bankName;
	
	/**
	 * account number for the account
	 */
	private int accountNumber;
	
	/**
	 * holds current balance for the account
	 */
	private double currentBalance;
	
	/**
	 * constructor constructs bank account info visible from ATM
	 */
	public ATM(final String setAccountHolder, final String setBankName, 
			final int setAccountNumber, final double setCurrentBalance) {
		accountHolder = setAccountHolder;
		bankName = setBankName;
		accountNumber = setAccountNumber;
		currentBalance = setCurrentBalance;
	}
	
	/**
	 * public static double accountInfo
	 * @param accountHolder
	 * @param bankName
	 * @param accountNumber
	 * @param currentBalance
	 * @return
	 */
	public void accountInfo() {
		System.out.println("Account Holder: " + accountHolder +
				"\nBank Name: " + bankName +
				"\nAccount Number: " + accountNumber +
				"\nCurrent Balance: $" + currentBalance);
		System.out.println("Press ENTER key to continue");
		Scanner newLine = new Scanner(System.in);
		newLine.nextLine();
	}
	
	/**
	 * allows user to deposit money into their account
	 * @param currentBalance
	 * @return
	 */
	@SuppressWarnings("resource")
	public void deposit() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Current Balance: $" + currentBalance);
		System.out.println("Enter a deposit amount: ");
		double input = scanner.nextDouble();
		while (input < 0) {
			System.out.println("ERROR 125: Can not deposit negative values");
			System.out.println("Please enter a POSITIVE value: ");
			input = scanner.nextDouble();
		}
		input = Math.round(input * 100.0) / 100.0;
		currentBalance += input;
		currentBalance = Math.round(currentBalance * 100.0) / 100.0;
		System.out.println("Current Balance: $" + currentBalance);
		System.out.println("Press ENTER key to continue");
		Scanner newLine = new Scanner(System.in);
	    newLine.nextLine();
	}
	
	/**
	 * allows user to withdraw money from their account
	 * @param currentBalance
	 * @return
	 */
	@SuppressWarnings("resource")
	public void withdraw() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Current Balance: $" + currentBalance);
		System.out.println("Enter a withdrawal amount: ");
		double input = scanner.nextDouble();
		while (input < 0) {
			System.out.println("ERROR 150: Can not withdraw negative values");
			System.out.println("Please enter a POSITIVE value: ");
			input = scanner.nextDouble();
		}
		input = Math.round(input * 100.0) / 100.0;
		if (input > currentBalance) {
			System.out.println("Error 404: Insufficient Funds");
		} else {
			currentBalance -= input;
			currentBalance = Math.round(currentBalance * 100.0) / 100.0;
		}
		System.out.println("Current Balance: $" + currentBalance);
		System.out.println("Press ENTER key to continue");
		Scanner newLine = new Scanner(System.in);
	    newLine.nextLine();
	}
	
	/**
	 * main method that allows user to test every method and ATM functionality
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ATM myAccount = new ATM("Andres Ruiz", "PNC Bank", 123456789, 1874.56);
		System.out.println("Thank you for choosing this ATM");
		System.out.println("Press (1) to view account information");
		System.out.println("Press (2) to make a deposit");
		System.out.println("Press (3) to make a withdrawal");
		System.out.println("Press (4) to EXIT");
		System.out.println("Choose an option: \n");
		Scanner scanner = new Scanner(System.in);
		int functionality = scanner.nextInt();
		while (functionality != 1 && functionality != 2
				&& functionality != 3 && functionality != 4) {
			System.out.println("Your input is invalid");
			System.out.println("Press ENTER key to continue");
			Scanner newLine = new Scanner(System.in);
		    newLine.nextLine();
			System.out.println("Press (1) to view account information");
			System.out.println("Press (2) to make a deposit");
			System.out.println("Press (3) to make a withdrawal");
			System.out.println("Press (4) to EXIT");
			System.out.println("Choose an option: \n");
			functionality = scanner.nextInt();
		}
		exit:
		while (functionality == 1 || functionality == 2
				|| functionality == 3 || functionality == 4) {
			if (functionality == 1) {
				myAccount.accountInfo();;
			}
			if (functionality == 2) {
				myAccount.deposit();
			}
			if (functionality == 3) {
				myAccount.withdraw();
			}
			if (functionality == 4) {
				break exit;
			}
			System.out.println("Press (1) to view account information");
			System.out.println("Press (2) to make a deposit");
			System.out.println("Press (3) to make a withdrawal");
			System.out.println("Press (4) to EXIT");
			System.out.println("Choose an option: \n");
			functionality = scanner.nextInt();
			while (functionality != 1 && functionality != 2
					&& functionality != 3 && functionality != 4) {
				System.out.println("Your input is invalid");
				System.out.println("Press ENTER key to continue");
				Scanner newLine = new Scanner(System.in);
			    newLine.nextLine();
				System.out.println("Press (1) to view account information");
				System.out.println("Press (2) to make a deposit");
				System.out.println("Press (3) to make a withdrawal");
				System.out.println("Press (4) to EXIT");
				System.out.println("Choose an option: \n");
				functionality = scanner.nextInt();
			}
		}
	}
}
