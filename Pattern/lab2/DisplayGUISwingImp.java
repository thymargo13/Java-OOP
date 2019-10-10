import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class DisplayGUISwingImp implements DisplayUI
{
	private JFrame frame;
	private JLabel label;
	
	public DisplayGUISwingImp(){
		frame = new JFrame();
		label = new JLabel();
		frame.getContentPane().add(label,BorderLayout.CENTER);
    	frame.setSize(50,50);
    	frame.show();
	}
			
	public void displayMethod(StringBuffer buf){
		label.setText(buf.toString());
		label.repaint();
	}
}