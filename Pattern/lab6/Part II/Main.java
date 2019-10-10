import SuperBank.*;
import java.util.*;
public class Main {
	public static void main(String args[]) {
		Caretaker ct = new Caretaker();
	//	MyClass mc = new MyClass();
		
		System.out.println("Customer: Peter is created");
		Customer cust = new Customer("Peter", "Wanchai");
		ct.saveCustomer(cust);
	
		System.out.println("---add account : INT0001");
		Account _ac = new Account("INT001",100.0);
		ct.saveAccount(_ac);
		ct.saveCustomer(cust);
		cust.addAccount(_ac);
		
		
		System.out.println("---add account : INT0002");
		Account _ac2 = new Account("INT002",200.0);
		ct.saveAccount(_ac2);
		
		ct.saveCustomer(cust);
		cust.addAccount(_ac2);
		
		System.out.println("Show Detail");
		System.out.println(cust);
		
		System.out.println("--- account no: INT001 increase amount: 50.0" );
		ct.saveAccount(_ac);
		_ac.increase(50);
		
		System.out.println("--- account no: INT001 decrease amount: 20.0" );
		ct.saveAccount(_ac);
		_ac.decrease(20);
		
		System.out.println(cust);
		
		
		System.out.println("--- remove account: INT002");
		ct.saveCustomer(cust);
		cust.removeAccount(_ac2);
		System.out.println(cust);
		
		
		
		
		System.out.println("Undo - restore customer content: --- add account:INT002");
		ct.undo();
		System.out.println(cust);
	
		System.out.println("Undo - restore account Number : --- INT001 balance 150.0");
		ct.undo();
		System.out.println(cust);
		
		System.out.println("Undo - restore account Number : --- INT001 balance 100.0");
		ct.undo();
		System.out.println(cust);
		
	}
}
 
