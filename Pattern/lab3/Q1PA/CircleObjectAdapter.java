import java.awt.Point;

public class CircleObjectAdapter implements NewCircle{
    private OldCircle old;
    public CircleObjectAdapter(OldCircle old){
        this.old = old;
    }
    public double getRadius(){
        return Math.sqrt(old.getCoeff()[2]);
    }
    public Point getCenter(){
        return new Point((int)old.getCoeff()[0],(int)old.getCoeff()[1]);
    }
}