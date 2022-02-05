package view.photoGUI;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import main.Main;
import model.PlayWav;
import view.sounds.MusicBackGround;

public class addPhoto{
	static int num;
	public addPhoto(int num) {
		this.num = num+1;
	}
	
	public static JButton AddPhoto() {
		String N = Integer.toString(num);
		String fileName = "/view/photoGUI/photo/"+N+".jpg";
		String OriginfileName = "/view/photoGUI/photo/Originals/"+N+".jpg";
		ImageIcon photo = new ImageIcon(Main.class.getResource(fileName));
		ImageIcon photoOn = new ImageIcon(Main.class.getResource(OriginfileName));
		
		JButton photoButton = new JButton(photo);
		
		photoButton.setBounds(370, 90, 500, 500);
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
				//photoButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				//photoButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		return photoButton;
	}

}
