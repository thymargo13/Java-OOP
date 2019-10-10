/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author Clarence Lau
 * @version 1.0
 */

import java.util.*;
import java.io.*;

public class Main {
	private Shape s;
	private static ShapeFactory sf;
	public static void main(String[] args) {
		Vector _shapes = new Vector();
		boolean cont = true;
		ShapeFactory [] factoriesArray ={ new CircleFactory(),  new RectangleFactory(),  new TriangleFactory()};
		//String [] factory = {"exit","draw","CircleFactory", "RectangleFactory","TriangleFactory"};
		
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);

		try {
			while (cont) {
				System.out.println("Enter command: 0 = exit, 1 = draw all shapes, 2 = create circle, 3 = create rectangle, 4= create Triangle");
				String line = br.readLine();
				int command = Integer.parseInt(line);
				if (command == 0)
					cont = false;
				else if (command == 1) {
					for (int i = 0; i < _shapes.size(); i++)
						( (Shape) _shapes.elementAt(i)).draw();
				}
			
			else{
				 //sf =(ShapeFactory)Class.forName(factory[command]).newInstance();
				 sf = factoriesArray[command-2] ;
				 Shape s = sf.createShape();
 				  _shapes.add(s);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
/* 
 *  Shape s = 
 *	(Shape)Class.forName(args).newInstance();
 *	s.create();
*/

/* else if (command == 2) {
					//_shapes.add(s.create());
				//	System.out.println("Enter radius:");
				//	line = br.readLine();
				//	int r = Integer.parseInt(line);
					Shape s = new creators[command].createShape();
					_shapes.add(s);
					
					} else if (command == 3) {
				
					Shape s = new creators[command].createShape();
					_shapes.add(s);
				}*/