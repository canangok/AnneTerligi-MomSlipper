
import java.awt.Rectangle;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SlipperClass extends JFrame {
	
	JLabel terlik;
	ImageIcon terlikimg;
	int x =610,y;
	static int deger=15;

	public SlipperClass()
	{
		terlikimg = new ImageIcon("src/images/terlik.png");
		
		y= AnneTerligi.anney+50; 
		terlik = new JLabel();
		terlik.setBounds(x, y, 54, 29);
		terlik.setIcon(terlikimg);
		terlikat();

	}
	
	void terlikat()
	{
		       final Timer myTimer=new Timer();
	           TimerTask gorev =new TimerTask() {

	                  @Override
	                  public void run() {
	                	
	                	  x-=deger ;
	                	  terlik.setBounds(x, y, 54, 29);
	             
	                	  if(x<-50)
	                		  myTimer.cancel();
	                	  
	                  }
	           };

	           myTimer.schedule(gorev,0,100);
	 }

}
