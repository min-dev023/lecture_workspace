/*
자동차 클래스로부터 인스턴스 1개를 생성하여 
자동차의 핸들의 색상, 바퀴의 브랜드명, 문짝의 열기 기능을 호출
*/
package use;

class UseCar 
{
	public static void main(String[] args) 
	{
		Car c = new Car();
		
		/*
		c.handle = new Handle();
		c.wheel = new Wheel();
		c.door = new Door();

		System.out.println("핸들의 색깔 : " + c.handle.color);
		System.out.println("바퀴의 브랜드 : " + c.wheel.brand);
		// 문짝 열기
		c.door.open();
		
		c.price = 500;
		System.out.println(c.price);
		*/
		
		System.out.println("핸들의 색깔 : " + c.handle.color);
		System.out.println("바퀴의 브랜드 : " + c.wheel.brand);
		// 문짝 열기
		c.door.open();
		
		c.price = 500;
		System.out.println(c.price);
	}
}
