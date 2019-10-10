//Deposit Command Factory
import java.util.*;
import Portfolio.*;

public class DepositCommandFac implements CommandFactory {
	Stack<Security> _security;

	public DepositCommandFac() {
		_security = null;
	}

	public void setSecurity(Stack<Security> _security) {
		this._security = _security;
	}

	public Command create() throws Exception {
		return new DepositCommand(_security);
	}
}
