package clientChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.StringTokenizer;

import music.MusicPlayer;
import serverChat.songRandom;
import view.buttonsGUI.MultiGameButtons;

public class gameClientReadMsg extends Thread {
	Socket socket = gameClient.getSocket();
	BufferedReader br;
	MusicPlayer musicPlayer;
	public static boolean GameIng = false; 

	public static ArrayList<Integer> serverSongRandom;
	StringTokenizer StringTZ;

	public gameClientReadMsg(BufferedReader br) {
		this.br = br;
		start(); 
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				String serverMsg = br.readLine();
				String subStr = serverMsg.substring(serverMsg.length()-1);
				if(serverMsg.equals("start"))
				{
					musicPlayer = new MusicPlayer();
//					musicPlayer.musicStart();
					// 재생버튼 활성화 할지 안할지
					MultiGameButtons.PlayMusicButtonOff.setVisible(false);
					MultiGameButtons.PlayMusicButton.setVisible(true);
				} 
				else if(serverMsg.equals("next")) {
					System.out.println("change flag ......");

					musicPlayer.setFlagIf(true);
					
//					MusicPlayer.num++;
				} 

				else if(serverMsg.startsWith("songRandom ") && !subStr.equals(" ")){
					serverMsg = serverMsg.substring(11);
					StringTZ = new StringTokenizer(serverMsg,"-");
					serverSongRandom = new ArrayList<Integer>();
					while(StringTZ.hasMoreTokens()) {
						String token = StringTZ.nextToken(); // 문자 쪼개기
						int intToken = Integer.valueOf(token); // 숫자로 변경
						serverSongRandom.add(intToken); // 배열에 저장
					}
				}else if(serverMsg.equals("severBufferMusic")) {
					System.out.println("12");
				}
//				else if (subStr.equals(" ")) {
				else {
					serverMsg = serverMsg.substring(0, serverMsg.length() - 1); // 임의로 넣은 " " 제거
					System.out.println(serverMsg);
					MultiGameButtons.setReadChatting(serverMsg);
					if (MultiGameButtons.display != null) { // 첫 생성때는 display가 없으므로 생성 이후부터 적용
						MultiGameButtons.appendChat();
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static boolean isGameIng() {
		return GameIng;
	}

	public static void setGameIng(boolean gameIng) {
		GameIng = gameIng;
	}
}
