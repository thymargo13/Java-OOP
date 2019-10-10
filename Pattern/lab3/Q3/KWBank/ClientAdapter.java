package KWBank;

import BankOne.*;
import java.util.*;

public class ClientAdapter extends Client {
    private Customer c1;
    //private InternationalAccount _ia;
    private Vector _account ;
    
    
    public ClientAdapter(Customer c1){
        super(c1.getName(),c1.getAddress());
        this.c1 = c1;
    }
    
    public String getName(){return c1.getName();}
    public String getAddress(){return c1.getAddress();}
    

    public Enumeration getInternationalAccounts()
    {
        //get Account from cutomer
        //create InternationalAccountAdapter object for each Account object
        //return the adapter object
        
        Enumeration _accounts = c1.getAccounts();
        _account = new Vector();
        ForeignExchangeCalculator _cal = new ForeignExchangeCalculator();
        while (_accounts.hasMoreElements()) {
            AccountAdapter _aa = new AccountAdapter((Account)_accounts.nextElement());
            _aa.setClient(this);
            _aa.setCalculator(_cal);
            _account.add(_aa);
        }
        return (_account.elements());  
    }
    
    public void addInternationalAccount(InternationalAccount ia)
    {
        
        //    get Account object from ia 
        //    add account object to customer
        
       if(ia instanceof AccountAdapter){
           //Account acc = ((AccountAdapter)ia).getAccounts();
           c1.addAccount(((AccountAdapter)ia).getAccount());
       }
    }
     public void removeInternationalAccount(InternationalAccount ia)
    {
        
        //    get Account object from ia 
        //   remove account object to customer
        
       if(ia instanceof AccountAdapter){
           Account acc = ((AccountAdapter)ia).getAccount();
           c1.removeAccount(acc);
       }
    }
  
  }

