package SuperBank;

import java.util.*;

public class Customer{
    String name;
    String address;
    Vector<Account> _acc;
    
    public Customer(String name , String address){
        _acc = new Vector<Account>();
        this.name = name;
        this.address = address;
    }
    
    public Customer(){}
    
    public Enumeration getAccount(){
        return(_acc.elements());
    }
    public void addAccount(Account account)
    {
        _acc.add(account);
        
    }
    public void removeAccount(Account account)
    {
        _acc.remove(account);
    }
    
    public String getName(){return name;}
    public String getAddress(){return address;}
    
    public String toString(){
        String custInfo = "SuperBank Customer:"+name+" at address:" +address+"\n";
     
		Enumeration accounts = getAccount();
    	while (accounts.hasMoreElements()) {
    	Account a = (Account) accounts.nextElement();
        custInfo += " --- account no: " + a.getAccountNumber() + " has balace " + a.getBalance() +"\n";
    	}
        
        return custInfo;
    }
   
}