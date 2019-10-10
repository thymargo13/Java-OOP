//Undo Command Factory
import java.util.*;
import Portfolio.*;

public class UndoCommandFac implements CommandFactory {
	Stack<Security> _security;

	public UndoCommandFac() {
		_security = null;
	}
	public void setSecurity(Stack<Security> _security) {
		this._security = _security;
	}
	public Command create() throws Exception {
		return new UndoCommand(_security);
	}
}
