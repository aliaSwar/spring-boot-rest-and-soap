package com.abolkog.spring.tut.util;

import com.abolkog.spring.tut.service.ImplBankService;

import javax.xml.ws.Endpoint;

public class BankServicePublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/ws/bank-service",new ImplBankService());
    }
}
