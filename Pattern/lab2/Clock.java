import java.util.Calendar;
import java.text.DecimalFormat;

public class Clock extends Thread {
  private DecimalFormat tflz, tf;
  private DisplayUI ui;

  public Clock(String gui) {
    tf = new DecimalFormat("#0");
    tflz = new DecimalFormat("00");
	  try{
      ui = (DisplayUI)Class.forName(gui).newInstance();
	  }catch(Exception e){e.printStackTrace();}
  }

  public void run() {
    try {
      while (true) {
        Calendar calendar = Calendar.getInstance();
        StringBuffer buf = new StringBuffer();
        buf.append(tf.format(calendar.get(Calendar.HOUR)));
        buf.append(':');
        buf.append(tflz.format(calendar.get(Calendar.MINUTE)));
        buf.append(':');
        buf.append(tflz.format(calendar.get(Calendar.SECOND)));
		    ui.displayMethod(buf);
        Thread.sleep(1000);
      }
    } catch (Exception e) {e.printStackTrace();}
  }

  static public void main(String []arg) {
  	Clock clock = new Clock(arg[0]);
  	clock.run();
  }
}

