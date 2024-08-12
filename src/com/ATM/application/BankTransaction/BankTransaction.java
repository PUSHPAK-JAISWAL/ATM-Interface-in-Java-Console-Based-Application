package com.ATM.application.BankTransaction;

import java.util.Date;

public class BankTransaction {
	
	private String transactionId;
	private String transactionType;
	private double amount;
	private Date date;

	public BankTransaction(String transactionType, double amount) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.date = new Date();
        this.transactionId = generateTransactionId();
    }

    private String generateTransactionId() {
        return "TXN" + System.currentTimeMillis();
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

}
