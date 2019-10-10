package BankOne;

import java.util.*;

public class Account {
  private String accountNumber;
  private double balance;
  private Customer customer;
  
  public Account(String accountNumber,double balance ){
    this.accountNumber = accountNumber;
    this.balance = balance;
  }
  
  public void debit(double amount){
     balance = amount-balance;
  }
  public void credit(double amount){
    balance = amount+balance;
  }
  
  public double getBalance(){
      return balance;
  }
  public String getAccountNumber(){return accountNumber;}
  
   public void setCustomer(Customer c){
     customer = c;
  }
  public Customer getCustomer(){
    return customer;
  }
}