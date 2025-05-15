package use;
import animal.Bird;
import animal.Duck;

class UseDuck
{
	public static void main(String[] args){
		//Bird b = new Duck();
		//b.name = "꽥";
		//b.fly();
		
		Duck d = new Duck();
		d.eat();
		
		Bird b = new Bird();
		b = d; // 가능
		d = (Duck)b; // 상위 자료형을 작은 자료형에 넣을 때 형변환 필요.
	}
}