import java.util.*;
public class CreateCircleCommand implements Command,undoCommd{
	private Vector<Shape> shapes;
	private int radius;
	private Shape shape;
	private String line;
	
	public void execute(){
		try{
		System.out.print("Enter radius: ");
		line = br.readLine();
		radius = Integer.parseInt(line);
		shape = new Circle(radius);
		shapes.add(shape);
		} catch (Exception e) {
				System.out.println("*** " + e.getMessage());
		}
	}
	public void undo(){
		shapes.remove(shape);
	}
	public void setShape(Vector<Shape> _shape){
		shapes = _shape;
	}
	
}