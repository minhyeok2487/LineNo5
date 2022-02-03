package model;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import javax.sound.sampled.*;

public class PlayWav {
	String dir;
	static Random random = new Random();
	public String sendname ="";
	public PlayWav(String dir) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		ReadTxt readtxt = new ReadTxt();
		this.dir = dir;
		int N = random.nextInt(readtxt.links.size()-1);
		String number = Integer.toString(N);
		String filename = dir + number+".wav";
		sendname = number+".wav";
		File file = new File(filename);
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
	}
}
