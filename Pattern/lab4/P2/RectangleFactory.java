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
public class RectangleFactory extends ShapeFactory {
    private int _width,_height;
    
     //Factory Method

    public Shape createShape(){
		try{	
		    System.out.println("Enter width:");
			 _width = Integer.parseInt(br.readLine());
			System.out.println("Enter height:");
			 _height = Integer.parseInt(br.readLine());
		 
		} catch (Exception e) {	e.printStackTrace();}
		return new Rectangle(0,0,_width,_height);
		
	}
}
    