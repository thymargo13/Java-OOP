//Display Command Factory 
import java.util.*;
import Portfolio.*;

public class DisplayCommandFac implements CommandFactory {
	Stack<Security> _security;
	public DisplayCommandFac() {
		_security = null;
	}

	public void setSecurity(Stack<Security> _security) {
		this._security = _security;
	}

	public Command create() throws Exception {
		return new DisplayCommand(_security);
	}
}
