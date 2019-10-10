//Create Command Factory
import java.util.*;
import Portfolio.*;

public class CreateCommandFac implements CommandFactory {
	Stack<Security> _security;
	public CreateCommandFac() {
		_security = null;
	}
	public void setSecurity(Stack<Security> _security) {
		this._security = _security;
	}
	public Command create() throws Exception {
		return new CreateCommand(_security);
	}
}
