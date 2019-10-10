import java.util.*;
public class UndoCommand implements Command{
	private Vector<Shape> shapes;
	private Shape shape;
	private int index;
	
	private Stack<Command> history = new Stack<Command>();
	
	public void execute(){
		history.pop().undo();
		
	}
	public void undo(){}
	public void setShape(Vector<Shape> _shape){
		shapes = _shape;
	}
	public void addCommand(Command cmd){
		if (cmd instanceof undoCommd){
			history.add(cmd);	
		}
	}
}