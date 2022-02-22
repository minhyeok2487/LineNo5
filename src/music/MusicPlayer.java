package music;

import java.io.BufferedWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import clientChat.gameClient;
import clientChat.gameClientReadMsg;
import view.VolumnButtons;
import view.buttonsGUI.MultiGameButtons;

public class MusicPlayer extends Thread {
	public static Clip ParentSong = null;
	public static long clipTime;
	public static FloatControl volume = null;
	public static int init = 0;
	public static String musicjsonpath = "src\\music\\song_json_data.json";
	MusicInfo musicPath;
	ArrayList<MusicInfo> listInfo = new ArrayList<>();
	ArrayList<Integer> songRandomIntList = gameClientReadMsg.serverSongRandom;
	public int num = 0;
	public boolean flagIf;
	public boolean flag;

	public MusicPlayer() {
		listInfo = initializeMusic();
		start();
	}
	
	public boolean getFlag() {
		return flagIf;
	}
	
	public void setFlagIf(boolean flagIf) {
		this.flagIf = flagIf;
	}
	
	@Override
	public void run() {
		flagIf = true;
		
		int index = 0;
		while(index < 10) {
			flag = getFlag();

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(flagIf) {
				if(ParentSong != null) {
					ParentSong.stop();
				}
				musicPath = null;
				musicPath = getMusicListInfo().get(songRandomIntList.get(index));
				ParentSong = musicStart(musicPath);
				ParentSong.start();
				clipTime = ParentSong.getMicrosecondPosition();
				volume = (FloatControl) ParentSong.getControl(FloatControl.Type.MASTER_GAIN);
				if(init == 0) { //처음 소리 크기 지정
					volume.setValue(-10.0f);
				}
				switch (VolumnButtons.N) {
				case 0: {volume.setValue(-20.0f); break;}
				case 1: {volume.setValue(-18.0f); break;}
				case 2: {volume.setValue(-16.0f); break;}
				case 3: {volume.setValue(-14.0f); break;}
				case 4: {volume.setValue(-12.0f); break;}
				case 5: {volume.setValue(-10.0f); break;}
				case 6: {volume.setValue(-8.0f); break;}
				case 7: {volume.setValue(-6.0f); break;}
				case 8: {volume.setValue(-4.0f); break;}
				case 9: {volume.setValue(-2.0f); break;}
				case 10: {volume.setValue(0.0f); break;}
				}
				new Game(musicPath);
				flagIf = false;
				index++;
			}
			
		}
		
		if(index == 10) {
			// 점수 결과 창으로
		}
		// 숫자 10개 돌면 게임 끝
		System.out.println("게임 끝");

	}

	public synchronized ArrayList<MusicInfo> initializeMusic() {
		JSONMusicParser parser = new JSONMusicParser();
		JSONArray array = parser.getJsonArray(musicjsonpath);
		ArrayList<MusicInfo> musicInfo = new ArrayList<MusicInfo>();
		for (int i = 0; i < array.size(); i++) {
			JSONObject musicObject = (JSONObject) array.get(i);
			String url = musicObject.get("url").toString();
			String song = musicObject.get("song").toString();
			String singer = musicObject.get("singer").toString();
			String path = musicObject.get("path").toString();
			String songHint = musicObject.get("songHint").toString();
			String singerHint = musicObject.get("singerHint").toString();
			musicInfo.add(new MusicInfo(url, song, singer, path, songHint, singerHint));
		}
		return musicInfo;
	}

	public ArrayList<MusicInfo> getMusicListInfo() {
		if (listInfo == null) {
			listInfo = initializeMusic();
		}
		return listInfo;
	}

//	public void restartMusic() {
//		songRandomIntList.clear();
//	}
	
	public Clip musicStart(MusicInfo musicPath) {
		File musicFile = new File(musicPath.path);
		Clip c = null;
		try {
			AudioInputStream b = AudioSystem.getAudioInputStream(musicFile);
			c = AudioSystem.getClip();
			c.open(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

}