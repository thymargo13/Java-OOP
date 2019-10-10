public class Command1 implements Command{
    private int id;
     public Command1(int id){
        this.id=id;
    }
    public void execute(){
        System.out.println(id+"Command1: execute()");
    }
    
    public void undo(){
        System.out.println(id+"Command1: undo()");
    }
}