package com.abolkog.spring.tut.model;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import com.abolkog.spring.tut.model.Account;

import java.util.ArrayList;

/**
 *
 * @author ayamo
 */
public class Accounts {

   private  ArrayList<Account> accounts= new ArrayList<>();

   public Accounts(){
       accounts.add(new Account("1","alia", 0));
       accounts.add(new Account("2222","nour", 0));
       accounts.add(new Account("3333","Leen", 0));
       accounts.add(new Account("4444","Ali", 0));
   }
   
   public void setAccounts(ArrayList<Account> accounts){
       this.accounts.addAll(accounts);
   }
   
   public ArrayList<Account> getAccounts(){
       return accounts;
   }

    public Account findByAccountNumber(String accountNumber) {
        for (Account account  : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return  null;
    }


    public void save(Account account) {
        findByAccountNumber(account.getAccountNumber()).CopyAccount(account);

    }
}
