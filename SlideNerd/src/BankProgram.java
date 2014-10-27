import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 A customer opens an account in a bank, the customer must have an initial balance of 100$ while opening the account,
 the customer can withdraw, deposit, and check his balance any time he wants, the bank does not charge any fees for the 1st withdrawal but for all the subsequent withdrawals,
 the bank charges some transaction fees. The bank also calculates a certain amount of interest on the amount deposited by the customer as per its interest rate.
 Create an OOP to automate this problem.

 */

public class BankProgram {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		int numberOfCustomers = 0;
		Bank bank = new Bank();
		Customer[] c = bank.getCustomer();

		while (true) {
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(System.in));
			System.out.println("Please enter your choice");
			System.out.println("1: Add Customer");
			System.out.println("2: Deposit Money");
			System.out.println("3: Withdraw Money");
			System.out.println("4: Check Balance");
			System.out.println("5: Calculate Interest");
			System.out.println("6: Exit");
			
			int choice = Integer.parseInt(bufferedReader.readLine());

			switch (choice) {
			case 1:
				System.out.println("Creating an account for a new customer.");
				System.out
						.println("Please Enter the initial amount in your account");
				double bal = Double.parseDouble(bufferedReader.readLine());
				System.out.println("Please enter your Account Number");
				String acc = bufferedReader.readLine();
				Account account = new Account(bal, acc);
				System.out.println("Please Enter your Name: ");
				String name = bufferedReader.readLine();
				Customer customer = new Customer(name, account);
				c[numberOfCustomers] = customer;
				numberOfCustomers++;
				System.err.println("NUMBER OF CUSTOMERS " + numberOfCustomers);
				for (int i = 0; i < numberOfCustomers; i++) {
					System.err.println(c[i].getName() + " NAME");
				}
				break;
			case 2:
				System.out.println("Enter account number");
				acc = bufferedReader.readLine();
				if (numberOfCustomers == 0) {
					System.out.println("Account number not found");
				} else {
					boolean found = false;
					for (int i = 0; i < numberOfCustomers; i++) {
						Account temp = c[i].getAccount();
						String accTemp = temp.getAccountNumber();
						if (accTemp.equals(acc)) {
							System.out
									.println("Please enter the amount to deposit");
							double money = Double.parseDouble(bufferedReader
									.readLine());
							temp.deposit(money);
							found = true;
						}
					}
					if (found == false) {
						System.err.println("Account number not found");
					}
				}
				break;
			case 3:
				System.out.println("Enter account number");
				acc = bufferedReader.readLine();
				if (numberOfCustomers == 0) {
					System.out.println("Account number not found");
				} else {
					boolean found = false;
					for (int i = 0; i < numberOfCustomers; i++) {
						Account temp = c[i].getAccount();
						String accTemp = temp.getAccountNumber();
						if (accTemp.equals(acc)) {
							System.out
									.println("Please enter the amount to withdraw");
							double money = Double.parseDouble(bufferedReader
									.readLine());
							temp.withdraw(money);
							found = true;
						}
					}
					if (found == false) {
						System.err.println("Account number not found");
					}
				}
				break;
			case 4:
				System.out.println("Enter account number");
				acc = bufferedReader.readLine();
				if (numberOfCustomers == 0) {
					System.out.println("Account number not found");
				} else {
					boolean found = false;
					for (int i = 0; i < numberOfCustomers; i++) {
						Account temp = c[i].getAccount();
						String accTemp = temp.getAccountNumber();
						if (accTemp.equals(acc)) {
						
							System.out.println("Balance is: " + temp.getBalance());
							found = true;
						}
					}
					if (found == false) {
						System.err.println("Account number not found");
					}
				}
				break;
			case 5:
				System.out.println("Enter account number");
				acc = bufferedReader.readLine();
				if (numberOfCustomers == 0) {
					System.out.println("Account number not found");
				} else {
					boolean found = false;
					for (int i = 0; i < numberOfCustomers; i++) {
						Account temp = c[i].getAccount();
						String accTemp = temp.getAccountNumber();
						if (accTemp.equals(acc)) {
							bank.calculateInterest(c[i]);
							
							found = true;
						}
					}
					if (found == false) {
						System.err.println("Account number not found");
					}
				}
				break;
			case 6:
				System.exit(0);
				break;
			}
		}

	}
}

class Bank {

	private double interestRate = 8.5;
	private double transactionFees = 10;
	private Customer[] customers = new Customer[1000];

	public void calculateInterest(Customer customer) {
		Account a = customer.getAccount();
		double bal = a.getBalance();
		double interestAmount = bal * interestRate / 100;
		double totalBalance = bal + interestAmount;
		System.out.println("Interest amount " + interestAmount
				+ " Total money after adding interest: " + totalBalance);
	}

	public void getInterestRate() {

	}

	public double getTransactionFees() {
		return transactionFees;
	}

	public Customer[] getCustomer() {
		return customers;
	}
}

class Account {
	private double balance = 100;
	private String accountNumber;
	private boolean firstTime;

	public Account(String acc) {
		accountNumber = acc;
	}

	public Account(double bal, String acc) {
		if (bal >= 100) {
			balance = bal;
		} else {
			balance = 100;
		}
		accountNumber = acc;
	}

	public void deposit(double howMuch) {
		if (howMuch > 0) {
			balance += howMuch;
			System.out.println("");
			System.out.println(howMuch + " was added to your account. "
					+ "The new balance of your acc is: " + balance);
		} else {
			System.err
					.println("Please ensure the amount to be deposited is not negative");
		}
	}

	public void withdraw(double howMuch) {
		if (howMuch >= 0) {
			if (firstTime == true) {
				double tempBalance = balance;

				tempBalance = tempBalance - howMuch;
				System.out.println("You withdrew " + howMuch + " from your account. Your new balance is " + balance);
				if (tempBalance >= 100) {
					balance = balance - howMuch;
				}

				else {
					System.out.println("Insuffience balance to remove "
							+ howMuch);
				}
				firstTime = false;
			} else {
				Bank bank = new Bank();
				double tempBalance = balance;
				tempBalance = tempBalance - howMuch - bank.getTransactionFees();
				if (tempBalance >= 100) {
					balance = balance - howMuch - bank.getTransactionFees();
					System.out.println("You withdrew " + howMuch + " from your account. The transaction fees is " + bank.getTransactionFees()+" Your new balance is " + balance);
				}

				else {
					System.out.println("Insuffience balance to remove "
							+ howMuch);
				}
			}
		} else {
			System.err
					.println("please ensure the amount to be withdrawn is not negative");
		}

	}

	public double getBalance() {
		return balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

}

class Customer {
	private String name;
	private Account account;

	Customer(String n, Account a) {
		name = n;
		account = a;
	}

	public void display() {
		System.out.println("Name: " + name + ", Account Number: "
				+ account.getAccountNumber() + ", Balance: "
				+ account.getBalance());
	}

	public String getName() {
		return name;
	}

	public Account getAccount() {
		return account;
	}

}