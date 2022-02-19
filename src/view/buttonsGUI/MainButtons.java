package view.buttonsGUI;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import clientChat.gameClient;
import main.Main;
import model.CountDown;
import view.MainFrame;
import view.sounds.MusicBackGround;

public class MainButtons extends JFrame{
	private static final String HOST = "127.0.0.1";
	
	public static void AddMainButtons(JFrame jFrame) throws UnknownHostException {
		ImageIcon PlayBtn = new ImageIcon(Main.class.getResource("/view/buttonsGUI/PlayBtn.png"));
		ImageIcon PlayBtnMouseOver = new ImageIcon(Main.class.getResource("/view/buttonsGUI/PlayBtnMouseOver.png"));
		ImageIcon QuitBtn = new ImageIcon(Main.class.getResource("/view/buttonsGUI/QuitBtn.png"));
		ImageIcon QuitBtnMouseOver = new ImageIcon(Main.class.getResource("/view/buttonsGUI/QuitBtnMouseOver.png"));
		ImageIcon Single1Btn = new ImageIcon(Main.class.getResource("/view/buttonsGUI/Single1Btn.png"));
		ImageIcon Single1BtnMouseOver = new ImageIcon(Main.class.getResource("/view/buttonsGUI/Single1BtnMouseOver.png"));
		ImageIcon Single5Btn = new ImageIcon(Main.class.getResource("/view/buttonsGUI/Single5Btn.png"));
		ImageIcon Single5BtnMouseOver = new ImageIcon(Main.class.getResource("/view/buttonsGUI/Single5BtnMouseOver.png"));
		ImageIcon Single10Btn = new ImageIcon(Main.class.getResource("/view/buttonsGUI/Single10Btn.png"));
		ImageIcon Single10BtnMouseOver = new ImageIcon(Main.class.getResource("/view/buttonsGUI/Single10BtnMouseOver.png"));
		ImageIcon MultiBtn = new ImageIcon(Main.class.getResource("/view/buttonsGUI/MultiBtn.png"));
		ImageIcon MultiBtnMouseOver = new ImageIcon(Main.class.getResource("/view/buttonsGUI/MultiBtnMouseOver.png"));
		ImageIcon MultiBtnOff = new ImageIcon(Main.class.getResource("/view/buttonsGUI/MultiBtnOff.png"));
		ImageIcon UpdateBtn = new ImageIcon(Main.class.getResource("/view/buttonsGUI/updateBtn.png"));
		ImageIcon UpdateBtnMouseOver = new ImageIcon(Main.class.getResource("/view/buttonsGUI/updateBtnMouseOver.png"));
		ImageIcon UpdateBtnOff = new ImageIcon(Main.class.getResource("/view/buttonsGUI/UpdateBtnOff.png"));
		
		
		
		JButton playButton = new JButton(PlayBtn);
		JButton QuitButton = new JButton(QuitBtn);
		JButton Single1Button = new JButton(Single1Btn);
		JButton Single5Button = new JButton(Single5Btn);
		JButton Single10Button = new JButton(Single10Btn);
		JButton MultiButton = new JButton(MultiBtn);
		
		JLabel MultiButtonOff = new JLabel(MultiBtnOff);
		MultiButtonOff.setBounds(650, 504, 400, 204);
		
		
		JLabel UpdateButtonOff = new JLabel(UpdateBtnOff);
		UpdateButtonOff.setBounds(1100, 30, 120, 120);
		jFrame.add(UpdateButtonOff);
		
		
		JButton UpdateButton = new JButton(UpdateBtn);
		UpdateButton.setBounds(1100, 30, 120, 120);
		UpdateButton.setBorderPainted(false);
		UpdateButton.setContentAreaFilled(false);
		UpdateButton.setFocusPainted(false);
		UpdateButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// 서버와 연결을 해야된다.
				new gameClient();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				UpdateButton.setIcon(UpdateBtn);
				UpdateButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				UpdateButton.setIcon(UpdateBtnMouseOver);
				UpdateButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		jFrame.add(UpdateButton);
		
		// 인터넷 연결 상태 체크
		boolean isConnected = !HOST.equals(InetAddress.getLocalHost().getHostAddress().toString());
		if (isConnected) { // 연결이 되있으면
			UpdateButtonOff.setVisible(false);
			UpdateButton.setVisible(true);
			MultiButtonOff.setVisible(false);
			MultiButton.setVisible(true);
		} else { // 연결이 안되어있으면
			UpdateButtonOff.setVisible(true);
			UpdateButton.setVisible(false);
			MultiButtonOff.setVisible(true);
			MultiButton.setVisible(false);
		}
		

		playButton.setBounds(240, 500, 400, 204);
		playButton.setBorderPainted(false);
		playButton.setContentAreaFilled(false);
		playButton.setFocusPainted(false);
		playButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MusicBackGround buttonSound = new MusicBackGround("/view/sounds/ButtonSound.mp3", false);
				buttonSound.start();
				playButton.setVisible(false);
				QuitButton.setVisible(false);
				jFrame.add(Single1Button);
				jFrame.add(Single5Button);
				jFrame.add(Single10Button);
				jFrame.add(MultiButton);
				jFrame.add(MultiButtonOff);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				playButton.setIcon(PlayBtnMouseOver);
				playButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				playButton.setIcon(PlayBtn);
				playButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		jFrame.add(playButton);

		QuitButton.setBounds(660, 500, 400, 204);
		QuitButton.setBorderPainted(false);
		QuitButton.setContentAreaFilled(false);
		QuitButton.setFocusPainted(false);
		QuitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MusicBackGround buttonSound = new MusicBackGround("/view/sounds/ButtonSound.mp3", false);
				buttonSound.start();
				try {
					// 일정 시간 지난 후 시스템 종료
					Thread.sleep(100);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				QuitButton.setIcon(QuitBtnMouseOver);
				QuitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				QuitButton.setIcon(QuitBtn);
				QuitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		jFrame.add(QuitButton);
		

		Single1Button.setBounds(200, 250, 400, 204);
		Single1Button.setBorderPainted(false);
		Single1Button.setContentAreaFilled(false);
		Single1Button.setFocusPainted(false);
		Single1Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MusicBackGround buttonSound = new MusicBackGround("/view/sounds/ButtonSound.mp3", false);
				buttonSound.start();
				// 3초 후, 싱글 1초로 음악맞추기 게임 시작
				MainFrame.introMusic.close();
				CountDown com = new CountDown(3,1, jFrame);
				Thread thcom = new Thread(com);
				thcom.start();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
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
				MusicBackGround buttonSound = new MusicBackGround("/view/sounds/ButtonSound.mp3", false);
				buttonSound.start();
				// 싱글 5초로 음악맞추기 게임 시작
				MainFrame.introMusic.close();
				CountDown com = new CountDown(3,5, jFrame);
				Thread thcom = new Thread(com);
				thcom.start();
				//CountDownFrame.add(com);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
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
				MusicBackGround buttonSound = new MusicBackGround("/view/sounds/ButtonSound.mp3", false);
				buttonSound.start();
				// 싱글 10초로 음악맞추기 게임 시작
				MainFrame.introMusic.close();
				CountDown com = new CountDown(3,10, jFrame);
				Thread thcom = new Thread(com);
				thcom.start();
				//CountDownFrame.add(com);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
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
				MusicBackGround buttonSound = new MusicBackGround("/view/sounds/ButtonSound.mp3", false);
				buttonSound.start();
				// 멀티 음악맞추기 게임 시작
				MainFrame.introMusic.close();
				CountDown com = new CountDown(3,111, jFrame);
				Thread thcom = new Thread(com);
				thcom.start();
				//CountDownFrame.add(com);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
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
	

}
