package gui.chat;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Button;
import java.awt.Panel;
import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class ChatB extends Frame implements KeyListener{
	TextArea area;
	Panel p_south;
	TextField t_input;
	ChatA ca;

	public ChatB(ChatA ca){ // 생성자 호출 시 주소값을 넘겨야 하므로
										// 이 생성자 메서드를 호출하는 자 call by reference로 호출하는 것.
		area= new TextArea();
		p_south = new Panel();
		t_input = new TextField(30);
		this.ca = ca; // 새롭게 인스턴스를 생성하지 말고, 기존의 ChatA를 넘겨받음
		
		//스타일
		area.setBackground(Color.GRAY);
		
		add(area);
		p_south.add(t_input);
		add(p_south, BorderLayout.SOUTH);
		
		t_input.addKeyListener(this);
		
		setSize(300,400);
		setVisible(true);
	}
	
	public void keyTyped(KeyEvent e) {}
	public void keyPressed(KeyEvent e) {	}
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			System.out.println("CHATB");
			
			String msg = t_input.getText();
			ca.area.append(msg + "\n");
			t_input.setText("");
		}
	}

}