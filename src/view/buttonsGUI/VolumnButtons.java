package view.buttonsGUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.sound.sampled.FloatControl;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Main;
import model.PlayWav;
import music.MusicPlayer;
import view.sounds.MusicBackGround;

public class VolumnButtons {
	public static int N = 5;
	public static void AddVolumnButtons(JFrame jFrame) {
		ImageIcon SettingBtn = new ImageIcon(Main.class.getResource("/view/buttonsGUI/SettingBtn.png"));
		ImageIcon SettingBtnMouseOver = new ImageIcon(
				Main.class.getResource("/view/buttonsGUI/SettingBtnMouseOver.png"));
		ImageIcon BackGroundSound = new ImageIcon(Main.class.getResource("/view/buttonsGUI/BackGroundSound.png"));
		ImageIcon HighBtn = new ImageIcon(Main.class.getResource("/view/buttonsGUI/HighBtn.png"));
		ImageIcon HighBtnMouseOver = new ImageIcon(Main.class.getResource("/view/buttonsGUI/HighBtnMouseOver.png"));
		ImageIcon LowBtn = new ImageIcon(Main.class.getResource("/view/buttonsGUI/LowBtn.png"));
		ImageIcon LowBtnMouseOver = new ImageIcon(Main.class.getResource("/view/buttonsGUI/LowBtnMouseOver.png"));

		JButton HighButton = new JButton(HighBtn);
		JButton LowButton = new JButton(LowBtn);
		JButton SettingButton = new JButton(SettingBtn);

		JPanel Setting = new JPanel();
		Setting.setBounds(880, 100, 280, 200);
		Setting.setOpaque(true);
		Setting.setBackground(new Color(255, 255, 255, 170));
		Setting.setVisible(false);
		
		
		JLabel number = new JLabel(Integer.toString(N));
		number.setFont(new Font("Serif",Font.BOLD,30));
		number.setForeground(Color.white);
		
		HighButton.setBorderPainted(false);
		HighButton.setContentAreaFilled(false);
		HighButton.setFocusPainted(false);
		HighButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MusicBackGround buttonSound = new MusicBackGround("/view/sounds/ButtonSound.mp3", false);
				buttonSound.start();
				if(N < 10 && N >= 0) {
					Long nowFrame = PlayWav.clip.getMicrosecondPosition();
					PlayWav.clip.stop();
					PlayWav.clip.setMicrosecondPosition(PlayWav.clipTime);
					PlayWav.volume.setValue(PlayWav.volume.getValue() + 2.0f);
					N++;
					number.setText(Integer.toString(N));
					PlayWav.clip.setMicrosecondPosition(nowFrame); 
					PlayWav.clip.start();
				}
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				HighButton.setIcon(HighBtnMouseOver);
				HighButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				HighButton.setIcon(HighBtn);
				HighButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});

		LowButton.setBorderPainted(false);
		LowButton.setContentAreaFilled(false);
		LowButton.setFocusPainted(false);
		LowButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MusicBackGround buttonSound = new MusicBackGround("/view/sounds/ButtonSound.mp3", false);
				buttonSound.start();
				if(N <= 10 && N > 0) {
					Long nowFrame = PlayWav.clip.getMicrosecondPosition();
					PlayWav.clip.stop();
					PlayWav.clip.setMicrosecondPosition(PlayWav.clipTime);
					PlayWav.volume.setValue(PlayWav.volume.getValue() - 2.0f);
					N--;
					number.setText(Integer.toString(N));
					PlayWav.clip.setMicrosecondPosition(nowFrame);
					PlayWav.clip.start();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				LowButton.setIcon(LowBtnMouseOver);
				LowButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				LowButton.setIcon(LowBtn);
				LowButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});

		JLabel BackGroundSoundLabel = new JLabel(BackGroundSound);
		BackGroundSoundLabel.setBounds(980, 100, 250, 100);
		Setting.add(BackGroundSoundLabel);
		Setting.add(LowButton);
		Setting.add(number);
		Setting.add(HighButton);
		

		SettingButton.setBounds(1120, 35, 55, 55);
		SettingButton.setBorderPainted(false);
		SettingButton.setContentAreaFilled(false);
		SettingButton.setFocusPainted(false);
		SettingButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MusicBackGround buttonSound = new MusicBackGround("/view/sounds/ButtonSound.mp3", false);
				buttonSound.start();
				if (Setting.isVisible() == false) {
					Setting.setVisible(true);
				} else if (Setting.isVisible() == true) {
					Setting.setVisible(false);
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				SettingButton.setIcon(SettingBtnMouseOver);
				SettingButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				SettingButton.setIcon(SettingBtn);
				SettingButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		jFrame.add(SettingButton);
		jFrame.add(Setting);
	}
	
	public static void MultiVolumnButtons(JFrame jFrame) {
		ImageIcon SettingBtn = new ImageIcon(Main.class.getResource("/view/buttonsGUI/SettingBtn.png"));
		ImageIcon SettingBtnMouseOver = new ImageIcon(
				Main.class.getResource("/view/buttonsGUI/SettingBtnMouseOver.png"));
		ImageIcon BackGroundSound = new ImageIcon(Main.class.getResource("/view/buttonsGUI/BackGroundSound.png"));
		ImageIcon HighBtn = new ImageIcon(Main.class.getResource("/view/buttonsGUI/HighBtn.png"));
		ImageIcon HighBtnMouseOver = new ImageIcon(Main.class.getResource("/view/buttonsGUI/HighBtnMouseOver.png"));
		ImageIcon LowBtn = new ImageIcon(Main.class.getResource("/view/buttonsGUI/LowBtn.png"));
		ImageIcon LowBtnMouseOver = new ImageIcon(Main.class.getResource("/view/buttonsGUI/LowBtnMouseOver.png"));

		JButton HighButton = new JButton(HighBtn);
		JButton LowButton = new JButton(LowBtn);
		JButton SettingButton = new JButton(SettingBtn);

		JPanel Setting = new JPanel();
		Setting.setBounds(1000, 100, 150, 300);
		Setting.setOpaque(true);
		Setting.setBackground(new Color(255, 255, 255, 170));
		Setting.setVisible(false);
		
		
		JLabel number = new JLabel(Integer.toString(N));
		number.setFont(new Font("Serif",Font.BOLD,30));
		number.setForeground(Color.white);
		
		HighButton.setBorderPainted(false);
		HighButton.setContentAreaFilled(false);
		HighButton.setFocusPainted(false);
		HighButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MusicBackGround buttonSound = new MusicBackGround("/view/sounds/ButtonSound.mp3", false);
				buttonSound.start();
				if(N < 10 && N >= 0) {
					Long nowFrame = MusicPlayer.ParentSong.getMicrosecondPosition();
					MusicPlayer.ParentSong.stop();
					MusicPlayer.ParentSong.setMicrosecondPosition(MusicPlayer.clipTime);
					MusicPlayer.volume.setValue(MusicPlayer.volume.getValue() + 2.0f);
					N++;
					number.setText(Integer.toString(N));
					MusicPlayer.ParentSong.setMicrosecondPosition(nowFrame); 
					MusicPlayer.ParentSong.start();
				}
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				HighButton.setIcon(HighBtnMouseOver);
				HighButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				HighButton.setIcon(HighBtn);
				HighButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});

		LowButton.setBorderPainted(false);
		LowButton.setContentAreaFilled(false);
		LowButton.setFocusPainted(false);
		LowButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MusicBackGround buttonSound = new MusicBackGround("/view/sounds/ButtonSound.mp3", false);
				buttonSound.start();
				if(N <= 10 && N > 0) {
					Long nowFrame = MusicPlayer.ParentSong.getMicrosecondPosition();
					MusicPlayer.ParentSong.stop();
					MusicPlayer.ParentSong.setMicrosecondPosition(MusicPlayer.clipTime);
					MusicPlayer.volume.setValue(MusicPlayer.volume.getValue() - 2.0f);
					N--;
					number.setText(Integer.toString(N));
					MusicPlayer.ParentSong.setMicrosecondPosition(nowFrame); 
					MusicPlayer.ParentSong.start();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				LowButton.setIcon(LowBtnMouseOver);
				LowButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				LowButton.setIcon(LowBtn);
				LowButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});

		JLabel BackGroundSoundLabel = new JLabel(BackGroundSound);
		Setting.add(BackGroundSoundLabel);
		Setting.add(HighButton);
		Setting.add(number);
		Setting.add(LowButton);
		
		

		SettingButton.setBounds(1120, 35, 55, 55);
		SettingButton.setBorderPainted(false);
		SettingButton.setContentAreaFilled(false);
		SettingButton.setFocusPainted(false);
		SettingButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MusicBackGround buttonSound = new MusicBackGround("/view/sounds/ButtonSound.mp3", false);
				buttonSound.start();
				if (Setting.isVisible() == false) {
					Setting.setVisible(true);
				} else if (Setting.isVisible() == true) {
					Setting.setVisible(false);
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				SettingButton.setIcon(SettingBtnMouseOver);
				SettingButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				SettingButton.setIcon(SettingBtn);
				SettingButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		jFrame.add(SettingButton);
		jFrame.add(Setting);
	}
}
