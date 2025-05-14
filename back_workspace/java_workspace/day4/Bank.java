class Bank {
	String name ="하나은행";
	String user ="Adams";
	int money = 1000;
	
	public void in(int a){
		money += a;
	}
	
	public void out(int b){
		money -= b;
	}
}