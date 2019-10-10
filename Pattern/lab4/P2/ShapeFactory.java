/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author Clarence Lau
 * @version 1.0
 */
// Creator
import java.util.*;
import java.io.*;

public abstract class ShapeFactory {
    InputStreamReader is = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(is);
	
    public abstract Shape createShape();
}
    