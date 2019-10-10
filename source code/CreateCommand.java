import Portfolio.*;
import java.util.*;

public class CreateCommand extends Command implements SpecialCommands {
    private Stack<Security> _securityStack;
    private Stack<Command> undoList;
    private Stack<Command> redoList;
	private Security _security;
	private String line;
    private String [] commd ={"bo","st"}; //the command for select security
    private String [] commdClass = {"BondFactory","StockFactory"}; //the factory class of securitys 
    private Caretaker _ct;
    
    public CreateCommand(Stack<Security> _sec){
        _securityStack =_sec;
    }
    public void execute(){
    	try{
			
			System.out.println("Enter security type (bo = bond / st = stock)");
    		line = br.readLine();
    	    for(int i=0; i<commd.length; i++){
    	        if(line.equals(commd[i])){
    	            AbstractFactory _asf =(AbstractFactory)Class.forName(commdClass[i]).newInstance();
    	    	    _security = _asf.createSecurity();
    	    	    _ct.saveSecurity(_security,true);
                    redoList.clear();
    		        _securityStack.push(_security);
    		        undoList.push(this);
    		        System.out.println("New security record created.");
    	        }
    	    }
		} catch (Exception e) {	
			System.out.println("*** " + e.getMessage());
		}
    }
    public void undo(){
        _securityStack.remove(_security);
		_ct.undo();
    }
    public void redo(){
        _securityStack.remove(_security);
        _securityStack.push((Security)_ct.redo());
    }
	public void setSecurity(Stack<Security> _securityStack){
      this._securityStack = _securityStack; //set the stack of security
    }
    public void setUndoList(Stack<Command> undoList){
		this.undoList=undoList;
	}
    public void setRedoList(Stack<Command> redoList){
		this.redoList=redoList;
	}
    public void setCaretaker(Caretaker _ct){
        this._ct =_ct;
    }
	public String toString(){
        return "Create "+_security.getCode(); 
    }
}