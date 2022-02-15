package view;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicScrollBarUI;

import main.Main;
import model.CountDown;
import view.buttonsGUI.SingleGameButtons;
import view.login.UserName;
import view.menuGUI.MenuBar;
import view.sounds.MusicBackGround;

public class FinalFrame extends JFrame {

	private Image SCI;
	private Graphics SCG;
	
	// 배경 화면
	private Image FinalBackGround = new ImageIcon("../LineNo5/src/view/playBackground.jpg").getImage();
	
	private JLabel gameoverLB = new JLabel(new ImageIcon("../LineNo5/src/view/finalIN/GameOverLB.png"));
	private JLabel ScoreBackGround = new JLabel(new ImageIcon("../LineNo5/src/view/finalIN/jumReal.gif"));
	private JLabel ScoreLabel = new JLabel(new ImageIcon("../LineNo5/src/view/finalIN/ok2.png"));
	private JLabel PlayerName = new JLabel(UserName.user);
	public static JLabel FinalCountDown = new JLabel("카운트 다운 시작 준비...");
	
	int index;
	JList MusicList;
	JLabel PlayList;
	JButton finalExit, reGame, reStart;

	public FinalFrame() {
		// 배경 음악
		MusicBackGround BackGroundMusic = new MusicBackGround("/view/sounds/BackGroundMusic.mp3", true);
		BackGroundMusic.start(); // 배경음악 재생
		Default.DefaultFrame(this, 1200, 720); // 프레임 디폴트
		MenuBar.GameMenubar(this); // 상단 메뉴바 추가 메소드
		FinalCountDown.setBounds(310, 100, 660, 160);
		FinalCountDown.setHorizontalAlignment(JLabel.CENTER);
		FinalCountDown.setOpaque(true);
		FinalCountDown.setBackground(new Color(0, 0, 0, 250));
		FinalCountDown.setForeground(Color.WHITE);
		FinalCountDown.setFont(new Font("Serif", Font.BOLD, 60));
		FinalCountDown.setVisible(false);
		add(FinalCountDown);

		JLabel Score = SingleGameButtons.NGUI;
		Score.setBounds(330, 315, SingleGameButtons.NGUI.getWidth(), SingleGameButtons.NGUI.getHeight());
		add(Score);

		ScoreLabel.setBounds(90, 165, 600, 100);
		add(ScoreLabel);

		PlayerName.setBounds(330, 500, 100, 50);
		PlayerName.setFont(new Font("굴림", Font.BOLD, 30));
		PlayerName.setForeground(Color.white);
		add(PlayerName);

		ScoreBackGround.setBounds(80, 200, 600, 400);
		ScoreBackGround.setBorder(null);
		ScoreBackGround.setOpaque(true);
		ScoreBackGround.setBackground(new Color(0, 0, 0, 100));
		add(ScoreBackGround);

		finalExit = new JButton("종료하기");
		finalExit.setBounds(80, 650, 100, 50);
		add(finalExit);

		finalExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		reGame = new JButton("다시하기");
		reGame.setBounds(200, 650, 100, 50);
		add(reGame);

		reGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BackGroundMusic.close();
				dispose();
				SingleGameButtons.LastV.clear();
				SingleGameButtons.numbergui.setN(0);
				SingleGameButtons.i = 0;
				CountDown com = new CountDown(3, SingleGameFrame.num, Main.MA);
				Thread thcom = new Thread(com);
				thcom.start();
				
			}
		});

		reStart = new JButton("처음으로");
		reStart.setBounds(320, 650, 100, 50);
		add(reStart);

		reStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BackGroundMusic.close();
				dispose();
				SingleGameButtons.LastV.clear();
				SingleGameButtons.numbergui.setN(0);
				SingleGameButtons.i = 0;
				SingleGameFrame.num = 0;
				if(MainFrame.introMusic.getState() == Thread.State.TERMINATED) {
					MainFrame.introMusic = new MusicBackGround("/view/sounds/introMusic.mp3", true);
				}
				MainFrame.introMusic.start();
			}
		});

		PlayList = new JLabel("Play List");
		PlayList.setBounds(700, 200, 300, 50);
		PlayList.setFont(new Font("굴림", Font.BOLD, 30));
		PlayList.setForeground(Color.white);
		add(PlayList);

		MusicList = new JList(SingleGameButtons.LastV.toArray());
		MusicList.setFont(new Font("굴림", Font.PLAIN, 20));
		MusicList.setForeground(Color.white);
		MusicList.setOpaque(true);
		MusicList.setBackground(new Color(0, 0, 0, 100));
		JScrollPane JS = new JScrollPane(MusicList);
		JS.setBounds(700, 250, 500, 350);
		JS.setOpaque(true);
		JS.setBackground(new Color(0, 0, 0, 100));
		JS.getHorizontalScrollBar().setOpaque(true);
		JS.getHorizontalScrollBar().setBackground(new Color(0, 0, 0, 100));
		JS.setBorder(null);
		JS.getHorizontalScrollBar().setUI(new BasicScrollBarUI() {
			@Override // 스크롤 휠 색상
			protected void configureScrollBarColors() {
				this.thumbColor = new Color(255, 255, 255, 100);
			}

			@Override // 스크롤 버튼 색상
			protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
				c.setBackground(new Color(255, 255, 255, 100));
			}
		});

		add(JS);

		MusicList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				index = MusicList.locationToIndex(evt.getPoint());
				MusicList = (JList) evt.getSource();
				if (evt.getClickCount() == 2) {
					String url = SingleGameButtons.LastIp[index];
					try {
						Desktop.getDesktop().browse(new URI(url));
					} catch (IOException e) {
						e.printStackTrace();
					} catch (URISyntaxException e) {
						e.printStackTrace();
					}
				}

				// int index = list.locationToIndex(evt.getPoint());

			}
		});

	}

	public void paint(Graphics g) {
		SCI = createImage(1200, 720);
		SCG = SCI.getGraphics();
		screenDraw(SCG);
		g.drawImage(SCI, 0, 0, null);

	}

	public void screenDraw(Graphics g) {
		g.drawImage(FinalBackGround, 0, 0, null);
		paintComponents(g);
		this.repaint();
	}

}