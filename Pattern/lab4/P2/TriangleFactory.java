
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
public class TriangleFactory extends ShapeFactory {
    private int _base,_height;
    
     //Factory Method

    public Shape createShape(){
		try{	
		    System.out.println("Enter base:");
			 _base = Integer.parseInt(br.readLine());
			System.out.println("Enter height:");
			 _height = Integer.parseInt(br.readLine());
		 
		} catch (Exception e) {	e.printStackTrace();}
		return new Triangle(0,0,_base,_height);
		
	}
}
    