package SuperBank;

public class AccountMemento implements Memento{
    private String accountNumber;
    private double balance;
    private Customer cust;
    private Account _acc ;
    
    
    public AccountMemento(Account account){
    	
	    _acc = account;
	    cust = account.cust;
	    accountNumber = account.accountNumber;
	    balance = account.balance;
	}
	
	public void restore(){
	 
	  _acc.balance  = balance;
	  _acc.cust =  cust ;
	  _acc.accountNumber = accountNumber;
	} 
}