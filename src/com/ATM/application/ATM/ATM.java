package com.ATM.application.ATM;

import java.util.Scanner;

import com.ATM.application.Account.Account;
import com.ATM.application.AccountHolder.AccountHolder;
import com.ATM.application.Bank.Bank;

public class ATM {
	
	private Bank bank;

	public ATM(Bank bank) {
		// TODO Auto-generated constructor stub
		this.bank = bank;
	}

	public void start() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter User ID: ");
		String userId = scanner.nextLine();
		
		System.out.println("Enter PIN: ");
		String userPin = scanner.nextLine();
		
		if(bank.authenticateUser(userId, userPin)) {
			AccountHolder accountHolder = bank.findAccountHolder(userId);
			showMenu(accountHolder);
		}
		else {
			System.out.println("Invalid User ID or PIN");
		}
	}

	private void showMenu(AccountHolder accountHolder) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		Account account = accountHolder.getAccount();
		int choice;
		
	}

}
