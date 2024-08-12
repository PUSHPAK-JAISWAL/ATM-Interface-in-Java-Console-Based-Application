package com.ATM.application.ATM;

import java.util.Scanner;

import com.ATM.application.Account.Account;
import com.ATM.application.AccountHolder.AccountHolder;
import com.ATM.application.Bank.Bank;
import com.ATM.application.BankTransaction.BankTransaction;

public class ATM {
	
	private Bank bank;

	public ATM(Bank bank) {
		// TODO Auto-generated constructor stub
		this.bank = bank;
	}

//	public void start() {
//		// TODO Auto-generated method stub
//		Scanner scanner = new Scanner(System.in);
//		
//		System.out.println("Enter User ID: ");
//		String userId = scanner.nextLine();
//		
//		System.out.println("Enter PIN: ");
//		String userPin = scanner.nextLine();
//		
//		if(bank.authenticateUser(userId, userPin)) {
//			AccountHolder accountHolder = bank.findAccountHolder(userId);
//			showMenu(accountHolder);
//		}
//		else {
//			System.out.println("Invalid User ID or PIN");
//		}
//	}

	private void showMenu(AccountHolder accountHolder) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		Account account = accountHolder.getAccount();
		int choice;
		
		do {
			System.out.println("\nATM Menu: ");
			System.out.println("1. Show Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            
            switch (choice) {

            	case 1: showTransactionHistory(account);
            			break;
            			
            	case 2: withdraw(account);
            			break;
            			
            	case 3: deposit(account);
            			break;
            			
            	case 4: transfer(account);
            			break;
            			
            	case 5: System.out.println("Thank you for using the ATM.");
                    	break;
                    	
                default:System.out.println("Invalid choice.");
            
			}
            
		}while(choice !=5);
		
	}

	private void transfer(Account account) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
        System.out.print("Enter target account number: ");
        String targetAccountNumber = scanner.nextLine();
        System.out.print("Enter amount to transfer: ");
        double amount = scanner.nextDouble();

        // Assuming target account is in the same bank
        AccountHolder targetHolder = bank.findAccountHolder(targetAccountNumber);
        if (targetHolder != null && account.transfer(targetHolder.getAccount(), amount)) {
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Transfer failed.");
        }
    }

	private void deposit(Account account) {
		// TODO Auto-generated method stub
		 Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter amount to deposit: ");
	        double amount = scanner.nextDouble();
	        account.deposit(amount);
	        System.out.println("Deposit successful.");
		
	}

	private void withdraw(Account account) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
	}

	private void showTransactionHistory(Account account) {
		// TODO Auto-generated method stub
		System.out.println("Transaction History:");
        for (BankTransaction transaction : account.getTransactionHistory()) {
            System.out.println(transaction.getTransactionId() + " | " +
                               transaction.getTransactionType() + " | " +
                               transaction.getAmount() + " | " +
                               transaction.getDate());
        }
	}
	
	public void start() {
	    Scanner scanner = new Scanner(System.in);

	    System.out.println("ATM System");
	    System.out.println("1. Login");
	    System.out.println("2. Create a New Account");

	    System.out.print("Enter choice: ");
	    int choice = scanner.nextInt();
	    scanner.nextLine();  // Consume newline

	    if (choice == 1) {
	        login();
	    } else if (choice == 2) {
	        createAccount();
	    } else {
	        System.out.println("Invalid choice.");
	    }
	}

	private void login() {
	    Scanner scanner = new Scanner(System.in);

	    System.out.print("Enter User ID: ");
	    String userId = scanner.nextLine();

	    System.out.print("Enter PIN: ");
	    String userPin = scanner.nextLine();

	    if (bank.authenticateUser(userId, userPin)) {
	        AccountHolder accountHolder = bank.findAccountHolder(userId);
	        showMenu(accountHolder);
	    } else {
	        System.out.println("Invalid User ID or PIN.");
	    }
	}

	private void createAccount() {
	    Scanner scanner = new Scanner(System.in);

	    System.out.print("Enter your name: ");
	    String name = scanner.nextLine();

	    System.out.print("Create a User ID: ");
	    String userId = scanner.nextLine();

	    System.out.print("Create a PIN: ");
	    String userPin = scanner.nextLine();

	    System.out.print("Enter initial deposit amount: ");
	    double initialDeposit = scanner.nextDouble();

	    String accountNumber = "ACCT" + System.currentTimeMillis(); // Generate a unique account number
	    Account newAccount = new Account(accountNumber, initialDeposit);
	    AccountHolder newAccountHolder = new AccountHolder(userId, userPin, name, newAccount);

	    bank.addAccountHolder(newAccountHolder);
	    System.out.println("Account created successfully! You can now log in.");
	}


}
