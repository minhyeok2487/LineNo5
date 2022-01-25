package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
        	serverSocket = new ServerSocket(7777);
			System.out.println("서버가 시작되었습니다.");
			//클라이언트와의 연결 대기 루프
			while( true ){
				System.out.println("새로운 클라이언트의 연결요청을 기다립니다.");
				// 연결되면 통신용 소켓 생성
				socket = serverSocket.accept();
				System.out.println("클라이언트와 연결되었습니다.");
				// 파일 전송용 클래스
				String filePath = "C:/Users/Minhyeok/Desktop/Git/LineNo5/python_MH/audio";
				String fileNm = "9.wav";
				FileSender fs = new FileSender(socket, filePath, fileNm);
				fs.start();
			}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
