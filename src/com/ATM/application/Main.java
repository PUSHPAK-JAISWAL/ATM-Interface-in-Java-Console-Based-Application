package com.ATM.application;

import com.ATM.application.ATM.ATM;
import com.ATM.application.Bank.Bank;

public class Main {
	
	public static void main(String args[]) {
		Bank bank = new Bank();
		ATM atm = new ATM(bank);
		atm.start();
	}
	
}
