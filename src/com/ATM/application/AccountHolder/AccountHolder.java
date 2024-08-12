package com.ATM.application.AccountHolder;

import com.ATM.application.Account.Account;

public class AccountHolder {
	
	private String userId;
	private String userPin;
	private String name;
	private Account account;
	
	public AccountHolder(String userId,String userPin,String name,Account account) {
		this.userId = userId;
		this.userPin = userPin;
		this.name = name;
		this.account = account;
	}

	public String getUserId() {
        return userId;
    }

    public String getUserPin() {
        return userPin;
    }

    public String getName() {
        return name;
    }

    public Account getAccount() {
        return account;
    }
	
}
