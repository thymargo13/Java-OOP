import java.util.*;
import Portfolio.*;

public class UndoCommand extends Command{
	private Stack<Security> _securityStack;
	private Stack<Command> undoList;
	private Stack<Command> redoList;
	private Caretaker _ct;
	
	 public UndoCommand(Stack<Security> _sec){
        _securityStack =_sec;
    }
   
	public void execute(){  
		if(undoList.size()>0){
			Command commd = undoList.pop();
			commd.undo();
			redoList.push(commd);  
			System.out.println("Undo Completed.");
		}else{
			System.out.println("Empty");
		}
    }
    public void setSecurity(Stack<Security> _securityStack){
		this._securityStack = _securityStack;
    }
    public void addCommand(Command cmd){
		if (cmd instanceof SpecialCommands){
			undoList.push(cmd);
			System.out.println("add Command "+ cmd);
		}
	}
	public void setCaretaker(Caretaker _ct){}
    public void setRedoList(Stack<Command> redoList){
		this.redoList =redoList;
	}
    public void setUndoList(Stack<Command> undoList){
		this.undoList =undoList;
	}
    public void undo(){}
    public void redo(){}
}



