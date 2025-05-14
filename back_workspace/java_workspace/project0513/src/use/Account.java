/*
객체지향 언어의 장점
1) 캡슐화
2)
3) 
*/
package use;

class Account
{
	private String num = "110-444-444444";
	private String bank = "신한은행";
	private String owner = "Minji";
	private int balance = 70000000;
	
	/*
		클래스 작성 시 데이터를 보호하고 이 보호된 데이터를 외부에서 사용하게 해주려면,
		공개된 메서드를 제공해줘야 하는데, 이러한 클래스 정의 기법을 은닉화(encapsulation)
		
		데이터에 대해 읽기, 쓰기가 가능하도록 메서드 정의
	*/
	
	public int getBalance() { // getter method -> get + 멤버변수조합
		return balance;
	}
	public void setBalance() { // setter method
		this.balance = balance;
	}
	
	public String getBank() {
		return bank;
	}
	public void setBank() {
		this.bank = bank;
	}
	
	public String getOwner() {
		return owner;
	}
	public void setOwner() 
		this.owner = owner;
	}
	
	public String getNum() {
		return num;
	}
	public void setNum() 
		this.num = num;
	}
}
