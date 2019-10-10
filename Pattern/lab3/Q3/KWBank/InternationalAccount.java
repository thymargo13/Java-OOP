package KWBank;

public class InternationalAccount{
    private String accountNumber,currency;
    private double balance;
    
    private Client _client;
    private ForeignExchangeCalculator _cal;
    
    public InternationalAccount(String accountNumber,double balance, String currency){
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.balance=balance;
    }
    
    public void increase(double amount){ balance = balance+amount;}
    public void decrease (double amount){ balance = balance-amount;}
    
    public double showBalance(){
        if(currency.equals("USD"))
            balance =showBalanceInUSD();
        return balance;
    }
    public double showBalanceInUSD(){return _cal.HKD2USD(balance);}
    public String getAccountNumber(){return accountNumber;}
    public String getCurrency(){ return currency;}
    public void setClient(Client c){_client = c;}
    public Client getClient(){return _client;}
    public void setCalculator(ForeignExchangeCalculator c){
        _cal = c;
    }
    public ForeignExchangeCalculator getCalculator(){return _cal;}
}
