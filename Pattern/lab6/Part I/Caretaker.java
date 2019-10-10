import MyPackage.*;
import java.util.*;

public class Caretaker{
	//declare undoList 
    private Vector<Memento> undoList;
	
	public Caretaker(){
		//create undoList
	    undoList = new Vector<Memento>();
	}
	public void saveMyClass(MyClass mc){
		//create a memento object for mc;
		// push the memento object into undoList
		
	    undoList.add(new Memento(mc));
	}
	public void undo(){
		
		
		//pop a memento object from undoList
		//restore the MyClass object's state using the memento object
	    undoList.lastElement().restore();
	    undoList.remove(undoList.lastElement());
	}
}
 
