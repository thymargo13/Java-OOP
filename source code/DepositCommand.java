import Portfolio.*;
import java.util.*;

public class DepositCommand extends Command implements SpecialCommands{
    private Stack<Security> _securityStack;
	private Caretaker _ct;
    private Stack<Command> undoList;
    private Stack<Command> redoList;
	private String code,line;
    private Security sec;
	private int amount;
    public DepositCommand(Stack<Security> _sec){
        _securityStack =_sec;
    }
   
    public void execute(){
    	try{
    	    System.out.println("Enter code");
    	    code = br.readLine();
    	    for(Security sec: _securityStack){
                this.sec =sec;
    	        if(code.equals(sec.getCode())){
            	    System.out.println("Quantity to deposit");
            		line = br.readLine();
    		        amount = Integer.parseInt(line.trim());
                    if(amount>=0){
                        _ct.saveSecurity(sec,true);
                        redoList.clear();
    	                sec.setQuantity(sec.getQuantity()+amount);
    	                undoList.push(this);
    	                System.out.println("Deposit "+ amount +" to "+code+". Current quantity is "+sec.getQuantity()+".");
                        break;
                    }else{
                        System.out.println("Quantity cannot be negative");
                    }
    	            
    	        }        
    	    }
    	}catch (Exception e) {
			System.out.println("*** " + e.getMessage());
		}
    }
    public void undo(){
        _securityStack.remove(sec);
        _securityStack.push((Security)_ct.undo());
    }
    public void redo(){
        _securityStack.remove(sec);
        _securityStack.push((Security)_ct.redo());
    }
    public String toString(){
        return "Deposit "+ amount +" "+ code; 
    }
	public void setSecurity(Stack<Security> _securityStack){this._securityStack = _securityStack;}
    public void setUndoList(Stack<Command> undoList){this.undoList=undoList;}
    public void setRedoList(Stack<Command> redoList){this.redoList=redoList;}
    public void setCaretaker(Caretaker _ct){this._ct =_ct;}
}
