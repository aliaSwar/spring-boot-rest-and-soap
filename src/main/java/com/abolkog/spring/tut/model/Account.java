package com.abolkog.spring.tut.model;

public class Account {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    public void CopyAccount(Account account) {
        this.accountNumber = account.accountNumber;
        this.accountHolderName =account. accountHolderName;
        this.balance = account.balance;
    }

    public Account(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
