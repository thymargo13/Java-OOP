import java.util.*;
public class ExitCommand implements Command{
	public void execute(){
		System.out.println("-- End --");
		System.exit(0);
	}
	public void undo(){}
	public void setShape(Vector<Shape> _shape){}
}