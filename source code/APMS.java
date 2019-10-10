import Portfolio.*;
import java.util.*;
import java.io.*;

public class APMS {
	public static void main(String[] args) {
	    InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		Stack<Security> _securityStack  = new Stack<Security>();
		Caretaker _cs = new Caretaker(); 
		Stack<Command> redoList = new Stack();
		Stack<Command> undoList = new Stack();
		Command cmd;
		char[]commd ={'n','s','d','w','u','r','l','q'};
		String [] commdClass ={"CreateCommandFac","DisplayCommandFac","DepositCommandFac","WithdrawCommandFac"
				,"UndoCommandFac","RedoCommandFac","ListCommandFac","ExitCommandFac"};
		while (true) {
			try {
				System.out.println();
				System.out.println("Advanced Security Management System");
				System.out.println("Please enter command:[n|s|d|w|u|r|l|q]");
				System.out.println("n = create security, s = show security, d = deposit security, w = withdraw security,");
				System.out.println("u = undo , r = redo, l = list undo/redo, q = exit system");
				System.out.println();
				String line = br.readLine();
				char option = line.charAt(0);
				
				for(int i=0;i<commd.length;i++){
					if(option== commd[i]){
						CommandFactory cf = (CommandFactory)Class.forName(commdClass[i]).newInstance();
						cmd = (Command)cf.create();
						cmd.setSecurity(_securityStack);
						cmd.setUndoList(undoList);
						cmd.setRedoList(redoList);
						cmd.setCaretaker(_cs);
						cmd.execute();
					}
				}
				System.out.println();
			}catch (Exception e) {System.out.println("Please enter command!!");}
		}
    }
}

