import java.util.*;
import Portfolio.*;

public class RedoCommand extends Command{
    private Stack<Security> _securityStack;
    private Stack<Command> redoList;
    private Stack<Command> undoList;
    private Caretaker _ct;
    
     public RedoCommand(Stack<Security> _sec){
        _securityStack =_sec;
    }
    public void execute(){
        if(redoList.size()>0){ 
            Command commd = redoList.pop();//pop the last Command in redoList..
            undoList.push(commd);// store it into undoList..
            commd.redo(); //call the redo method in that command..
            System.out.println("Redo Complete.");
        }else{
            System.out.println("Empty.");
        }
    }
    public void setSecurity(Stack<Security> _securityStack){
		this._securityStack = _securityStack;
    }
    public void addCommand(Command cmd){
		if(cmd instanceof SpecialCommands){
			redoList.push(cmd);	
		}
	}
	public void undo(){}
	public void redo(){};
	public void setCaretaker(Caretaker _ct){
        this._ct =_ct;
    }
    public void setUndoList(Stack<Command> undoList){
		this.undoList =undoList;
	}
    public void setRedoList(Stack<Command> redoList){
		this.redoList =redoList;
	}
}

