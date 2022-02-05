package view.photoGUI;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import main.Main;
import view.sounds.MusicBackGround;

public class addPhoto{
	public static JButton AddPhoto() {
		ImageIcon photo = new ImageIcon(Main.class.getResource("/view/photoGUI/photo/1.jpg"));
		ImageIcon photoOn = new ImageIcon(Main.class.getResource("/view/photoGUI/photo/Originals/1.jpg"));
		
		JButton photoButton = new JButton(photo);
		
		photoButton.setBounds(750, 50, 400, 400);
		photoButton.setBorderPainted(false);
		photoButton.setContentAreaFilled(false);
		photoButton.setFocusPainted(false);
		photoButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MusicBackGround buttonSound = new MusicBackGround("/view/sounds/ButtonSound.mp3", false);
				buttonSound.start();
				photoButton.setIcon(photoOn);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				photoButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				photoButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		return photoButton;
	}

}
