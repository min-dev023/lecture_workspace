class Duck {
	int age = 5;
	
	
	public static void main(String[] args) {
		
		// Duck 클래스는 자체는 오리를 생성할 수 있는 틀에 불과하지 자체가 오리가 아님
		// 따라서 사용하려면 반드시 인스턴스를 생성한 후 해당 인스턴스를 접근해야 한다.
		Duck d = new Duck();
		// age 변수 값을 출력.
		System.out.println(d.age);
	}
}