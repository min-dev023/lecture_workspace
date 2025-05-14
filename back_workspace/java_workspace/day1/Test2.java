
class Test2 
{
	// 자바의 실행부임. 이 함수가 없다면 java.exe의 대상이 될 수 없다. 즉 실행될 수 없다
	public static void main(String[] args) 
	{
		// 자바도 기존의 언어의 전통을 이어받았기 때문에, 기본 자료형은 문자, 숫자, 논리형 3가지이다.
		int a = 25;
		double b = 25.5;
		// byte < short < int < long
		// float < double
		
		char address = 'a'; // 한글자를 문자형이라고 한다.
		String name = "김민지";
		
		boolean bool = true; // 주의! 다른 언어에서는 1이  true 0이 false 하지만, 자바에서는 X
		
		System.out.println(name);
		System.out.println(a);
	}		
}
