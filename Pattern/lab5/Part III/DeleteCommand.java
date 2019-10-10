import java.util.*;
public class DeleteCommand implements Command,undoCommd{
	private Vector<Shape> shapes;
	private Shape shape;
	private int index;
	private String line;
	
	public void execute(){
		try{
		System.out.print("Enter index of the shape: ");
		line = br.readLine();
		index = Integer.parseInt(line);
		if (index < 0 || index >= shapes.size()) throw new Exception("Out of Range");
		shape = shapes.get(index);
		shapes.remove(shape);
		}catch(Exception e){}
	}
	public void undo(){
		shapes.add(shape);
	}
	public void setShape(Vector<Shape> _shape){
		 shapes =_shape;
	}
}