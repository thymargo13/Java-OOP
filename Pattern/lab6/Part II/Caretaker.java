import java.util.*;
import SuperBank.*;

public class Caretaker{
    private Vector<Memento> _list;
    
    public Caretaker(){
        _list = new Vector();
    }
    
    public void saveCustomer (Customer _cust){
        _list.add(new CustomerMemento(_cust));
    }
    public void saveAccount(Account _ac){
         _list.add(new AccountMemento(_ac));
    }
    
    public void undo(){
        Memento m = _list.lastElement();
        m.restore();
        _list.remove(m);
        
    }
}