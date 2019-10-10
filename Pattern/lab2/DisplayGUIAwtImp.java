import java.awt.Frame;
import java.awt.Label;
import java.awt.BorderLayout;

class DisplayGUIAwtImp implements DisplayUI
{
	private Frame frame;
	private Label label;
	
	public DisplayGUIAwtImp(){
		frame = new Frame();
		label = new Label();
		frame.add(label,BorderLayout.CENTER);
		frame.setSize(50,50);
		frame.show();
	}
			
	public void displayMethod(StringBuffer buf){
		label.setText(buf.toString());
		label.repaint();
	}
}

