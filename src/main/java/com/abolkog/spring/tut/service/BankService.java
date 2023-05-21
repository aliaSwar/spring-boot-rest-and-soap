package com.abolkog.spring.tut.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface BankService {


    @WebMethod
    public double deposit(String accountNumber, double amount) ;

    @WebMethod
    public double withdraw(String accountNumber, double amount) ;

    @WebMethod
    public double getBalance(String accountNumber) ;
}
