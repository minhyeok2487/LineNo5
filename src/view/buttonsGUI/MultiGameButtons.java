package view.buttonsGUI;

import java.awt.Color;
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
import view.MultiGameFrame;
import view.sounds.MusicBackGround;

public class MultiGameButtons extends JFrame{
	public static void AddMultiGameButtons(JFrame jFrame) {
		ImageIcon PlayMusicBtn = new ImageIcon(Main.class.getResource("/view/buttonsGUI/PlayMusicBtn.png"));
		ImageIcon PlayMusicBtnMouseOver = new ImageIcon(Main.class.getResource("/view/buttonsGUI/PlayMusicBtnMouseOver.png"));
		JButton PlayMusicButton = new JButton(PlayMusicBtn);

		ImageIcon character1 = new ImageIcon(Main.class.getResource("/view/charactersGUI/character1.png"));
		JLabel Ch1 = new JLabel(character1);
		ImageIcon character2 = new ImageIcon(Main.class.getResource("/view/charactersGUI/character2.png"));
		JLabel Ch2 = new JLabel(character2);
		ImageIcon character3 = new ImageIcon(Main.class.getResource("/view/charactersGUI/character3.png"));
		JLabel Ch3 = new JLabel(character3);
		ImageIcon character4 = new ImageIcon(Main.class.getResource("/view/charactersGUI/character4.png"));
		JLabel Ch4 = new JLabel(character4);
		
		JLabel Ch1Name = new JLabel();
		JLabel Ch2Name = new JLabel();
		JLabel Ch3Name = new JLabel();
		JLabel Ch4Name = new JLabel();
		
		JTextField Enter = new JTextField("정답입력",10);
		
		PlayMusicButton.setBounds(80, 60, 120, 120);
		PlayMusicButton.setBorderPainted(false);
		PlayMusicButton.setContentAreaFilled(false);
		PlayMusicButton.setFocusPainted(false);
		PlayMusicButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MusicBackGround buttonSound = new MusicBackGround("/view/sounds/ButtonSound.mp3", false);
				buttonSound.start();
				MultiGameFrame.playMusic();
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
		
		Ch1.setBounds(160,340,165,230);
		Ch1Name.setText("첫번째 플레이어");
		Ch1Name.setFont(new Font("Courier", Font.BOLD, 20));
		Ch1Name.setOpaque(true); //Opaque값을 true로 미리 설정해 주어야 배경색이 적용된다.
		Ch1Name.setBackground(Color.WHITE);
		Ch1Name.setHorizontalAlignment(JLabel.CENTER);
		Ch1Name.setBounds(160+7,340+160,165,25);
		
		
		Ch2.setBounds(160+165+80,340,165,230);
		Ch2Name.setText("두번째 플레이어");
		Ch2Name.setFont(new Font("Courier", Font.BOLD, 20));
		Ch2Name.setOpaque(true); //Opaque값을 true로 미리 설정해 주어야 배경색이 적용된다.
		Ch2Name.setBackground(Color.WHITE);
		Ch2Name.setHorizontalAlignment(JLabel.CENTER);
		Ch2Name.setBounds(160+165+80+7,340+160,165,25);
		
		Ch3.setBounds(160+165+80+165+80,340,165,230);
		Ch3Name.setText("세번째 플레이어");
		Ch3Name.setFont(new Font("Courier", Font.BOLD, 20));
		Ch3Name.setOpaque(true); //Opaque값을 true로 미리 설정해 주어야 배경색이 적용된다.
		Ch3Name.setBackground(Color.WHITE);
		Ch3Name.setHorizontalAlignment(JLabel.CENTER);
		Ch3Name.setBounds(160+165+80+165+80+7,340+160,165,25);
		
		Ch4.setBounds(160+165+80+165+80+165+80,340,165,230);
		Ch4Name.setText("네번째 플레이어");
		Ch4Name.setFont(new Font("Courier", Font.BOLD, 20));
		Ch4Name.setOpaque(true); //Opaque값을 true로 미리 설정해 주어야 배경색이 적용된다.
		Ch4Name.setBackground(Color.WHITE);
		Ch4Name.setHorizontalAlignment(JLabel.CENTER);
		Ch4Name.setBounds(160+165+80+165+80+165+80+7,340+160,165,25);
		
		Enter.setBounds(500, 600, 300, 81);
		Font font = new Font("Courier", Font.BOLD,25);
		Enter.setFont(font);
		
	
		jFrame.add(PlayMusicButton);
		
		jFrame.add(Ch1Name);
		jFrame.add(Ch1);
		jFrame.add(Ch2Name);
		jFrame.add(Ch2);
		jFrame.add(Ch3Name);
		jFrame.add(Ch3);
		jFrame.add(Ch4Name);
		jFrame.add(Ch4);
		jFrame.add(Enter);
	}
}
