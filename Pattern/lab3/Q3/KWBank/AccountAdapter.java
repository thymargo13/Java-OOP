package KWBank;

import BankOne.*;
import java.util.*;

public class AccountAdapter extends InternationalAccount {
    private Account _ac;
    
    public AccountAdapter(Account ac){
        super(ac.getAccountNumber(),ac.getBalance(),"HKD");
        _ac = ac;
    }
    
    public Account getAccount (){return _ac;}
    public void increase(double amount){ _ac.credit(amount);}
    public void decrease (double amount){ _ac.debit(amount);}

    public String getAccountNumber(){return _ac.getAccountNumber();}
    
    public double showBalance(){
        return _ac.getBalance();
    }
    public double showBalanceInUSD(){return getCalculator().HKD2USD(_ac.getBalance());}
  
    public String getCurrency(){ return super.getCurrency();}
 
  }

