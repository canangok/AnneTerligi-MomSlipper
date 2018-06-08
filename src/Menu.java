

	import java.awt.Graphics;
	import java.awt.Image;
	import java.awt.Insets;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.io.File;

	import javax.sound.sampled.AudioInputStream;
	import javax.sound.sampled.AudioSystem;
	import javax.sound.sampled.Clip;
	import javax.swing.ImageIcon;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JPanel;
	import javax.swing.border.Border;

	import sun.audio.*;

	public class Menu extends JFrame {
		ImageIcon bas, hak, c�k;
		JPanel p;
		JButton basla, hakk�nda, c�k�s;
		int level = 0;

		public Menu() {
			setTitle("ANNE TERL���");
			setSize(500, 500);
			setLocationRelativeTo(null); 
			setLayout(null);
			setResizable(false);
			setMinimumSize(null);

			ImageIcon arkaplan = new ImageIcon(("src/images/arkaplan.jpg"));
			bas = new ImageIcon(("src/images/basla.png"));
			hak = new ImageIcon(("src/images/hakkinda.png"));
			c�k = new ImageIcon(("src/images/cikis.png"));
			JLabel ap = new JLabel(arkaplan);
			ap.setBounds(0, 0, 500, 500);
			
			Ses();

			basla = new JButton("");
			basla.setOpaque(false);
			basla.setContentAreaFilled(false);
			basla.setBorderPainted(false);
			basla.setBounds(10, 20, 320, 100);
			basla.setIcon(bas);

			basla.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					AnneTerligi gec = new AnneTerligi();
					gec.setVisible(true);
					gec.setBounds(250, 50, 800, 600);
					gec.setDefaultCloseOperation(gec.EXIT_ON_CLOSE);
					gec.setResizable(false);

				}

			});

			hakk�nda = new JButton("");
			hakk�nda.setOpaque(false);
			hakk�nda.setContentAreaFilled(false);
			hakk�nda.setBorderPainted(false);
			hakk�nda.setBounds(0, 110, 390, 100);
			hakk�nda.setIcon(hak);
			hakk�nda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new Hakkinda();
				}

			});

			c�k�s = new JButton("");
			c�k�s.setOpaque(false);
			c�k�s.setContentAreaFilled(false);
			c�k�s.setBorderPainted(false);
			c�k�s.setBounds(10, 200, 300, 100);
			c�k�s.setIcon(c�k);
			c�k�s.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}

			});

			p = new JPanel();
			p.setBounds(70, 100, 400, 400);
			p.setLayout(null);
			p.setOpaque(false);
			p.add(basla);
			p.add(hakk�nda);
			p.add(c�k�s);
			add(p);
			add(ap);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
		}

		public void Ses() {
			try {
				AudioInputStream muzikstreamet = AudioSystem
						.getAudioInputStream(new File("src/music/oyunmuzigi.wav").getAbsoluteFile());
				Clip muzik = AudioSystem.getClip();
				muzik.open(muzikstreamet);
				muzik.start();
				muzik.loop(muzik.LOOP_CONTINUOUSLY);
			} catch (Exception e) {
				System.out.println("Olu�an Hata: " + e.getMessage());
			}
		}

		public static void main(String[] args) {
			new Menu();
		}

	}


