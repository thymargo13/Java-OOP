import java.io.*;
import java.util.*;
import Portfolio.*;

public abstract class Command{
    InputStreamReader is = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(is);
    
    public abstract void execute();
    public abstract void setSecurity(Stack<Security> _securityStack);
    public abstract void setCaretaker(Caretaker _cs);
    public abstract void setUndoList(Stack<Command> undoList);
    public abstract void setRedoList(Stack<Command> redoList);
    public abstract void redo();
    public abstract void undo();
}