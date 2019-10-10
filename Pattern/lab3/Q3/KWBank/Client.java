package KWBank;

import java.util.*;
public class Client{
    private String name,address;
    private Vector <Object> _account;
    
    public Client(String name,String address){
        this.name = name;
        this.address = address;
        _account = new Vector<Object>();
    }
    
   
    
    public void setName(String xname){name = xname;}
    public String getName(){return name;}
	
    public void setAddtess(String xaddress){address = xaddress;}
    public String getAddress(){return address;}
    
    public void addInternationalAccount(InternationalAccount ac)
    {
        _account.add(ac);
    }
    
    public void removeInternationalAccount(InternationalAccount ac)
    {
        _account.remove(ac);
    }
	
    public Enumeration getInternationalAccounts()
    {
        return (_account.elements());  
    }

}




  

