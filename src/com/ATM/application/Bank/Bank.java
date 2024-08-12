package com.ATM.application.Bank;

import java.util.HashMap;
import java.util.Map;

import com.ATM.application.AccountHolder.AccountHolder;

public class Bank {

	private Map<String, AccountHolder> accountHolders;
	
	public Bank() {
		this.accountHolders = new HashMap<>();
	}
	
	public void addAccountHolder(AccountHolder accountHolder) {
		accountHolder.put(accountHolder.getUserId(),accountHolder);
	}
	
	public AccountHolder findAccountHolder(String userId) {
		return accountHolders.get(userId);
	}
	
	public boolean authenticateUser(String userId, String userPin) {
		AccountHolder accountHolder = findAccountHolder(userId);
		return accountHolder != null && accountHolder.getUserPin().equals(userPin);
	}
}
