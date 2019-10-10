
import java.util.*;
import java.io.*;

public interface Command{
	InputStreamReader is = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(is);
	
	public void execute();
	public void undo();
	public void setShape(Vector<Shape> _shape);
}