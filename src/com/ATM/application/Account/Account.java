package com.ATM.application.Account;

import java.util.ArrayList;
import java.util.List;

import com.ATM.application.BankTransaction.BankTransaction;

public class Account {

	private String accountNumber;
	private double balance;
	private List<BankTransaction> transactionHistory;
	
	public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }
	
	public double getBalance() {
		return balance;
	}
	
	public void deposit(double amount) {
		balance +=amount;
		transactionHistory.add(new BankTransaction("DEPOSIT",amount));
	}
	
	public boolean withdraw(double amount) {
		if(amount>balance) {
			return false;
		}
		balance -= amount;
		transactionHistory.add(new BankTransaction("WITHDRAW", amount));
		return true;
	}
	
	public boolean transfer(Account targetAccount,double amount) {
		if(withdraw(amount)) {
			targetAccount.deposit(amount);
			transactionHistory.add(new BankTransaction("TRANSFER", amount));
			return true;
		}
		return false;
	}
	
	public List<BankTransaction> getTransactionHistory() {
		return transactionHistory;
	}
	
}
