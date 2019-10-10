public class Test{
    public static void main(String[]arg){
        PrintCircle.printCircle(new CircleObjectAdapter(new OldCircleImpl(10,15,25.5)));
    }
}