package SuperBank;


public class Account{
    String accountNumber;
    double balance;
    Customer cust;
    
    
    public Account(){
      
    }
    
    public Account(String accountNumber , double balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    
    public void increase (double amount){
        balance+=amount;
    }
    public void decrease (double amount){
        balance -=amount;
    }
    public void setCustomer(Customer c){
        cust = c;
    }
    public Customer getCustomer(){
        return cust;
    }
    public double getBalance(){
        return balance;
    }
    public String getAccountNumber(){
        return accountNumber;
    }
    
}