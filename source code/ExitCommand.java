import java.util.*;
import Portfolio.*;
public class ExitCommand extends Command{
   private Caretaker _ct;
   public ExitCommand(Stack<Security> _sec){
        
    }
    public void execute(){
    	try{
    	    System.out.println("Leaving system...");
    		System.exit(0);
		} catch (Exception e) {
				System.out.println("*** " + e.getMessage());
		}
    }
    public void setSecurity(Stack<Security> _securityStack){}
    public void setUndoList(Stack<Command> undoList){}
    public void setRedoList(Stack<Command> redoList){}
    public void setCaretaker(Caretaker _ct){
        this._ct =_ct;
    }
    public void redo(){}
    public void undo(){}
}