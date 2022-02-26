package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.StringTokenizer;

import music.MusicPlayer;
import view.MultiGameButtons;

public class gameClientReadMsg extends Thread implements GameInterface {
	Socket socket = gameClient.getSocket();
	BufferedReader br;
	MusicPlayer musicPlayer;
	public static ArrayList<Integer> serverSongRandom;
	public static boolean flag = true;
	StringTokenizer StringTZ;

//	public static void setFlag(boolean flag) {
//		gameClientReadMsg.flag = flag;
//	}

	public gameClientReadMsg(BufferedReader br) {
		this.br = br;
		start();
	}

	public void kill_self() {
		synchronized (this) {
			this.stop();
		}
	}

	@Override
	public void run() {
		while (flag) {
			try {
				String serverMsg = br.readLine();
				String subStr = serverMsg.substring(serverMsg.length() - 1);
				if (serverMsg.equals("start")) {
					musicPlayer = new MusicPlayer();
				} else if (serverMsg.equals("readybutton")) {

					MultiGameButtons.ReadyButton.setVisible(false);
				}

				else if (serverMsg.equals("next")) {
					System.out.println("change flag ......");

					musicPlayer.setFlagIf(true);
				}

				else if (serverMsg.startsWith("score") && !subStr.equals(" ")) {
					new scoreAll(serverMsg);

				}

				else if (serverMsg.equals("clear")) {
					// 결과창 호출
					musicPlayer.setFlagClear(true);
				}

				else if (serverMsg.startsWith("userList-") && !subStr.equals(" ")) {
					new gameUserList(serverMsg);
				} else if (serverMsg.startsWith("songRandom ") && !subStr.equals(" ")) {
					serverMsg = serverMsg.substring(11);
					StringTZ = new StringTokenizer(serverMsg, "-");
					serverSongRandom = new ArrayList<Integer>();
					while (StringTZ.hasMoreTokens()) {
						String token = StringTZ.nextToken(); // 문자 쪼개기
						int intToken = Integer.valueOf(token); // 숫자로 변경
						serverSongRandom.add(intToken); // 배열에 저장
					}
				}
//				else if (subStr.equals(" ")) {
				else {
					serverMsg = serverMsg.substring(0, serverMsg.length() - 1); // 임의로 넣은 " " 제거
					System.out.println(serverMsg);

					MultiGameButtons.setReadChatting(serverMsg);
					if (MultiGameButtons.display != null) { // 첫 생성때는 display가 없으므로 생성 이후부터 적용
						MultiGameButtons.appendChat();
						// JFRAME.appendChat();
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
