package view.buttonsGUI;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import main.Main;
import view.SingleGameFrame;
import view.countGUI.HintCount;
import view.countGUI.NextCount;
import view.sounds.MusicBackGround;

public class SingleGameButtons extends JFrame {

	public static void AddSingleGameButtons(JFrame jFrame) {
		ImageIcon NextBtn = new ImageIcon(Main.class.getResource("/view/buttonsGUI/NextButton.png"));
		ImageIcon NextBtnMouseOver = new ImageIcon(Main.class.getResource("/view/buttonsGUI/NextButtonMouseOver.png"));
		ImageIcon PlayMusicBtn = new ImageIcon(Main.class.getResource("/view/buttonsGUI/PlayMusicBtn.png"));
		ImageIcon PlayMusicBtnMouseOver = new ImageIcon(Main.class.getResource("/view/buttonsGUI/PlayMusicBtnMouseOver.png"));
		ImageIcon SingerHintBtn = new ImageIcon(Main.class.getResource("/view/buttonsGUI/SingerHintBtn.png"));
		ImageIcon SingerHintBtnMouseOver = new ImageIcon(Main.class.getResource("/view/buttonsGUI/SingerHintBtnMouseOver.png"));
		ImageIcon SongHintBtn = new ImageIcon(Main.class.getResource("/view/buttonsGUI/SongHintBtn.png"));
		ImageIcon SongHintBtnMouseOver = new ImageIcon(Main.class.getResource("/view/buttonsGUI/SongHintBtnMouseOver.png"));

		JButton NextButton = new JButton(NextBtn);
		JButton PlayMusicButton = new JButton(PlayMusicBtn);
		JButton SingerHintButton = new JButton(SingerHintBtn);
		JButton SongHintButton = new JButton(SongHintBtn);

		JTextField Enter = new JTextField(10);
		JLabel label = new JLabel();

		HintCount hintcount = new HintCount();
		for(int i = 0; i<6; i++) {
			hintcount.setCount(i);
			hintcount.Remain().setVisible(true);
		}
		
		NextCount nextcount = new NextCount();
		for(int i = 0; i<6; i++) {
			nextcount.setCount(i);
			nextcount.Remain().setVisible(true);
		}
		
		NextButton.setBounds(1000, 570, 120, 120);
		NextButton.setBorderPainted(false);
		NextButton.setContentAreaFilled(false);
		NextButton.setFocusPainted(false);
		NextButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MusicBackGround buttonSound = new MusicBackGround("/view/sounds/ButtonSound.mp3", false);
				buttonSound.start();
				if (nextcount.getCount() > 0) {
					nextcount.Remain().setVisible(false);
					nextcount.setCount(nextcount.getCount()-1);
					jFrame.add(nextcount.Remain());
				} else {
					System.out.println("다음없음");
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				NextButton.setIcon(NextBtnMouseOver);
				NextButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				NextButton.setIcon(NextBtn);
				NextButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});

		PlayMusicButton.setBounds(80, 60, 120, 120);
		PlayMusicButton.setBorderPainted(false);
		PlayMusicButton.setContentAreaFilled(false);
		PlayMusicButton.setFocusPainted(false);
		PlayMusicButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MusicBackGround buttonSound = new MusicBackGround("/view/sounds/ButtonSound.mp3", false);
				buttonSound.start();
				SingleGameFrame.playMusic();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				PlayMusicButton.setIcon(PlayMusicBtnMouseOver);
				PlayMusicButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				PlayMusicButton.setIcon(PlayMusicBtn);
				PlayMusicButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});

		SingerHintButton.setBounds(50, 310, 300, 81);
		SingerHintButton.setBorderPainted(false);
		SingerHintButton.setContentAreaFilled(false);
		SingerHintButton.setFocusPainted(false);
		SingerHintButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MusicBackGround buttonSound = new MusicBackGround("/view/sounds/ButtonSound.mp3", false);
				buttonSound.start();
				if (hintcount.getCount() > 0) {
					hintcount.Remain().setVisible(false);
					hintcount.setCount(hintcount.getCount()-1);
					jFrame.add(hintcount.Remain());
				} else {
					System.out.println("힌트없음");
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				SingerHintButton.setIcon(SingerHintBtnMouseOver);
				SingerHintButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				SingerHintButton.setIcon(SingerHintBtn);
				SingerHintButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});

		SongHintButton.setBounds(50, 398, 300, 81);
		SongHintButton.setBorderPainted(false);
		SongHintButton.setContentAreaFilled(false);
		SongHintButton.setFocusPainted(false);
		SongHintButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MusicBackGround buttonSound = new MusicBackGround("/view/sounds/ButtonSound.mp3", false);
				buttonSound.start();
				if (hintcount.getCount() > 0) {
					hintcount.Remain().setVisible(false);
					hintcount.setCount(hintcount.getCount()-1);
					jFrame.add(hintcount.Remain());
				} else {
					System.out.println("힌트없음");
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				SongHintButton.setIcon(SongHintBtnMouseOver);
				SongHintButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				SongHintButton.setIcon(SongHintBtn);
				SongHintButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});

		Enter.setBounds(500, 600, 300, 81);
		Font font = new Font("Courier", Font.BOLD, 25);
		Enter.setFont(font);

		jFrame.add(NextButton);
		jFrame.add(PlayMusicButton);
		jFrame.add(SongHintButton);
		jFrame.add(SingerHintButton);
		jFrame.add(label);
		jFrame.add(Enter);
		jFrame.add(hintcount.Remain());
		jFrame.add(nextcount.Remain());
	}

}
