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

public abstract class Shape {
	protected int _x;  // the x-coordinate of the top left hand corner
	protected int _y; // the y-coordinate of the top left hand corner
	

	
	public Shape(int x, int y) {
		_x = x;
		_y = y;
	}

	public void setX(int x) {
		_x = x;
	}

	public void setY(int y) {
		_y = y;
	}

	public int getX() {
		return _x;
	}

	public int getY() {
		return _y;
	}

	public abstract int getWidth();
	public abstract int getHeight();
	public abstract void draw();
	
	//Factory Method
//public abstract Shape create();
}