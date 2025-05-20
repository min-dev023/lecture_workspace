package gui.chat;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Button;
import java.awt.Panel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class ChatA extends Frame implements ActionListener, KeyListener{
								/*     Is-A                           Is-A       */
	TextArea area;
	Panel p_south;
	TextField t_input;
	Button bt_open;
	ChatB cb;
	
	public ChatA(){
		area= new TextArea();
		p_south = new Panel();
		t_input = new TextField(30);
		bt_open = new Button("열기");
		
		//스타일
		area.setBackground(Color.YELLOW);
		
		add(area);
		p_south.add(t_input);
		p_south.add(bt_open);
		add(p_south, BorderLayout.SOUTH);
		
		// 버튼과 리스터인 것과 연결
		bt_open.addActionListener(this);
		
		// 텍스트필드와 리스너인 것과 연결
		t_input.addKeyListener(this);
		
		setSize(300,400);
		setVisible(true);
	}
	
	// ActionListener를 구현하겠다고 선언하였으므로, 현재 클래스에서 인터페이스의
	// 메서드를 오버라이딩.
	public void actionPerformed(ActionEvent e) {
		System.out.println("누름");
		cb = new ChatB(this);
	}
	
	// KeyListener의 메서드를 재정의
	public void keyTyped(KeyEvent e) { // keyup
	}
	public void keyPressed(KeyEvent e) {	}
	public void keyReleased(KeyEvent e) { // keydown
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			// ChatB가 보유한 area의 텍스트 값을 원하는 값으로 넣기
			//cb.area.setText("AAA"); -> 중첩되어버림.
			
			// 나의 텍스트필드 값을 얻어서 전달
			String msg = t_input.getText();
			cb.area.append(msg + "\n");
			// 나의 텍스트필드 다시 지우기
			t_input.setText("");
		}
	}
	
	public static void main(String[] args) {
		new ChatA();
	}
}