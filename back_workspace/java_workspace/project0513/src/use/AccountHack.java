package use;

class AccountHack 
{
	public static void main(String[] args) 
	{
		Account acc = new Account();
		acc.balance = 0;
		
		System.out.println(acc.balance);
	}
}
