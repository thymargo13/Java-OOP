package SuperBank;

import java.util.*;


public class CustomerMemento implements Memento{
    private String name;
    private String address;
    private Vector<Account> _acc;
    private Customer _cust;

    
      public CustomerMemento(Customer _customer){
        _cust = _customer;
	    name = _customer.name;
	    address = _customer.address;
	    _acc = new Vector<Account>();
	   
	
	    Enumeration accounts = _customer.getAccount();
    	while (accounts.hasMoreElements()) {
    		Account a = (Account) accounts.nextElement();
    		_acc.add(a);
    	}
	}
	
	public void restore(){
		_cust.name = name ;
	    _cust.address = address ;
	    _cust._acc = _acc ;
	} 
	
	
	
}