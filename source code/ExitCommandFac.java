//Exit Command Factory
import java.util.*;
import Portfolio.*;

public class ExitCommandFac implements CommandFactory {
	Stack<Security> _security;

	public ExitCommandFac() {
		_security = null;
	}
	public void setSecurity(Stack<Security> _security) {
		this._security = _security;
	}
	public Command create() throws Exception {
		return new ExitCommand(_security);
	}
}
