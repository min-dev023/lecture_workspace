class Member { //A
	int age=23;
	static int money=23;
	
	public void talk(){
	}
}

public class UseMember{
	static String k=8;
	public static void main(String[] args){
		UseMember.k = 0; // 가능
		
		// k는 메인과 UseMember가 static 이면서 같은 클래스 안에 있을 경우 바로 사용가능
		k = 10; 
	}
}
