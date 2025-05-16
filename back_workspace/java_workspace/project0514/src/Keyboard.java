package instrument;

public class Keyboard
{
	int vol = 5;
	String pMp3 = "정지";
	public void volUp() {
		vol += 1;
		System.out.println("볼륨 up : " + vol);
	}
	public void volDown() {
		vol += 1;
		System.out.println("볼륨 down : " + vol);
	}
	
	public void play() {
		pMp3 = "재생";
		System.out.println(pMp3);
	}
	public void stop() {
		pMp3 = "정지";
		System.out.println(pMp3);
	}
}
