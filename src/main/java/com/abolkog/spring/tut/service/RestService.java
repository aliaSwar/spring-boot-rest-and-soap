package com.abolkog.spring.tut.service;



import com.abolkog.spring.tut.model.Account;
import com.abolkog.spring.tut.model.Accounts;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@Service
public class RestService  {
    Accounts accounts=new Accounts();

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


    public double getBalance(String accountNumber) {
        //return 11;
         //Retrieve the account with the given accountNumber from the database
        Account account = accounts.findByAccountNumber(accountNumber);

        // Return the balance of the account
        return account.getBalance();
    }
}
