// java.exe의 대상이 되러면, 반드시 실행부인 main() 메서드가 존재해야함
class ObjectType {
	public static void main(String[] args){
		
		int x = 5;
		
		// 고정관념에서 벗어나자, 자바에서는 개발자가 정의한 클래스를 새로운 자료형으로 인정해준다.
		// 다라서 아래의 코드에서 변수 d 앞에 선언해야 하는 자료형은 내가 정의한 Dog형이다.
		Dog dog = new Dog();
		
		dog.bark();
		
		Car c = new Car();
		System.out.println("차의 색상 : " + c.color);
		System.out.println("차의 가격 : " + c.fee);
		
		Plane p = new Plane();
		System.out.println("비행기의 기종 : " + p.name);
		System.out.println("비행가능 여부 : " + p.fly);
		
		Dev d = new Dev();
		System.out.println("개발자의 이름: " + d.name);
		System.out.println("개발자의 나이 : " + d.age);
		
		Mario m = new Mario();
		System.out.println("마리오의 기능: " + m.arrMario[0] + ", " + m.arrMario[1]);
		System.out.println("마리오의 옷 색깔 : " + m.color);
		
		Tree t = new Tree();
		System.out.println("나무의 잎 개수: " + t.leaf);
		System.out.println("나무의 높이: " + t.high);
		t.water();
		System.out.println("나무의 높이: " + t.high);
		
		Bank bank = new Bank();
		System.out.println("은행의 이름 : " + bank.name);
		System.out.println("계좌주 이름 : " + bank.user);
		System.out.println("계좌 잔액 : " + bank.money);
		
		bank.in(2000);
		System.out.println("입금 2000 - 계좌 잔액 : " + bank.money);
		
		bank.out(1000);
		System.out.println("출금 1000- 계좌 잔액 : " + bank.money);
		
	}
}