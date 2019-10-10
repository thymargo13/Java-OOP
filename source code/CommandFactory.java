// CommandFactory.java
import java.util.*;
import Portfolio.*;

public interface CommandFactory {
	abstract public void setSecurity(Stack<Security> _security);
	abstract public Command create() throws Exception;
}