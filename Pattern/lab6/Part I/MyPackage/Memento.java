
package MyPackage;
public class Memento{
	private MyClass myClass;
	private int mState;
	
	public Memento(MyClass mc){
	    myClass= mc;
	    mState = myClass.state;
	}
	public void restore(){
	    myClass.state = mState;
	}
	
}
 