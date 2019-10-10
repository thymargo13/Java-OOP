
import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) {
		Vector<Shape> shapes = new Vector<Shape>();
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		Shape shape;
		Command cmd;
		UndoCommand undoCmd = new UndoCommand();
		String [] command = {"ExitCommand","UndoCommand","DisplayCommand", "DeleteCommand","CreateCircleCommand","CreateRectangleCommand"};
		
		while (true) {
			try {
				System.out.println("0 = exit, 1 = undo, 2 = draw all shapes, " +
						"3 = delete a shape, 4 = create circle, 5 = create rectangle");
				System.out.print("Enter option: ");
				String line = br.readLine();
				int option = Integer.parseInt(line);
				if(option==1){
					undoCmd.execute();
				}else{
					cmd =(Command)Class.forName(command[option]).newInstance();;
					cmd.setShape(shapes);
					cmd.execute();
					undoCmd.addCommand(cmd);
				}
				
				
			} catch (Exception e) {
				System.out.println("*** " + e.getMessage());
			}
			System.out.println();
		}
	}
}
/*
if(option !=1){
	c=(Command) Class.forName(className[option]).newInstance();
	c.setShapes(shapes);
	c.execute();
	if(option>2)
	history.push(c);
}else{
	c=history.pop();
	c=undo();
}


use factory to create command  -_-""""

*/
