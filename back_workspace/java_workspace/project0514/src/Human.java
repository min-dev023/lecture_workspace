/*
OOP에서는 클래스 정의 시 중복되는 코드의 재사용을 위해서는 상속이라는 클래스
정의법을 이용할 수 있다.

parent : GUI 프로그래밍에서 컨테이너 <---> child
super : 상속 관계에서의 부모 객체 <---> sub
*/
package human;

class Human
{
	String skinColor;
	int leg = 2;
	
	public void intellecThink() {
		System.out.println("생각하기.");
	}
}
