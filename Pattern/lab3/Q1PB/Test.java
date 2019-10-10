public class Test{
    public static void main(String[]arg){
        NewCircle adapter = new CircleClassAdapter(10,15,25.5);
        PrintCircle.printCircle(adapter);
    }
}