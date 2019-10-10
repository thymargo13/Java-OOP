
import java.util.Stack;
public class Main{
    public static void main(String []args){
        Command []cmd = new Command[4];
        Stack commandStack = new Stack();
        cmd[0] = new Command1(1);
        cmd[1] = new Command1(2);
        cmd[2] = new Command2(3);
        cmd[3] = new Command2(4);
        
        for(int i=0; i<cmd.length;i++){
            cmd[i].execute();
            commandStack.push(cmd[i]);
        }
         while(!commandStack.empty()){
             Command c = (Command)commandStack.pop();
             c.undo();
         }
    }
}