import Portfolio.*;
import java.util.*;

public class Caretaker{
  	private Vector undoList = new Vector();//declare undoList 
	private Vector redoList = new Vector();//declare redoList 
	
	public Caretaker(){}
	public void clearRedo() {
    	this.redoList.clear();
	}
	
	public void saveSecurity(Security _security, boolean clearRedo){
		//create a memento object;
		this.undoList.addElement(new Memento(_security));
		if (clearRedo){ //clear the redoList
		 	this.clearRedo();
		}
	}
	public Security undo(){
		Object undoObject = new Object();
			if (this.undoList != null && this.undoList.size() > 0) {
       			undoObject = this.undoList.lastElement();
      			this.undoList.remove(undoObject);
       			this.rememberRedo(((Memento)undoObject).getSecurity());
			}
		return  ((Memento) undoObject).restore();
	}
	public void rememberRedo(Security _sec){
		this.redoList.addElement(new Memento(_sec));
	}
	public Security redo(){
		Object redoObject = new Object();
		if (this.redoList != null && this.redoList.size() > 0) {
       		redoObject = this.redoList.lastElement();
      		this.redoList.remove(redoObject);
     		this.saveSecurity(((Memento)redoObject).getSecurity(), false);
      }
	  return  ((Memento) redoObject).restore();
    }
}
 
