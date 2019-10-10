//Redo Command Factory
import java.util.*;
import Portfolio.*;

public class RedoCommandFac implements CommandFactory {
	Stack<Security> _security;

	public RedoCommandFac() {
		_security = null;
	}
	public void setSecurity(Stack<Security> _security) {
		this._security = _security;
	}
	public Command create() throws Exception {
		return new RedoCommand(_security);
	}
}
