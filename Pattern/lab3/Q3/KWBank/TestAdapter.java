package KWBank;

import BankOne.*;
import java.util.*;

public class TestAdapter {

  public static void main(String[] args) {
    Customer c1 = new Customer("Peter Chan", "20 Tsing Yi Road, Tsing Yi");
    SavingAccount a1 = new SavingAccount("12-133-22", 1000.0);
    SavingAccount a2 = new SavingAccount("13-123-22", 2000.0);
    // set the links between customer and accounts
    c1.addAccount(a1);
    c1.addAccount(a2);
    a1.setCustomer(c1);
    a2.setCustomer(c1);
    // create client adapter to use the customer and accounts
    Client client = new ClientAdapter(c1);

    System.out.println("Customer " + client.getName() + ", " + client.getAddress());
    
    System.out.println("International Accounts");
    
    Enumeration ias = client.getInternationalAccounts();
    while (ias.hasMoreElements()) {
      InternationalAccount ia = (InternationalAccount) ias.nextElement();
      System.out.println("  International Account " + ia.getAccountNumber() + ", currency = " + ia.getCurrency() + ", balance = USD "+        ia.showBalanceInUSD());
    }

  }

}