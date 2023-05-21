package com.abolkog.spring.tut.util;

import com.abolkog.spring.tut.service.BankService;

import javax.swing.*;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;
public class BankClient {

    public static void main(String[] args) throws MalformedURLException {
        try {

            URL url = new URL("http://localhost:8080/ws/bank-service?wsdl");

            QName qname = new QName("http://service.tut.spring.abolkog.com/", "ImplBankServiceService");
            Service service = Service.create(url, qname);
            BankService bankService = service.getPort(BankService.class);




            boolean findmore;
            do{

                String[] options = {"deposit", "withdraw","get my Balance", "Exit"};
                int choice = JOptionPane.showOptionDialog(null, "Choose an action", "Option dialog", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

                switch(choice){
                    case 0:
                        try{

                            String accountNumber = JOptionPane.showInputDialog("Enter the accountNumber:");
                            double amount = Double.parseDouble(JOptionPane.showInputDialog("Enter the amount:"));
                            bankService.deposit(accountNumber, amount);

                            JOptionPane.showMessageDialog(null, "successfully");
                        }catch(NoSuchElementException ex){
                            JOptionPane.showMessageDialog(null, "Not found");
                        }
                        break;
                    case 1:
                        try{
                            String accountNumber = JOptionPane.showInputDialog("Enter the accountNumber:");
                            double amount = Double.parseDouble(JOptionPane.showInputDialog("Enter the amount:"));
                            bankService.withdraw(accountNumber, amount);




                            JOptionPane.showMessageDialog(null, "successfully");
                        }catch(NoSuchElementException ex){
                            JOptionPane.showMessageDialog(null, "Not found");
                        }
                        break;
                    case 2:
                        try{
                            String accountNumber = JOptionPane.showInputDialog("Enter the accountNumber:");
                            double balance = bankService.getBalance(accountNumber);

                            StringBuilder message = new StringBuilder();
                            message.append(balance);
                            JOptionPane.showMessageDialog(null,message);

                            //JOptionPane.showMessageDialog(null, "successfully");
                        }catch(NoSuchElementException ex){
                            JOptionPane.showMessageDialog(null, "Not found");
                        }
                        break;

                    default:
                        System.exit(0);
                        break;
                }
                findmore = (JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Exit", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION);
            }while(findmore);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}