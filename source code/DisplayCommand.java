import java.util.*;
import Portfolio.*;

public class DisplayCommand extends Command{
    private Stack<Security> _securityStack;
    private String line;
    private Caretaker _ct;
    
    public DisplayCommand(Stack<Security> _sec){
        _securityStack =_sec;
    
    }
    public void execute(){
        System.out.println("Enter code (## to show all):");
        try{
            line = br.readLine();
            System.out.println("Security information");
            if(line.equals("##")){
                System.out.format("%-10s %-30s %-10s %s\n",
					"Code", "Name", "Quantity","Other Info");
                for(Security sec: _securityStack){
                    System.out.format("%-10s %-30s %-10s %s\n",
                        sec.getCode(),sec.getName(),sec.getQuantity(),sec);
                }
            }else{
                for(Security sec: _securityStack){
                    if(line.equals(sec.getCode())){
                        System.out.println("Code: "+sec.getCode());
                        System.out.println("Name: "+sec.getName());
                        System.out.println("Quantity: "+sec.getQuantity());
                        System.out.println(sec);
                    }
                }
            }
        } catch (Exception e) {
			System.out.println("*** " + e.getMessage());
		}
    }
    public void setSecurity(Stack<Security> _securityStack){
		this._securityStack = _securityStack;
    }
    public void setCaretaker(Caretaker _ct){
        this._ct =_ct;
    }
    public void setUndoList(Stack<Command> undoList){}
    public void setRedoList(Stack<Command> redoList){}
    public void undo(){}
    public void redo(){}
}