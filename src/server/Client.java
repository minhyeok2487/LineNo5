package server;

import java.io.IOException;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		String serverIp = "192.168.1.35";
		Socket socket = null;
		try {
			// 서버연결
			socket = new Socket(serverIp, 7777);
			System.out.println("서버에 연결되었습니다.");
			// 파일 수신용 클래스 생성 및 시작
			Receiver receiver = new Receiver(socket);
			receiver.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
