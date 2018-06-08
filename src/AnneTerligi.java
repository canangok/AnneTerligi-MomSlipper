import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class AnneTerligi extends JFrame implements KeyListener{
	
	JLabel anne,cocuk,background;
	JLayeredPane panel;
	ImageIcon bacgroundimg , anneimg , cocukimg;
	static int anney=400,annex=640,cocuky=400,cocukx=0;
	SlipperClass[] at = new SlipperClass[10];
	int i=0;  

	long tbasla;
    int cocukCani=10;
    int Oyunskor=0,skorcocuk=0, skoranne1=0,skoranne2=0;
    boolean oyunCalisiyor=true;
	 
    int Level=1;
    
	public AnneTerligi()
	{
		panel = new JLayeredPane();
		panel.setBounds(0, 0, 800, 600);
		
		bacgroundimg = new ImageIcon("src/images/salon.jpeg");
		anneimg = new ImageIcon("src/images/anne.png");
		cocukimg = new ImageIcon("src/images/cocuk.png");
		
		background = new JLabel();
		background.setBounds(0, 0, 800, 600);
		background.setIcon(bacgroundimg);
		panel.add(background, new Integer(1));
	
		anne = new JLabel();
		anne.setBounds(annex, anney, 149, 165);
		anne.setIcon(anneimg);
		panel.add(anne, new Integer(2));
		
		cocuk = new JLabel();
		cocuk.setBounds(0, cocuky, 69, 106);
		cocuk.setIcon(cocukimg);
	    panel.add(cocuk, new Integer(2));
		add(panel);
		
		addKeyListener(this);
		
		tbasla = System.currentTimeMillis();
	
	}
	
	public static void main(String[] args) {
		
		AnneTerligi oyunPen = new AnneTerligi();
		oyunPen.setBounds(300,50, 800, 600);
		oyunPen.setVisible(true);
		oyunPen.setResizable(false);
		oyunPen.setDefaultCloseOperation(oyunPen.EXIT_ON_CLOSE);

	}
	@Override
	public void paint(Graphics g) {
		if(oyunCalisiyor==true){
			super.paint(g);
			
			Rectangle cocukr=new Rectangle(cocukx,cocuky, cocuk.getWidth(), cocuk.getHeight());
		
			long tSon = System.currentTimeMillis();
			long tGecenSure = tSon - tbasla;
			double GecenSaniye = tGecenSure / 1000.0;
			
			if((int)GecenSaniye%2==0.0)
			{
				Oyunskor+=1;
				
				if(Oyunskor%100==0){
					Level++;
				}
				
				skorcocuk+=1;
			    skoranne1+=1;
			
			}
			g.drawString("Gecen Sure: "+String.valueOf(GecenSaniye), 320, 50);
			g.drawString("Cocuk Caný: "+String.valueOf(cocukCani), 10, 70);
			g.drawString("Level: "+String.valueOf(Level),320 ,70 );
		
			g.drawString("Anne Skoru: "+String.valueOf((int)skoranne1+skoranne2),650 ,70 );
			g.drawString("Cocuk Skoru: "+String.valueOf((int)skorcocuk),110 ,70 );
			
			if (Oyunskor%100==0) {
				SlipperClass.deger+=10;
				
				 cocukCani+=2;
		         skorcocuk+=15;
		         
		         if(Oyunskor==500)
		        	  oyunCalisiyor=false;
			         
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			repaint();	
		
			 for(int i=0;i<at.length;i++)
		       {

		    	   Rectangle trl=new Rectangle(at[i].x,at[i].y,54,29);
		    	   
		    	   if(cocukr.intersects(trl))
		    	   {
		    		 at[i].x=-50;
		    		 at[i].y=-50;
		    		 cocukCani--;
		    		 skoranne2+=10;
		    		   
		    	   }
		    	
		    	   if(cocukCani==0)
		    	   {
		  	    	 oyunCalisiyor=false;
		  	       }
		    	   
		      }
		
		 
		}
		else{
			g.setFont(new Font("Arial", 1, 28));
			
			if(skorcocuk<(skoranne1+skoranne2) )
			{
				g.drawString("Oyun Bitti Anne Kazandý\n Skorunuz: "+(skoranne1+skoranne2), 100,300);
			}
			else
				g.drawString("Oyun Bitti Cocuk Kazandý\n Skorunuz: "+(skorcocuk), 100,300);
			
		}
	
		repaint();
	}

	public void keyPressed(KeyEvent e) {
		
		if(oyunCalisiyor==true){
	
		if(e.getKeyCode()== KeyEvent.VK_UP && anney>0)
		{
			anney-=20;
			anne.setBounds(640 , anney, 149, 165);
		}
		
		if(e.getKeyCode()== KeyEvent.VK_DOWN && anney<500 )
		{
			anney+=20;
			anne.setBounds(640, anney, 149, 165);
		}
			
		if (e.getKeyCode()==KeyEvent.VK_W) {
			cocuky-=50;
			cocuk.setBounds(0, cocuky, 69, 106);
		}
		if (e.getKeyCode()==KeyEvent.VK_S) {
			cocuky+=50;
			cocuk.setBounds(0, cocuky, 69, 106);
		}
		
		if(cocuky<0) 
			cocuky=10;
		
		if(cocuky>510) 
			cocuky=450;

		}

	}

	public void keyReleased(KeyEvent   e) { 
		if(oyunCalisiyor==true ){
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
		{
		
			at[i] = new SlipperClass();
			panel.add(at[i].terlik, new Integer(2));
			i++;
			if(i==10)
				i=0;
			System.out.println(SlipperClass.deger);
        }
	}
	}

	public void keyTyped(KeyEvent arg0) {
	
	}

	

}

