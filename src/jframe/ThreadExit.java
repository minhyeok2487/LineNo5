package jframe;

import clientChat.gameClientReadMsg;
import clientChat.gameUserList;
import clientChat.scoreAll;
import view.MainFrame;
import view.buttonsGUI.userNames;

public class ThreadExit {

	public ThreadExit() throws Exception {
		gameClientReadMsg.serverSongRandom.clear();
		gameClientReadMsg.interrupted();
		// 타이머 있으면 타이머도 끄기!!
		// Game.interrupted(); 혹시 몰라
		// MusicPlayer.interrupted(); 혹시 몰라
		// 메인버튼 클라스 쓰레드 임시 보류
		userNames.flag = false;
		MainFrame.introMusic.close();
		gameUserList.gameUserName.clear();
		scoreAll.userScore.clear();

		
		//gameClient.getSocket().close(); // 맨마지막으로 옮기기!
	}

}
