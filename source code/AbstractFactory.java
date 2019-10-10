import Portfolio.*;
import java.io.*;

//Abstract Factory
public abstract class AbstractFactory{
    InputStreamReader is = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(is);
    public abstract Security createSecurity(); 
}