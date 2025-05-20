package gui.event;
import java.awt.*;
import gui.event.day0520.MyActionListener;

public class DoubleButton 
{
	public static void main(String[] args) 
	{
		Frame frame = new Frame();
		Button btn1 = new Button("A");
		Button btn2 = new Button("B");
		
		frame.setLayout(new FlowLayout());
		frame.add(btn1);
		frame.add(btn2);
		
		MyActionListener my = new MyActionListener(btn1, btn2);
		
		btn1.addActionListener(my); // 버튼 1과 리스너 연결
		
		btn2.addActionListener(my); // 버튼 2과 리스너 연결
		
		frame.setSize(300,400);
		frame.setVisible(true);
	}
}
