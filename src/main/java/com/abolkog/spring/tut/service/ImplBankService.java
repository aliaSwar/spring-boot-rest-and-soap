package com.abolkog.spring.tut.service;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import com.abolkog.spring.tut.model.Account;
import com.abolkog.spring.tut.model.Accounts;

import javax.jws.WebService;

@WebService(endpointInterface = "com.abolkog.spring.tut.service.BankService")
public class ImplBankService implements BankService {
    Accounts accounts=new Accounts();
    @Override
    public double deposit(String accountNumber, double amount) {
        // Retrieve the account with the given accountNumber from the database
        Account account = accounts.findByAccountNumber(accountNumber);

        // Update the balance of the account by adding the deposit amount
        double newBalance = account.getBalance() + amount;
        account.setBalance(newBalance);

        // Save the updated account to the database
        accounts.save(account);
        return newBalance;
    }

    @Override
    public double withdraw(String accountNumber, double amount) {
        Account account = accounts.findByAccountNumber(accountNumber);

        // Check if the account has sufficient balance for the withdrawal
        if (account.getBalance() < amount) {
            return 0;
        }

        // Update the balance of the account by subtracting the withdrawal amount
        double newBalance = account.getBalance() - amount;

        account.setBalance(newBalance);

        // Save the updated account to the database
        accounts.save(account);
        return newBalance;
    }

    @Override
    public double getBalance(String accountNumber) {
        // Retrieve the account with the given accountNumber from the database
        Account account = accounts.findByAccountNumber(accountNumber);

        // Return the balance of the account
        return account.getBalance();
    }
}
