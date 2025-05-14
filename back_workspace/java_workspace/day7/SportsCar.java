class SportsCar 
{
	String color = "None Color";
	
	public SportsCar(String color) {
		this.color = color;
		System.out.println(color);
	}
	
	public void setColor() {
		this.color = "red";
		System.out.println(color);
	}
		
}

class UseCar
{
	public static void main(String[] args) {
		SportsCar car = new SportsCar("red");
		
		car.setColor();
		
	}
}