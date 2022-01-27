package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class DynamicBeat extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;


	private ImageIcon PlayBtn = new ImageIcon(Main.class.getResource("PlayBtn.png"));
	private ImageIcon PlayBtnMouseOver = new ImageIcon(Main.class.getResource("PlayBtnMouseOver.png"));
	private ImageIcon QuitBtn = new ImageIcon(Main.class.getResource("QuitBtn.png"));
	private ImageIcon QuitBtnMouseOver = new ImageIcon(Main.class.getResource("QuitBtnMouseOver.png"));

	private Image background = new ImageIcon(Main.class.getResource("introBackground.jpg")).getImage();

	private JButton playButton = new JButton(PlayBtn);
	private JButton QuitButton = new JButton(QuitBtn);

	public DynamicBeat() {
		setUndecorated(true);
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);

		playButton.setBounds(240, 500, 400, 100);
		playButton.setBorderPainted(false);
		playButton.setContentAreaFilled(false);
		playButton.setFocusPainted(false);
		playButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {
				try {
					playButton.setVisible(false);
					QuitButton.setVisible(false);
					background = new ImageIcon(Main.class.getResource("playBackground.jpg")).getImage();
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				playButton.setIcon(PlayBtnMouseOver);
				playButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				playButton.setIcon(PlayBtn);
				playButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		add(playButton);

		QuitButton.setBounds(660, 500, 400, 100);
		QuitButton.setBorderPainted(false);
		QuitButton.setContentAreaFilled(false);
		QuitButton.setFocusPainted(false);
		QuitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {
				try {
					System.exit(0);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				QuitButton.setIcon(QuitBtnMouseOver);
				QuitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				QuitButton.setIcon(QuitBtn);
				QuitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		add(QuitButton);

		Music introMusic = new Music("introMusic.mp3", true);
		introMusic.start();
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null);
		paintComponents(g);
		this.repaint();
	}

}
