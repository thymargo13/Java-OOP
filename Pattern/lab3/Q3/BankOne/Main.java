//import BankOne.*;
package BankOne;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    Customer c1 = new Customer("Peter Chan", "20 Tsing Yi Road, Tsing Yi");
    SavingAccount a1 = new SavingAccount("12-133-22", 1000.0);
    SavingAccount a2 = new SavingAccount("13-123-22", 2000.0);
    // set the links between account and customer
    a1.setCustomer(c1);
    a2.setCustomer(c1);
    c1.addAccount(a1);
    c1.addAccount(a2);
    System.out.println("Customer " + c1.getName() + ", " + c1.getAddress());
    System.out.println("Accounts");
    Enumeration accounts = c1.getAccounts();
    while (accounts.hasMoreElements()) {
      Account a = (Account) accounts.nextElement();
      System.out.println("  Account " + a.getAccountNumber() + ", balance = " + a.getBalance());
    }
  }

}