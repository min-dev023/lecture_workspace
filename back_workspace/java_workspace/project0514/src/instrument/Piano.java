package instrument;
import riding.Roller;
// 이미 정의된 악기들의 최상위 클래스인 MusicTool를 상속받자
// 추상메서드를 완전하게 구현할 의무를 가진다 (강제 구현)
public class Piano extends MusicTool implements Roller
//abstract public class Piano extends MusicTool
{
	// 부모의 메서드를 자식이 재정의 하는 메서드 정의기법
	// 즉 오버라이딩 의무가 생긴다.
	public void setVolume()
	{
		System.out.println("피아노의 볼륨 UP");
	}
	
	public void roll(){
		System.out.println("피아노를 굴려요");
	}
	
}
