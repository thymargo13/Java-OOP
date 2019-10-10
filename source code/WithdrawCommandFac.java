//Withdraw Command Factory
import java.util.*;
import Portfolio.*;

public class WithdrawCommandFac implements CommandFactory {
	Stack<Security> _security; 
	public WithdrawCommandFac() {
		_security = null;
	}
	public void setSecurity(Stack<Security> _security) {
		this._security = _security;
	}
	public Command create() throws Exception {
		return new WithdrawCommand(_security);
	}
}
