package designpatterns.structural_patterns;

public class AdapterTest {

	public static void main(String[] args) {
		Player player=new MyPlayer();
		player.play("flv", "Infinity war");
	}
}

interface Player {
	void play(String type, String fileName);
}

interface AudioPlayer {
	void playAudio(String fileName);
}

interface VideoPlayer {
	void playVideo(String fileName);
}

class MyAudioPlayer implements AudioPlayer{

	@Override
	public void playAudio(String fileName) {
		System.out.println("playing audio:"+ fileName);
	}
}

class MyVideoPlayer implements VideoPlayer {

	@Override
	public void playVideo(String fileName) {
		System.out.println("playing video:"+ fileName);
	}
}

class MyPlayer implements Player {

	AudioPlayer audio=new MyAudioPlayer();
	VideoPlayer video=new MyVideoPlayer();
	
	@Override
	public void play(String type, String fileName) {
		if("mp3".equals(type)){
			audio.playAudio(fileName);
		} else if ("flv".equals(type)){
			video.playVideo(fileName);
		} else {
			System.out.println("unknown type");
		}
	}
}