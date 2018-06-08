import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Hakkinda extends JFrame {
	JTextArea yazi;
	ImageIcon hakkýndabg=new ImageIcon(("src/hakkýndabg.jpg"));
	JLabel bglabel=new JLabel(hakkýndabg);
	JPanel p=new JPanel();
	
	public Hakkinda()
	 {
		    setTitle("HAKKINDA");
			setSize(893, 400);
			setLocationRelativeTo(null);
			setLayout(null);
			setResizable(false);
			setMinimumSize(null);
			p.setBounds(0,0,898,463);
			p.setBackground(Color.white);
			bglabel.setBounds(0, 0, 893, 400);
			add(bglabel);
			add(p);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
	 }

	public static void main(String[] args) {
		Hakkinda deneme=new Hakkinda();

	}

}


