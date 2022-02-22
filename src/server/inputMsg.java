package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import main.gameServer;

public class inputMsg extends Thread {
	private final String next = "next"; // 정답을 맞췄을 시 발송해주는 암호
	private final String sendMsg = "/to"; // 귓속말 명령어
	private final String headMsg="bufferMusic";
	private HashMap<String, gameUser> user = gameServer.getUser();
	public ArrayList<IndexSongName> clientIndexSongNameArr;
	private StringTokenizer st;
	private BufferedReader br;
	private BufferedWriter bw;
	private String userId, msg;
	int count = 0;
	static String severBufferMusic="severBufferMusic";

	public inputMsg(String userId, BufferedReader br, BufferedWriter bw) {
		this.userId = userId;
		this.br = br;
		this.bw=bw;
	}

	@Override
	public void run() {

		while (true) {
			try {
				msg = br.readLine();
				if (msg != null) {
					if (msg.indexOf(sendMsg) == 0) { // 귓속말
						new sendmsg(msg, userId);
						
					} else if (msg.equals(next)) {
						// 다른 사람이 정답을 맞추면 모두에게 다음 문제로 넘어가라고 명령함
						
						if(count < 9) {
							user.get(userId).setScore(1); // 1점증가
							new broadcast(userId + "님 정답! 다음 문제로 넘어갑니다 \n");
	
							new broadcast("next"+"\n");
							
							count++;
						}
						else if(count == 9) { // 마지막문제는 다음문제 코드를 보내지 않는다
						}
					} else if (msg.equals("ready+1")) {
						gameServer.readyCount++; // 레디 시 readyCount +1
						if (gameServer.readyCount == user.size()) {
							// gameServer.readyCount>1 && // 끝나고 추가할 것. 2명 이상일때만 시작
							new songRandom();
							new broadcast("start"+"\n");
						}
					} else if (msg.equals("ready-1")) {
						gameServer.readyCount--; // 레디 취소 시 readyCount -1
						
					}
					else if(msg.startsWith(headMsg)) {
						msg=msg.substring(12);
						st=new StringTokenizer(msg," ");
						clientIndexSongNameArr=new ArrayList<IndexSongName>();
						while(st.hasMoreTokens()) {
							String indexToken=st.nextToken();
							int intIndexToken=Integer.valueOf(indexToken);
							String songNametoken=st.nextToken();
							String stringSongNametoken=songNametoken;
							clientIndexSongNameArr.add(new IndexSongName(intIndexToken, stringSongNametoken));
						}
						clientIndexSongNameArr.remove(0);
						clientIndexSongNameArr.remove(4);
						try {
							ServerTest.compareClientServer();
						} catch (ParseException e) {
							e.printStackTrace();
						}
						ArrayList<ServerIndexSongName> sisn=ServerTest.severIndexSongNameArr;
						ArrayList<IndexSongName> isn=clientIndexSongNameArr;
						
						boolean flag;
						for(int i=0;i<sisn.size();i++) {
							flag=true;
							for(int j=0;j<isn.size();j++) {
								if(sisn.get(i).getSongIndex()==isn.get(j).getSongIndex()&&sisn.get(i).getSongName().equals(isn.get(j).getSongName())) {
									System.out.println();
									 flag=false;
								}
								if(flag==true&&isn.size()-1==j) {
									System.out.println(sisn.get(i).getSongIndex());
									System.out.println(sisn.get(i).getSongName());
								}
							}
						}
					}
					else { // 채팅이라면 채팅발송
						new broadcast(userId + " >>> " + msg + "\n");
					}
				}
			} catch (IOException e) {
				if (br != null)
					try {
						br.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
			}
		}
	}
}
