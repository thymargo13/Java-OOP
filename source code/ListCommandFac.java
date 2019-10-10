//List Command Factory
import java.util.*;
import Portfolio.*;

public class ListCommandFac implements CommandFactory {
	Stack<Security> _security;

	public ListCommandFac() {
		_security = null;
	}
	public void setSecurity(Stack<Security> _security) {
		this._security = _security;
	}
	public Command create() throws Exception {
		return new ListCommand(_security);
	}
}
