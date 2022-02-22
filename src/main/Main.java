package main;

import java.net.UnknownHostException;

import javax.swing.JFrame;

import view.MainFrame;

public class Main {
	public static JFrame MA;
	public static void main(String[] args) throws UnknownHostException {
		MA = new MainFrame(); // 클라이언트 게임 실행
	}

}
