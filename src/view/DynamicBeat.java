package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.*;

public class DynamicBeat extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;

	private ImageIcon PlayBtn = new ImageIcon(Main.class.getResource("PlayBtn.png"));
	private ImageIcon PlayBtnMouseOver = new ImageIcon(Main.class.getResource("PlayBtnMouseOver.png"));
	private ImageIcon QuitBtn = new ImageIcon(Main.class.getResource("QuitBtn.png"));
	private ImageIcon QuitBtnMouseOver = new ImageIcon(Main.class.getResource("QuitBtnMouseOver.png"));
	private ImageIcon ExitBtn = new ImageIcon(Main.class.getResource("ExitButton.png"));
	private ImageIcon ExitBtnMouseOver = new ImageIcon(Main.class.getResource("ExitButtonMouseOver.png"));
	private ImageIcon Single1Btn = new ImageIcon(Main.class.getResource("Single1Btn.png"));
	private ImageIcon Single1BtnMouseOver = new ImageIcon(Main.class.getResource("Single1BtnMouseOver.png"));
	private ImageIcon Single5Btn = new ImageIcon(Main.class.getResource("Single5Btn.png"));
	private ImageIcon Single5BtnMouseOver = new ImageIcon(Main.class.getResource("Single5BtnMouseOver.png"));
	private ImageIcon Single10Btn = new ImageIcon(Main.class.getResource("Single10Btn.png"));
	private ImageIcon Single10BtnMouseOver = new ImageIcon(Main.class.getResource("Single10BtnMouseOver.png"));
	private ImageIcon MultiBtn = new ImageIcon(Main.class.getResource("MultiBtn.png"));
	private ImageIcon MultiBtnMouseOver = new ImageIcon(Main.class.getResource("MultiBtnMouseOver.png"));

	private Image background = new ImageIcon(Main.class.getResource("introBackground.jpg")).getImage();

	private JButton playButton = new JButton(PlayBtn);
	private JButton QuitButton = new JButton(QuitBtn);
	private JButton Single1Button = new JButton(Single1Btn);
	private JButton Single5Button = new JButton(Single5Btn);
	private JButton Single10Button = new JButton(Single10Btn);
	private JButton MultiButton = new JButton(MultiBtn);

	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("MenuBar.png")));
	private JButton exitButton = new JButton(ExitBtn);
	private int mouseX, mouseY;

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

		exitButton.setBounds(1245, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonSound = new Music("ButtonSound.mp3", false);
				buttonSound.start();
				try {
					Thread.sleep(100);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(ExitBtnMouseOver);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonSound = new Music("ButtonSound.mp3", false);
				buttonSound.start();

			}

			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(ExitBtn);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		add(exitButton);

		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menuBar);

		playButton.setBounds(240, 500, 400, 204);
		playButton.setBorderPainted(false);
		playButton.setContentAreaFilled(false);
		playButton.setFocusPainted(false);
		playButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonSound = new Music("ButtonSound.mp3", false);
				buttonSound.start();
				playButton.setVisible(false);
				QuitButton.setVisible(false);
				//background = new ImageIcon(Main.class.getResource("playBackground.jpg")).getImage();
				add(Single1Button);
				add(Single5Button);
				add(Single10Button);
				add(MultiButton);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				Music buttonSound = new Music("ButtonSound.mp3", false);
				buttonSound.start();
				playButton.setIcon(PlayBtnMouseOver);
				playButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				playButton.setIcon(PlayBtn);
				playButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		add(playButton);

		QuitButton.setBounds(660, 500, 400, 204);
		QuitButton.setBorderPainted(false);
		QuitButton.setContentAreaFilled(false);
		QuitButton.setFocusPainted(false);
		QuitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonSound = new Music("ButtonSound.mp3", false);
				buttonSound.start();
				try {
					Thread.sleep(100);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				Music buttonSound = new Music("ButtonSound.mp3", false);
				buttonSound.start();
				QuitButton.setIcon(QuitBtnMouseOver);
				QuitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				QuitButton.setIcon(QuitBtn);
				QuitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		add(QuitButton);
		Music introMusic = new Music("introMusic.mp3", true);
		introMusic.start();

		Single1Button.setBounds(200, 250, 400, 204);
		Single1Button.setBorderPainted(false);
		Single1Button.setContentAreaFilled(false);
		Single1Button.setFocusPainted(false);
		Single1Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonSound = new Music("ButtonSound.mp3", false);
				buttonSound.start();
				// 싱글 1초로 음악맞추기 게임 시작
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				Music buttonSound = new Music("ButtonSound.mp3", false);
				buttonSound.start();
				Single1Button.setIcon(Single1BtnMouseOver);
				Single1Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Single1Button.setIcon(Single1Btn);
				Single1Button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		
		Single5Button.setBounds(650, 250, 400, 204);
		Single5Button.setBorderPainted(false);
		Single5Button.setContentAreaFilled(false);
		Single5Button.setFocusPainted(false);
		Single5Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonSound = new Music("ButtonSound.mp3", false);
				buttonSound.start();
				// 싱글 5초로 음악맞추기 게임 시작
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				Music buttonSound = new Music("ButtonSound.mp3", false);
				buttonSound.start();
				Single5Button.setIcon(Single5BtnMouseOver);
				Single5Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Single5Button.setIcon(Single5Btn);
				Single5Button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		
		Single10Button.setBounds(200, 504, 400, 204);
		Single10Button.setBorderPainted(false);
		Single10Button.setContentAreaFilled(false);
		Single10Button.setFocusPainted(false);
		Single10Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonSound = new Music("ButtonSound.mp3", false);
				buttonSound.start();
				// 싱글 10초로 음악맞추기 게임 시작
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				Music buttonSound = new Music("ButtonSound.mp3", false);
				buttonSound.start();
				Single10Button.setIcon(Single10BtnMouseOver);
				Single10Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Single10Button.setIcon(Single10Btn);
				Single10Button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		
		MultiButton.setBounds(650, 504, 400, 204);
		MultiButton.setBorderPainted(false);
		MultiButton.setContentAreaFilled(false);
		MultiButton.setFocusPainted(false);
		MultiButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonSound = new Music("ButtonSound.mp3", false);
				buttonSound.start();
				// 멀티 음악맞추기 게임 시작
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				Music buttonSound = new Music("ButtonSound.mp3", false);
				buttonSound.start();
				MultiButton.setIcon(MultiBtnMouseOver);
				MultiButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				MultiButton.setIcon(MultiBtn);
				MultiButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});

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
