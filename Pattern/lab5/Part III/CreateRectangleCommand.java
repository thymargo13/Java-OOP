import java.util.*;
public class CreateRectangleCommand implements Command,undoCommd{
	private Vector<Shape> shapes;
	private int width,height;
	private Shape shape;
	private String line;
	

		public void execute(){
		try{
			System.out.print("Enter width: ");
			line = br.readLine();
			width = Integer.parseInt(line);
			System.out.print("Enter height: ");
			line = br.readLine();
			height = Integer.parseInt(line);
			shape = new Rectangle(width, height);
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