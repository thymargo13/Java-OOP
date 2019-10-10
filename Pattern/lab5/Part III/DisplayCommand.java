import java.util.*;
public class DisplayCommand implements Command{
	private Vector<Shape> shapes;
	
	public void execute(){
		for (int i = 0; i < shapes.size(); i++)
		( (Shape) shapes.elementAt(i)).draw();
	}
	public void undo(){}
	public void setShape(Vector<Shape> _shape){
		shapes =_shape;
	}
}