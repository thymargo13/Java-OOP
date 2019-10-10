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

public class Triangle extends Shape {
	protected int _base, _height;


	public Triangle(int x, int y, int width, int height) {
		super(x,y);
		_base = width;
		_height = height;
	}

	public void draw() {
		System.out.println("Triangle at (" + _x + "," + _y + "), base = " +_base + ", height = " + _height);
	}

	public int getWidth() {
		return _base;
	}

	public int getHeight() {
		return _height;
	}
	
}