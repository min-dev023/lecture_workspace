/*
java gui에서도 사용자의 반응에 대한 이벤트 처리가 가능함
하지만 js에서의 처리보다 훨씬 복잡함
html에서는 클릭이벤트는 click
java에서는 클릭 이벤트라는 용어 없음 action에 소속.
*/
package gui.event;
import java.awt.*;

public class ActionTest 
{
	public static void main(String[] args) 
	{
		Frame frame = new Frame();
		Button bt = new Button("click me");
		TextField t = new TextField(20);
		Choice ch = new Choice(); // html에서의 select 박스
		
		ch.addItem("choose your mail server");
		ch.addItem("@naver.com"); //html 에서의 <option>
		ch.addItem("@google.com");
		ch.addItem("@daum.net");
		
		// js에서처럼, bt.addEventListener() 메서드를 버튼에 연결하는 과정을 동일하게 진행
		bt.addActionListener(new MyActionListener()); // <- 이벤트를 구현한 객체의 인스턴스 
		// TextField와 Listener와의 연결
		t.addKeyListener(new MyKeyListener()); 
		ch.addItemListener(new MyaddItemListener());
		frame.addMouseListener(new MyMouseListener());
		
		frame.setLayout(new FlowLayout());
		frame.add(bt);
		frame.add(t);
		frame.add(ch);
		
		frame.setSize(300,400);
		frame.setVisible(true);
	}
}
