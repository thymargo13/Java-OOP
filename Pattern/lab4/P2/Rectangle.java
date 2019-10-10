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

public class Rectangle extends Shape {
	protected int _width, _height;


	public Rectangle(int x, int y, int width, int height) {
		super(x,y);
		_width = width;
		_height = height;
	}

	public void draw() {
		System.out.println("Rectangle at (" + _x + "," + _y + "), width = " +_width + ", height = " + _height);
	}

	public int getWidth() {
		return _width;
	}

	public int getHeight() {
		return _height;
	}
	
}