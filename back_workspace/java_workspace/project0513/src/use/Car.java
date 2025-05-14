package use;
public class Car
{
	int price;
	String name;
	
	// 객체가 다른 객체를 멤버 변수로 보유한 관계를 has a 관계라 한다.
	Handle handle; // Has-A 관계 -> Car has a Handle
	Wheel wheel;
	Door door;
	
	// 생성자는 사물을 태어나게 하는 시점에, 초기화에 관여하므로
	// 특히 has-a 관계에 있는 객체의 인스턴스 생성할 때 유용함
	
	public Car() { // js constructor() 동일 목적
		price = 5000;
		name = "제네시스";
		handle = new Handle();
		wheel = new Wheel();
		door = new Door();		
	}
}
