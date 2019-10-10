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

//Concrete Creator
public class CircleFactory extends ShapeFactory {
    private int _radius;
   public Shape createShape(){
   try{
		System.out.println("Enter radius:");
	    _radius =Integer.parseInt(br.readLine());
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Circle(0,0,_radius);
   }
}
    
    