package BankOne;
import java.util.*;

public class Customer {
  private String name, address;
  private Vector <Object> _account;
  
  public Customer(String name, String address){
      this.name= name;
      this.address = address;
      _account = new Vector<Object>();
  }
  public String getName(){return name;}
  public String getAddress(){return address;}
  public Enumeration getAccounts()
  {
    return (_account.elements());  
  }
  public void addAccount(Account account){
    _account.add(account);
  }
    public void removeAccount(Account account){
    _account.remove(account);
  }
}