import java.awt.Point;

public class CircleClassAdapter extends OldCircleImpl implements NewCircle{
    public CircleClassAdapter(double a, double b, double c){
       super(a,b,c);
    }
    public double getRadius(){
        return Math.sqrt(getCoeff()[2]);
    }
    public Point getCenter(){
        return new Point((int)getCoeff()[0],(int)getCoeff()[1]);
        
    }


    
}