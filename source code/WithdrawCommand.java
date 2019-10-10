import Portfolio.*;
import java.util.*;

public class WithdrawCommand extends Command implements SpecialCommands{
	private Stack<Security> _securityStack;
    private Caretaker _ct;
    private Stack<Command> undoList;
    private Stack<Command> redoList;
	private Security sec;
	private String code,line;
	private int amount;
   
   public WithdrawCommand(Stack<Security> _sec){
        _securityStack =_sec;
    }
   
   
    public void execute(){
    	try{
    	    System.out.println("Enter code");
    		code = br.readLine();
    	    for(Security sec: _securityStack){
				this.sec =sec;
    	        if(code.equals(sec.getCode())){
    	            System.out.println("Quantity to withdraw");
    		        line = br.readLine();
    		        amount = Integer.parseInt(line.trim());
    	            if(amount>sec.getQuantity()){
    	                System.out.println("Invalid quantity (current quantity < withdraw quantity)");
    	            }else{
    	                _ct.saveSecurity(sec,true);
    	                redoList.clear();
    	                sec.setQuantity(sec.getQuantity()-amount);
    	                undoList.push(this);
    	                System.out.println("Withdraw "+ amount +" from "+code+". Current quantity is "+sec.getQuantity()+".");
    	                break;
    	            }
    	        }
    	    }
		} catch (Exception e) {
				System.out.println("Please check the Code.");
		}
    }
    public void setSecurity(Stack<Security> _securityStack){
		this._securityStack = _securityStack;
    }
    public String toString(){
        return "Withdraw "+ amount +" "+ code; 
    }
    public void undo(){
        _securityStack.remove(sec);
        _securityStack.push((Security)_ct.undo());
    }
    public void redo(){
        _securityStack.remove(sec);
        _securityStack.push((Security)_ct.redo());
    }
    public void setUndoList(Stack<Command> undoList){this.undoList=undoList;}
    public void setRedoList(Stack<Command> redoList){this.redoList=redoList;}
    public void setCaretaker(Caretaker _ct){
        this._ct =_ct;
    }
}