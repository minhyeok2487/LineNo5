package youtube;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.*;

public class WavPlayer {

	public static void main(String[] args) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		Scanner scanner = new Scanner(System.in);
		
		String filename = "C:/Users/Minhyeok/git/LineNo5/python_MH/audio/가시.wav";
		File file = new File(filename);
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		String response = "";
		while(!response.equals("Q")) {
			System.out.println("P = Play, S = Stop, R = Reset, Q = Quit");
			System.out.print("Enter yout choice: ");
			response = scanner.next();
			response = response.toUpperCase();
			switch (response) {
			case ("P"): clip.start();
			break;
			case ("S"): clip.stop();
			break;
			case ("R"): clip.setMicrosecondPosition(0);
			break;
			case ("Q"): clip.close();
			break;
			default : System.out.println("Not a valid response");
			}
		}
		System.out.println("BYE");
	}
}
