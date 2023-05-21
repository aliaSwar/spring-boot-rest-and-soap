package com.abolkog.spring.tut.controller;


import com.abolkog.spring.tut.service.BankService;
import com.abolkog.spring.tut.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebService;

@WebService(endpointInterface = "com.abolkog.spring.tut.service.BankService")
@RestController
@RequestMapping("/accounts")
public class BankController {
@Autowired
    private RestService bankService;

    @PostMapping("/deposit")
    public double deposit(@RequestParam String accountNumber, @RequestParam double amount) {

        return bankService.deposit(accountNumber, amount);
    }

    @PostMapping("/withdraw")
    public double withdraw(@RequestParam String accountNumber, @RequestParam double amount) {
        return bankService.withdraw(accountNumber, amount);
    }
    @PostMapping("/balance")
    public double getBalance(@RequestParam String accountNumber) {
        return bankService.getBalance(accountNumber);
    }
   // @GetMapping("/balance")
    //public double getBalance(@RequestParam String accountNumber) {
  //      return bankService.getBalance(accountNumber);
    //}

}