package use;
import instrument.Keyboard;
import instrument.Bass;
import instrument.Cello;
import instrument.Drum;
import instrument.Guitar;
import instrument.Piano;
import instrument.Trumpet;
import instrument.Violin;
import instrument.MusicTool;
import riding.Roller;

class  UseTool
{
	public static void main(String[] args) 
	{
		Keyboard k = new Keyboard();
		k.play();
		
		Bass bass;
		
		//Trumpet trum = new Trumpet();
		//trum.setVolumn(22);
		
		
		// 오케스트라 합주.. 모든 악기를 한꺼번에 볼륨을 조절
		// 각 악기가 보유한 메서드가 무엇인지 알 수 없음
		// 메서드명의 일관성 X 
		// 기술적으로 개발자들에게 제재를 가해야함.
		// 따라서 가이드 라인 제시...
		
		// 추상 클래스는 인스턴스화 될 수 없다
		// MusicTool mt = new MusicTool();
		
		MusicTool p = new Piano();
		p.setVolume();
		
		// 인터페이스도 is-a 관계로 인정받음, 따라서 형변환 가능
		Roller p2 = new Piano();
		p2.roll();
		
		Drum d = new Drum();
		d.setVolume();
		
		
		
	}
}
