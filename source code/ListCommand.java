import java.util.*;
import Portfolio.*;

public class ListCommand extends Command{
	private Stack<Command> undoList;
	private Stack<Command> redoList;
	private Caretaker _ct;
	
	public ListCommand(Stack<Security> _sec){}
	public void execute(){  
		System.out.println("Undo List: ");
		for(Command undo :undoList){
			System.out.println(undo);
		}
		System.out.println();
		System.out.println("Redo List: ");
		for(Command redo :redoList){
			System.out.println(redo);
		}
	}
	public void setCaretaker(Caretaker _ct){
		this._ct =_ct;
	}	
	public void setUndoList(Stack<Command> undoList){
		this.undoList=undoList; 
	}
	public void setRedoList(Stack<Command> redoList){
		this.redoList=redoList;
	}
	public void setSecurity(Stack<Security> _securityStack){}
	public void undo(){}
	public void redo(){}
}

